package _014_heap;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description:
 */
public class Template{

    int maxSize = 100;
    int heapSize;
    int[] heap = new int[maxSize];

    // 1 2 3 4 5

    /**
     *          1
     *        2   3
     *      4  5
     */
    void buildMaxHeap(int[] heap,int heapSize){
        for(int i=(heapSize)/2-1;i>=0;i--){
            heapify(heap,i,heapSize);
        }
    }

    //向上调整
    private void shiftUp(int[] nums, int index) {
        int fa = Math.max((index - 1) / 2, 0);
        if(nums[fa] < nums[index]){
            swap(nums,fa,index);
            shiftUp(nums,fa);
        }
    }

    int getHeapTop(){
        return heap[0];
    }

    int removeHeapTop(){
        int v  =heap[0];
        heap[0] = heap[heapSize-1];
        heapSize--;
        heapify(heap,0,heapSize);
        return v;
    }

    void insertHeap(int val){
        heapSize ++;
        heap[heapSize-1] = val;
        shiftUp(heap,heapSize-1);
    }


    void heapify(int[] heap,int cur,int heapSize){
        //找出左右儿子
        int l = cur*2 + 1;
        int r = cur*2 + 2;

        //maxIndex记录最大值节点下标
        int maxIndex = cur;
        if(l<heapSize && heap[l] > heap[maxIndex]){
            maxIndex = l;
        }
        if(r<heapSize && heap[r] > heap[maxIndex]){
            maxIndex = r;
        }

        //如果当前节点值需要与其儿子节点交换
        if(maxIndex!=cur){
            swap(heap,cur,maxIndex);
            //交换后，值更小的节点下沉，此时子节点的最大根特性可能发生改变，顾也需要heapify操作
            heapify(heap,maxIndex,heapSize);
        }

    }

    void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    @Test
    public void test(){
        heap = new int[]{5,3,10,-11,3,6,3};
        heapSize = heap.length;
        buildMaxHeap(heap,heapSize);

        int t = heapSize;
        for (int i = 0; i < t; i++) {
            System.out.println(removeHeapTop());
        }
    }

    /**
     *               10
     *             3   6
     *          -11 3  5  3
     */

}
