package com.sauzny.jkitchen_note.files.tree;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class TreeEngineTest {

    public static void main(String[] args) {
        TreeNode node = new TreeNode("1","2");
        List<TreeNode> list = Lists.newArrayList();
        Set<TreeNode> set = Sets.newHashSet();
        set.add(new TreeNode("ppath","name1"));
        set.add(new TreeNode("ppath","name2"));
        set.add(new TreeNode("ppath1","name"));
        set.add(new TreeNode("ppath1","name1"));
        set.add(new TreeNode("ppath1","name1"));

        list.add(node);
        set.add(node);

        node.setName("update");

        System.out.println(list);
        System.out.println(set);
    }
}
