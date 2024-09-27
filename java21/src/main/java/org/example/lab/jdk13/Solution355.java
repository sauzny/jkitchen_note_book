package org.example.lab.jdk13;

public class Solution355 {
    public static void main(String[] args) {

        // 基本的文本块：
        String htmlContent = """
    <html>
        <body>
            <h1>Hello, JDK 13!</h1>
        </body>
    </html>
""";
        System.out.println(htmlContent);

        // 转义字符的处理：
        String escapedText = """
    This is a \n new line.
""";
        System.out.println(escapedText);

        // 引号的处理：
        String quote = """
    She said, "Java is awesome!"
""";
        System.out.println(quote);


        // 保留缩进的控制：
        String indentedText = """
    This is a
    multiline
    text with
    indentation.
""";
        System.out.println(indentedText);
    }
}
