package com.sauzny.jkitchen_note.files.tree;

import com.google.common.collect.Lists;

import java.util.List;

public class TreeNode {

    // 父亲路径
    private String ppath;

    private String name;

    private List<TreeNode> nodeList = Lists.newArrayList();

    public TreeNode() {
    }

    public TreeNode(String ppath, String name) {
        this.ppath = ppath;
        this.name = name;
    }

    public String getPpath() {
        return ppath;
    }

    public void setPpath(String ppath) {
        this.ppath = ppath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<TreeNode> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public int hashCode() {
        return (this.ppath + "-" + this.name).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            TreeNode treeNode= (TreeNode) obj;
            return this.ppath.equals(treeNode.getPpath()) && (this.name.equals(treeNode.getName()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + this.ppath + "-" + this.name + "]";
    }
}
