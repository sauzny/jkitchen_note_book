package org.example.lab.jdk15;

public class Solution378 {
    public static void main(String[] args) {
        String textBlock = """
    Hello,
    This is a multi-line
    text block.
    """;
        System.out.println(textBlock);

        String indentedBlock = """
        This is an indented block
        with leading and trailing spaces.
        """.stripIndent();

        System.out.println(indentedBlock);

    }
}
