package com.sauzny.jkitchen_note.files.tree;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class TreeEngine {

    public static TreeNode getTree(){

        TreeNode root = new TreeNode();

        List<String> lines = TreeEngine.testFile();

        // key - 父亲路径 valueList - nodeList
        SetMultimap<String, TreeNode> listMultimap = HashMultimap.create();

        // 所有的非叶节点
        Set<TreeNode> set = Sets.newHashSet();

        // 遍历文件内容，并为 listMultimap 和 set 赋值
        lines.forEach(line -> {

            int lastIndex = line.lastIndexOf("-");

            while (lastIndex != -1){

                String ppath = line.substring(0, lastIndex);
                String name = line.substring(lastIndex+1).split("-")[0];

                TreeNode node = new TreeNode(ppath, name);

                listMultimap.put(ppath, node);

                if(!name.endsWith("leaf")){
                    set.add(node);
                }

                lastIndex = ppath.lastIndexOf("-");

                // 处理每一行的第一级目录节点
                if(lastIndex == -1){
                    TreeNode one = new TreeNode("root", ppath);
                    listMultimap.put("root", one);
                    set.add(one);
                }
            }

        });

        //System.out.println(listMultimap);
        //System.out.println(set);

        // 遍历 set ，将所有的node按照父路径组合起来
        set.forEach(node -> {
            String cpath = node.getPpath() + "-" + node.getName();
            if(cpath.startsWith("root-")){
                cpath = cpath.split("-")[1];
            }
            node.getNodeList().addAll(listMultimap.get(cpath));
            //System.out.println(cpath + " = " + listMultimap.get(cpath));
            node.getNodeList().sort(Comparator.comparing(TreeNode::getName));
        });

        root.getNodeList().addAll(listMultimap.get("root"));

        return root;
    }

    private static List<String> testFile(){
        List<String> lines = Lists.newArrayList();
        Path path = Paths.get("files/tree/testTree.txt");
        Charset charset = StandardCharsets.UTF_8;
        try {
            lines = Files.readAllLines(path, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        TreeEngine.getTree();
        long a = System.currentTimeMillis();
        TreeNode root = TreeEngine.getTree();
        System.out.println(System.currentTimeMillis() - a);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            System.out.println(mapper.writeValueAsString(root.getNodeList()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
