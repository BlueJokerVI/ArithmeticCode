package _012_graphic.dfs_bfs;

import com.sun.org.apache.bcel.internal.generic.INEG;
import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description:
 */


class SnakesAndLadders {
    int n;
    int[] nums;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        nums = new int[n * n + 1];
        //特殊情况处理
        if (board[0][0] != -1) {
            return -1;
        }
        //方向标记
        boolean LR = true;
        //二维转一维
        for (int i = n - 1, index = 1; i >= 0; i--) {
            for (int j = LR ? 0 : n - 1; LR ? j < n : j >= 0; j += LR ? 1 : -1) {
                nums[index++] = board[i][j];
            }
            LR = !LR;
        }
        return bfs();
    }

    int bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> vToStep = new HashMap<>();
        q.offer(1);
        vToStep.put(1, 0);

        while (!q.isEmpty()) {
            int node = q.remove();
            int step = vToStep.get(node);
            if (node == n * n) {
                return step;
            }
            for (int i = 1; i <= 6; i++) {
                int v = node + i;
                if(v>n*n) continue;
                if (nums[v] != -1) v = nums[v];
                if (vToStep.containsKey(v)) continue;
                q.offer(v);
                vToStep.put(v, step + 1);
            }
        }
        return -1;
    }
}



class Solution {
    //广度优先搜索就是队列然后遍历嘛
    //比如说在某一步，就把这一步的下一步可选坐标放到队列里面，然后再逐个广度优先遍历
    //还有一个难点是，怎么做id和数组作弊奥之间的转换呢，这个反而不懂
    //由于每行有n个数字，其位于棋盘从下往上数的第（id-1）/n，向下取整行，r
    //列的话有方向的区别，如果r为偶数，编号从左往右，列号为(id-1)mod n,
    //若r为奇数，则编号方向从右向左n-1-((id-1)mod n)
    public int snakesAndLadders(int[][] board) {
        int n=board.length;//行数
        boolean[] vis=new boolean[n*n+1];//这个数组记录当前是否遍历过，没有遍历过就把它设置为遍历，
        Queue<int[]> queue=new LinkedList<int[]>();//小技巧是把一个元组存到队列里面
        queue.offer(new int[]{1,0});//从编号1开始遍历，这个时候步数为0
        while(!queue.isEmpty()){
            int[] p=queue.poll();
            for(int i=1;i<=6;i++){
                int nxt=p[0]+i;//编号+1
                if(nxt>n*n){
                    break;
                }
                //转换称为数组索引看看有没有电梯
                int[] rc=id2rc(nxt,n);
                if(board[rc[0]][rc[1]]>0){
                    nxt=board[rc[0]][rc[1]];
                }
                if(nxt==n*n){
                    return p[1]+1;
                }
                if(!vis[nxt]){ //没有遍历过的才要加到队列中
                    vis[nxt]=true;
                    queue.offer(new int[]{nxt,p[1]+1});//之前有遍历的话肯定是更加短的路径了
                }
            }
        }
        return -1;
    }
    public int[] id2rc(int id,int n){//从id获得数组索引
        int r=(id-1)/n;//行数
        int c=(id-1)%n;
        if(r%2==1){
            c=n-1-c;
        }
        return new int[]{n-1-r,c};
    }
}
