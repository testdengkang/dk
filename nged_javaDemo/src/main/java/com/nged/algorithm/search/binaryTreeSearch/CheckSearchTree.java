package com.nged.algorithm.search.binaryTreeSearch;


/**
 * @author: dengk
 * @Description: 验证二叉树是不是搜索树
 */
public class CheckSearchTree {
    //根节点
    public static TreeNode root;

    public static double lastVal = -Double.MAX_VALUE;

    /**
     *
     * 根据二叉搜索树的中序遍历结果是递增队列这一性质，对二叉树进行中序遍历，每次只记录最大值，遍历过程中判断队列是否保持递增
     * 该方法时间复杂度满足O(n);
     * @param node
     * @return
     */
    public static boolean ldrCheck(TreeNode node){

        if(null!=node){
            if(null!=node.leftChildNode){
                if(!ldrCheck(node.leftChildNode)){
                    return false;
                }
            }
            //判断新加入节点是否能保持队列递增
             if(node.value>lastVal){
                 lastVal = node.value;
             }else{
                 return false;
             }

            if(null!=node.rightChildNode){
                if(!ldrCheck(node.rightChildNode)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 手动创建一个二叉树
     *          20
     *          /\
     *         8  30
     *        /\
     *       6  9
     *          \
     *          21
     */
    public static void createTree(){
         root = new TreeNode(20);
        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(30);
        root.leftChildNode = node11;
        root.rightChildNode =node12;
        node11.parentNode =root;
        node12.parentNode =root;
        TreeNode node21 = new TreeNode(6);
        TreeNode node22= new TreeNode(9);
        node11.leftChildNode = node21;
        node11.rightChildNode =node22;
        node21.parentNode = node11;
        node22.parentNode = node11;
        TreeNode node32= new TreeNode(21);
        node22.rightChildNode = node32;
        node32.parentNode = node22;
    }




    public static void main(String[] args){
        //构建树
        createTree();
        System.out.println("是否为二叉搜索树："+ldrCheck(root));
    }

}
