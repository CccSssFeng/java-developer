package com.data.tructure.array;

/**
 * 二分查找
 *
 * @author cuishifeng
 * @Title: BinarySearch
 * @ProjectName com.dataStructure.array
 * @date 2018-09-07
 */
public class BinarySearch {

    private long[] array;
    private int nElems;

    public BinarySearch(int maxIndex) {
        array = new long[maxIndex];
        nElems = 0;
    }

    /**
     * 无序插入
     */
    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    /**
     * 有序插入 - 从小到达排序
     */
    public void orderInsert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (array[j] > value) {
                break;
            }
        }
        for (int i = nElems; i > j; i--) {
            array[i] = array[i - 1];
        }
        array[j] = value;
        nElems++;
    }

    /**
     * 插入 - 从大到小排序
     */
    public void orderBigInsert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (array[j] < value) {
                break;
            }
        }
        for (int i = nElems; i > j; i--) {
            array[i] = array[i - 1];
        }
        array[j] = value;
        nElems++;
    }

    /**
     * 二分查找
     */
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentBound;
        int findCount = 0;

        while (true) {
            findCount++;
            System.out.println("第 " + findCount + " 次寻找");
            currentBound = (upperBound + lowerBound) / 2;
            if (array[currentBound] == searchKey) {
                return currentBound;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (array[currentBound] < searchKey) {
                    lowerBound = currentBound + 1;
                } else {
                    upperBound = currentBound - 1;
                }
            }
        }
    }

    public void dispalay() {
        for (long a : array) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {


        BinarySearch binarySearch = new BinarySearch(100);
        for (long i = 0; i < 100; i++) {
            binarySearch.insert(i);
        }

        int index = binarySearch.find(1);
        System.out.println("二分查找获取的数组下标: " + index);
    }
}
