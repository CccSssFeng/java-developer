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

    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

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

    public static void main(String[] args) {


        BinarySearch binarySearch = new BinarySearch(100);
        for (long i = 0; i < 100; i++) {
            binarySearch.insert(i);
        }

        int index = binarySearch.find(1);
        System.out.println("二分查找获取的数组下标: " + index);
    }
}
