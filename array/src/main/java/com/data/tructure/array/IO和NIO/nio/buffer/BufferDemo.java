package com.data.tructure.array.IO和NIO.nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author cuishifeng
 * @date 2019-05-05
 */
public class BufferDemo {

    String path = "D:\\kazhi\\dataStructure\\array\\src\\main\\resources\\hello.txt";

    /**
     * Nio 缓冲区
     * <p>
     * 1. position
     * 2. limit
     * 3. capacity
     * 4. put
     * 5. get
     * <p>
     * 6. mark     mark 会记住当前 position 但是必须在同一模式下 才能reset 如果中间切换模式再reset会异常
     * 7. reset    恢复到mark时的 position 位置
     * 8. rewind   position 恢复到 0
     * 9. clear    position limit mark 恢复到初始化位置 (p = 0 , l=1024 , m = -1)
     * 数据不请空,仍然会保留;只是索引 长度 等数值发生变化
     * <p>
     * mark <= position <= limit <= capacity
     * <p>
     * 直接缓冲区和非直接缓冲区的区别
     */
    @Test
    public void test2() throws Exception {

        // 1. 从堆内存分配缓冲区空间
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 2. 从直接内存分配缓存空间
        ByteBuffer buffer2 = ByteBuffer.allocateDirect(1024);
    }


    @Test
    public void test1() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("------------------ 初始化 -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        String str = "abc123";
        buffer.put(str.getBytes());

        System.out.println("------------------ put -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        // 从写状态中 直接读取缓冲区数据是 读不到的
        // 因为 position位置在 6 limit 在1024  只读取 6-1024之间的数据 但是数据 只是0-6之间
        byte[] bytes = new byte[20];
        buffer.get(bytes);
        System.out.println(new String(bytes));

        // 在写模式下读取数据 会使position 位置继续移动要读取的数据长度
        // position 会在原有基础上+20
        System.out.println("------------------ get0 -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());


        // 写模式 转换到 读模式
        buffer.flip();

        buffer.mark();
        System.out.println(">>> mark");

        System.out.println("------------------ flip -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        buffer.get(bytes);
        System.out.println(new String(bytes));

        System.out.println("------------------ get -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        buffer.reset();

        System.out.println("------------------ reset -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        // 把position设为0，mark设为-1，不改变limit的值
        buffer.rewind();
        System.out.println("------------------ rewind -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

    }

    @Test
    public void test() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String str = "abc123";
        buffer.put(str.getBytes());

        System.out.println("------------------ put -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes));

        buffer.clear();

        System.out.println("------------------ clear -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

//        byte[] bytes2 = new byte[str.length()];
//        buffer.get(bytes2);
//        System.out.println(new String(bytes2));
//
//        buffer.clear();

        String s = "66";
        buffer.put(s.getBytes());

        System.out.println("------------------ put2 -------------------");
        System.out.println("position:" + buffer.position());
        System.out.println("limit   :" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        buffer.flip();
        byte[] bytes3 = new byte[buffer.limit()];
        buffer.get(bytes3);
        System.out.println(new String(bytes3));
    }

    @Test
    public void test5() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("---------------- init ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        String str = "你好 hello  123 %$#@*@*@)(_-=+";
        buffer.put(str.getBytes());

        System.out.println("---------------- put ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        buffer.flip();

        System.out.println("---------------- flip ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());


        byte[] bytes = new byte[buffer.limit() - 20];
        buffer.get(bytes);
        System.out.println(new String(bytes));

        buffer.mark();

        System.out.println("---------------- get ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        // 这里如果读取长度还是 limit 的话，因为position不是在0位置了
        // 这样循环获取字节次数 大于 可读区间数据 就会越界
        byte[] bytes2 = new byte[buffer.limit() - buffer.position()];
        buffer.get(bytes2);

        System.out.println("---------------- get2 ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());


        buffer.reset();

        System.out.println("---------------- reset ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());


        buffer.rewind();

        System.out.println("---------------- rewind ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());


    }

    @Test
    public void test6() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String str = "大家好 hello world 666";
        buffer.put(str.getBytes());

        System.out.println("---------------- rewind ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        // 将写模式转换成读模式
        buffer.flip();

        byte[] bytes = new byte[1024];
        buffer.get(bytes, 0, 20);
        System.out.println(new String(bytes));

        System.out.println("---------------- get ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());


        // 清空缓冲区 将读模式转换成写模式
        buffer.clear();


        // 保留未读取的数据，将读模式转换写模式
        buffer.compact();

        System.out.println("---------------- compact ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        String str2 = "8899";
        buffer.put(str2.getBytes());

        System.out.println("---------------- put ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        buffer.flip();

        byte[] bytes2 = new byte[buffer.limit()];
        buffer.get(bytes2);
        System.out.println(new String(bytes2));

        System.out.println("---------------- get ---------------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit   : " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());


    }

    @Test
    public void test8() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String st = "大家好 hello 123456";
        buffer.put(st.getBytes());

        buffer.flip();

        int len = buffer.limit();

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);

        System.out.println(new String(bytes));

        buffer.clear();

        String st2 = "old data";
        buffer.put(st2.getBytes());

        buffer.flip();
        byte[] bytes2 = new byte[buffer.limit()];
        buffer.get(bytes2);
        System.out.println(new String(bytes2));

    }

    @Test
    public void test9() throws Exception {

        String[] hb = {"hello", "123", "you"};
        String[] src = {"1", "2"};
        System.arraycopy(src, 0, hb, 0, src.length);

        for (String st : hb){
            System.out.print(st+" - ");
        }
    }


}
