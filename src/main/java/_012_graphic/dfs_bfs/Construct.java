package _012_graphic.dfs_bfs;


import com.sun.org.apache.bcel.internal.generic.NOP;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/construct-quad-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class Construct {


    class Node{
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return dfs(grid,0, grid.length-1,0,grid.length-1);
    }

    public Node dfs(int[][] grid,int t,int b,int l, int r){


        //一个结点时终止返回
        if(t==b){
            int v = grid[t][l];
            Node node = new Node();
            node.val = v==1;
            node.isLeaf = true;
            return node;
        }
        /**
         *  - - - -
         *  - - - -
         *  - - - -
         *  - - - -
         */
        int rowMid = (t+b)/2;
        int colMid = (r+l)/2;
        Node topL = dfs(grid,t,rowMid,l,colMid);
        Node topR = dfs(grid,t,rowMid,colMid+1,r);
        Node bottomL = dfs(grid,rowMid+1,b,l,colMid);
        Node bottomR = dfs(grid,rowMid+1,b,colMid+1,r);


        if(topL.isLeaf && topR.isLeaf && bottomL.isLeaf && bottomR.isLeaf){
            if(topL.val == topR.val && bottomL.val == bottomR.val && topL.val== bottomL.val){
                return new Node(topL.val,true);
            }else {
                return new Node(true,false,topL,topR,bottomL,bottomR);
            }
        }else {
            return new Node(true,false,topL,topR,bottomL,bottomR);
        }
    }



}
