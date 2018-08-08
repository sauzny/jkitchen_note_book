package com.sauzny.jkitchen_note.antv;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.sauzny.jkitchen_note.antv.g6.Edge;
import com.sauzny.jkitchen_note.antv.g6.G6;
import com.sauzny.jkitchen_note.antv.g6.Node;

public class G6Main {

    @Test
    public void foo01(){
        
        G6 g6 = new G6();
        
        Node n1 = new Node();
        
        
        Node n2 = new Node();
        
        Edge e1 = new Edge();
        
        g6.setNodes(Lists.newArrayList(n1, n2));
        g6.setEdges(Lists.newArrayList(e1));
        /*
        String jsonStr = JsonMapper.nonEmptyMapper().toJson(g6);
        System.out.println(jsonStr);
        
        String str = "aaa.bbb";
        String dian = "\\.";
     
        System.out.println(str.split(dian)[0]);
        */
       
    }
}
