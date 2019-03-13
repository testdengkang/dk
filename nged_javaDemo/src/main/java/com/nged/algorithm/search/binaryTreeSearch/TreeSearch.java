package com.nged.algorithm.search.binaryTreeSearch;

/**
 * @author: Administrator
 * @Date: 2019/3/13 15:42
 * @Description:
 */
public class TreeSearch {

    public static TreeNode root;

    public static int size;

    /**
     * 构造二叉树
     * 根据二叉树性质，根节点大于左子树 小于右子树
     * @param value
     * @return
     */
    public static boolean addNode(int value){
        if(null==root){
            TreeNode node = new TreeNode(value);
            root = node;
            return true;
        }
        TreeNode treeNode = new TreeNode(value);
        TreeNode currentNode = root;
        TreeNode parentNode ;
        while (true){
            parentNode =currentNode;
            if(currentNode.value>value){
                currentNode = currentNode.leftChildNode;
                //不断遍历直到为空 插入
                if(null==currentNode){
                    parentNode.leftChildNode = treeNode;
                    treeNode.parentNode = parentNode;
                    size++;
                    return true;
                }
            }else if(currentNode.value<value){
                currentNode = currentNode.rightChildNode;
                if(null==currentNode){
                    parentNode.rightChildNode =treeNode;
                    treeNode.parentNode = parentNode;
                    size++;
                    return true;
                }
            }else{
                return  false;
            }


        }
    }

    /**
     * 查找值
     * @param data
     * @return
     */
    public static TreeNode findTreeNode(int data){
        if(null==root){
            return  null;
        }

        TreeNode currentNode = root;

        while(true){

            if(null == currentNode){
                return null;
            }
            if(currentNode.value == data){
                return currentNode;
            }else if(currentNode.value>data){
                currentNode = currentNode.leftChildNode;
            }else if(currentNode.value<data){
                currentNode = currentNode.rightChildNode;
            }
        }
    }
    //前序遍历
    public static void dlr(TreeNode node){

        if(null!=node){
            System.out.println("前序遍历:"+node.value);

            if(null!=node.leftChildNode){
                dlr(node.leftChildNode);
            }
            if(null!=node.rightChildNode){
                dlr(node.rightChildNode);
            }

        }


    }
    //中序遍历
    public static void ldr(TreeNode node){



        if(null!=node){
            if(null!=node.leftChildNode){
                ldr(node.leftChildNode);
            }
            System.out.println("中序遍历:"+node.value);
            if(null!=node.rightChildNode){
                ldr(node.rightChildNode);
            }
        }


    }

    //后序遍历
    public static void lrd(TreeNode node){

        if(null!=node){
            if(null!=node.leftChildNode){
                lrd(node.leftChildNode);
            }
            if(null!=node.rightChildNode){
                lrd(node.rightChildNode);
            }
            System.out.println("后序遍历:"+node.value);
        }

    }
    public  static void main(String[] args){
        int[] array ={1,2,3,5,7,4,100,32,66,93};
        for(int i=0;i<array.length;i++){
            addNode(array[i]);
        }
        System.out.println("结果："+findTreeNode(100)!=null?true:false);
//        dlr(root);
//        ldr(root);
        lrd(root);
    }


}
