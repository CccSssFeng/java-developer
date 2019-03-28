package com.data.structure;

/**
 * @author cuishifeng
 * @Title: BubbleSort 冒泡排序
 * @ProjectName com.data.structure
 * @date 2018-09-11
 */
public class BubbleSort {

    private long[] array;
    int size;

    public BubbleSort(long[] array) {
        this.array = array;
        this.size = array.length;
    }

    /**
     * 两两比较 选出最大的放到最后 在开始下一轮
     *
     * @return
     */
    public long[] sort() {
        int out, in;
        for (out = size - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    replace(in, in + 1);
                }
            }
        }
        return array;
    }

    public void replace(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    public static void main(String[] args) {
        long[] nums = {1, 3, 25, 5, 2, 10, 8, 9, 10};
        BubbleSort bubbleSort = new BubbleSort(nums);
        long[] sort = bubbleSort.sort();
        for (long num : sort) {
            System.out.println(num);
        }
    }
}
