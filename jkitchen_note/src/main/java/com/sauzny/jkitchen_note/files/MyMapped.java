package com.sauzny.jkitchen_note.files;

import com.sauzny.jkitchen_note.Print;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.List;

public class MyMapped {

    public static void read(){

        Path path = Paths.get("files/properties.cnf");
        Charset charset = StandardCharsets.UTF_8;

        try (FileChannel fc = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            // 要映射100到299(包含299)位置的字节，可以使用下面的代码：
            // buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 100, 200);

            // MapMode 模式说明：
            // MapMode.READ_ONLY 和 MapMode.READ_WRITE意义明显
            // 模式MapMode.PRIVATE表示想要一个写时拷贝(copy-on-write)的映射。
            // 这意味着通过put()方法所做的任何修改都会导致产生一个私有的数据副本并且该副本中的数据只有MappedByteBuffer实例可以看到。
            // 该过程不会对底层文件做任何修改。
            // 尽管写时拷贝的映射可以防止底层文件被修改，但也必须以read/write权限来打开文件以建立MapMode.PRIVATE映射。
            // 只有这样，返回的MappedByteBuffer对象才能允许使用put()方法。
            long fileLength = path.toFile().length();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, fileLength);

            // 读文件 1
            byte[] bytes1 = new byte[mbb.capacity()];
            while (mbb.hasRemaining()){
                bytes1[mbb.position()]=mbb.get();
            }
            System.out.println(new String(bytes1, charset));

            // 读文件 2
            mbb.rewind();
            CharBuffer charBuffer = charset.decode(mbb);
            System.out.println(charBuffer.toString());

            // 关闭资源
            // 映射文件可能需要unmap释放，使用反射执行unmap
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(){

        Path path = Paths.get("files/writeMappedByteBuffer.txt");
        Charset charset = StandardCharsets.UTF_8;
        CharBuffer charBuffer = CharBuffer.wrap("a");
        try (FileChannel fc = FileChannel.open(path, EnumSet.of(
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE)))
        {
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, charBuffer.length());

            // 写文件
            mbb.put(charset.encode(charBuffer));
            Print.hr("写入文件后");

            // 这行代码，搞笑了，哈哈
            // 是为了解决idea的缓存问题，使用MappedByteBuffer写文件之后，idea不会自动更新文件内容
            // 试过增加一个空字符串""，也不行
            // 所以在这追加一个换行符
            Files.write(path, System.getProperty("line.separator").getBytes(charset), StandardOpenOption.APPEND);

            // 读文件
            List<String> list = Files.readAllLines(path, charset);
            list.forEach(System.out::println);

        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        MyMapped.read();
        MyMapped.write();
    }
}
