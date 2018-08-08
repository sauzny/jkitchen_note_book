package com.sauzny.jkitchen_note.antlr.json;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.sauzny.jkitchen_note.antlr.json.expr.SimpleJsonLexer;
import com.sauzny.jkitchen_note.antlr.json.expr.SimpleJsonParser;

public class Main {
    public static void main(String[] args) throws Exception {  
        // create a CharStream thatreads from standard input  
        String inputFile = System.getProperty("user.dir") + "/json.txt";  
        InputStream is = System.in;  
         
        if ( inputFile!=null ) is = new FileInputStream(inputFile);  
        ANTLRInputStream input = new ANTLRInputStream(is);  
         
        SimpleJsonLexer lexer = new SimpleJsonLexer(input);  
        CommonTokenStream tokens = new CommonTokenStream(lexer);  
        SimpleJsonParser parser = new SimpleJsonParser(tokens);  
        ParseTree tree = parser.prog(); // parse  
        SimpleJsonVisitorImpl sj = new SimpleJsonVisitorImpl();  
        String map = sj.visit(tree);  
        System.out.println(map);
        sj.memory.forEach((key, value) -> {
            System.out.println(key + " | " + value);
        });
        //sj.visitPrintKeyAndValue(ctx);
     } 

}
