package com.sauzny.tooljdk.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/***************************************************************************
 *
 * @时间: 2019/1/30 - 13:35
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class CmdUtils {

    public static Process execCommand(List<String> execList) {
        for (int i = 0; i < execList.size(); i++) {
            System.out.print(execList.get(i) + " ");
        }
        try {
            Process ps = Runtime.getRuntime().exec(execList.toArray(new String[execList.size()]));
            return ps;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static Process execCommand(String arstringCommand) {
        try {
            Process ps = Runtime.getRuntime().exec(arstringCommand);
            return ps;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void cmd(List<String> commandList){
        //打开记算器
		/*
		String[] arstringCommand = new String[] {
				"cmd",
				"/k",
				"start", // cmd Shell命令
				"calc"
		};
		*/
        List<String> execList = new ArrayList<String>();
        execList.add("cmd");
        execList.add("/k");
        for(String command : commandList){
            execList.add(command);
        }
        execCommand(execList);
        //打开记事本
		/*
		String cmd = "cmd /k start notepad";
		execCommand(cmd);
		*/
    }

    public static void cmd(String message) throws IOException {
        execCommand("cmd /k " + message);
    }

    public static String cmdWithResult(String message) throws IOException{
        Process ps = execCommand(message);

        BufferedReader br=new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }

    public static String getStartTime() throws IOException{
        String resultStr = CmdUtils.cmdWithResult("systeminfo").trim();
        String[] resultArray = resultStr.split("\n");
        for(String result : resultArray){
            if(result.contains("系统启动时间")){
                return result;
            }
        }
        return "";
    }

    public static void main(String[] args) throws Exception {

        System.out.println(CmdUtils.getStartTime());
    }
}
