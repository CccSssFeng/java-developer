package com.data.tructure.array.java基础.比较器;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserSort implements Comparable<UserSort> {

    // 事件相关度
    int relative;
    // 浏览数据
    int visitCount;

    public UserSort(int relative, int visitCount) {
        this.relative = relative;
        this.visitCount = visitCount;
    }

    @Override
    public int compareTo(UserSort o) {
        // 先比较事件相关度
        if (this.relative != o.relative) {
            return this.relative > o.relative ? 1 : -1;
        }
        // 在比较浏览量
        if (this.visitCount != o.visitCount) {
            return this.visitCount > o.visitCount ? 1 : -1;
        }
        return 0;
    }

    @Test
    public void test() throws Exception {

        List<UserSort> list = new ArrayList<>();
        Comparator<UserSort> comparator = (o1, o2) -> {
            // 先比较事件相关度
            if (o1.relative != o2.relative) {
                return o1.relative > o2.relative ? 1 : -1;
            }
            // 在比较浏览量
            if (o1.visitCount != o2.visitCount) {
                return o1.visitCount > o2.visitCount ? 1 : -1;
            }
            return 0;
        };
        list.sort(comparator);

    }

}
