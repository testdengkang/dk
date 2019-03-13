package com.nged.algorithm.search.binaryTreeSearch;

/**
 * @author: Administrator
 * @Date: 2019/3/13 15:39
 * @Description: 二叉树节点结构
 */
public class TreeNode {
    /**
     * 节点值
     */
    public Integer value;
    /**
     * 左子
     */
    public TreeNode leftChildNode;
    /**
     * 右子
     */
    public TreeNode rightChildNode;
    /**
     * 父节点
     */
    public TreeNode parentNode;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(TreeNode leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public TreeNode getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(TreeNode rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }
}
