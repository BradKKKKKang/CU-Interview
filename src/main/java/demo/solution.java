package demo;

import java.util.HashMap;

public class solution {
    int preIndex = 0;
    int[] inArray;
    int[] preArray;
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    public String getPostOrder(String preorder, String inorder){
        //存储中序遍历序列的每个元素及其对应的索引
        for (int i = 0; i < inorder.length(); i++) {
            indexMap.put((int) inorder.charAt(i), i);
            inArray[i] = (int) inorder.charAt(i);
        }

        //将前序和中序遍历序列转化为字符数组
        for (int i = 0; i < preorder.length(); i++) {
            preArray[i] = (int) preorder.charAt(i);
        }
        return postOrderTraverse(buildTree(0, inorder.length()));
    }

    //构建二叉树
    public TreeNode buildTree(int inLeft, int inRight){
        if (inLeft == inRight)
            return null;

        int root_val = preArray[preIndex++];
        TreeNode root = new TreeNode((char)root_val);

        int index = indexMap.get(root_val);

        root.left = buildTree(inLeft, index);
        root.right = buildTree(index + 1, inRight);
        return root;
    }

    //输出后序遍历二叉树字符串
    public String postOrderTraverse(TreeNode root){
        if(root == null)
            return "";
        String left = postOrderTraverse(root.left);
        String right = postOrderTraverse(root.right);
        return left + right + root.val;
    }
}
