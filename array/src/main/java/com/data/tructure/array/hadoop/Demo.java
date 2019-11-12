package com.data.tructure.array.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Demo {


    FileSystem fs = null;

    /**
     * 创建文件
     *
     * @param dst
     * @param contents
     * @throws IOException
     */
    public static void createFile(String dst, byte[] contents) throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path dstPath = new Path(dst);
        FSDataOutputStream out = fs.create(dstPath);
        out.write(contents);
        out.close();
        System.out.println("文件:" + dst + " 创建成功");
    }

    /**
     * 按行读取文件内容，并且防止乱码
     *
     * @param hdfsFilename
     * @return
     */
    public static boolean readByLine(String hdfsFilename) {
        try {
            Path f = new Path(hdfsFilename);
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            FSDataInputStream dis = fs.open(f);
            // 防止中文乱码
            BufferedReader bf = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while ((line = bf.readLine()) != null) {
                System.out.println(new String(line.getBytes(), "utf-8"));
            }
            dis.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();
        properties.setProperty("HADOOP_USER_NAME", "root");
        // 测试创建文件
//        String content = "hello HDFS,你好 世界";
////        createFile("/test/hello.txt", content.getBytes());
        // 读取文件内容
        readByLine("/test/hello.txt");

    }
}



