package com.sauzny.jkitchen_note.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * *************************************************************************
 * @文件名称: ReadLog.java
 *
 * @包路径  : com.sauzny.jkitchen_note.fileio 
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   指定读取倒数第几行内容
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年9月11日 - 下午5:37:27 
 *	
 **************************************************************************
 */
public class ReadLog {

    /**
     * @描述: 倒数读取日志
     * @param fullPath  日志位置
     * @param targetNum 从倒数第几行开始读取
     * @return
     * @返回 List<String>
     * @创建人  ljx 创建时间 2017年9月13日 上午9:21:00
     */
    public static List<String> readReciprocalLine(String fullPath, int targetNum){
        
        List<String> lines = Lists.newArrayList();
        
        // 记录每个 换行符 的游标位置
        List<Integer> targetSeeks = Lists.newArrayList();
        
        try (RandomAccessFile raf = new RandomAccessFile(fullPath, "r")) {
            
            // 将游标设置在文件的末尾
            int currentSeek = new Long(raf.length()).intValue();

            for(int i=0; i<raf.length(); i++){
                
                // 修改游标位置，向前一位
                currentSeek--;
                
                //System.out.println(currentSeek);
                // 移动文件指针位置 
                raf.seek(currentSeek); 
                
                // 读取游标所在的内容
                String tempStr = new String(new byte[]{raf.readByte()});
                
                // 如果是换行符
                if(tempStr.equals("\n")){
                    
                    // 加入结果list中
                    targetSeeks.add(currentSeek); 
                    
                    // 读取了所需的行数，停止循环
                    if(targetSeeks.size() == targetNum+1){
                        break;
                    }
                }
                
            }
            
            // 从换行符位置开始，读取一行内容
            for(int targetSeek : targetSeeks){
                raf.seek(targetSeek+1);
                String line = raf.readLine();
                if(StringUtils.isNotBlank(line)){
                    lines.add(new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                }
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return lines;
    }

    
    /**
     * @描述: 从指定位置，读到文件末尾
     * @param fullPath
     * @param seek
     * @return
     * @返回 List<String>
     * @创建人  ljx 创建时间 2017年9月13日 上午10:40:34
     */
    public static List<String> readSeek2end(String fullPath, int seek){
        
        List<String> lines = Lists.newArrayList();
        
        try (RandomAccessFile raf = new RandomAccessFile(fullPath, "r")) {
            
            int currentSeek = seek+1;
            
            raf.seek(currentSeek);
            
            while(raf.read() > 0){
                String line = raf.readLine();
                if(StringUtils.isNotBlank(line)){
                    lines.add(new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                }
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return lines;
        
    } 
    
    @Test
    public void foo01() {
        
        String fullPath = "E:/data/log/TestWeb.log.2017-09-11.0.log";

        int targetNum = 3;

        List<String> lines = readSeek2end(fullPath, targetNum);
        
        for(String line : lines){
            System.out.println(line);
        }
    }
}
