package com.data.tructure.array.IO和NIO;

import org.junit.Test;

import java.io.*;

/**
 * @author cuishifeng
 * @date 2019-03-29
 */
public class IODemo {

    String path = "D:\\kazhi\\dataStructure\\array\\src\\main\\resources\\hello.txt";
    String out = "D:\\kazhi\\dataStructure\\array\\src\\main\\resources\\out.txt";

    /**
     * =============== 字节流 ================
     */

    @Test
    public void fileInputStream() throws Exception {

        InputStream inputStream = new FileInputStream(path);
        byte[] bytes = new byte[2048];
        int read = inputStream.read(bytes);
        if (read != -1) {
            String str = new String(bytes);
            System.out.println(str);
        }
    }


    @Test
    public void fileOutStream() {
        OutputStream outputStream = null;
        try {
            File file = new File(out);
            boolean exists = file.exists();
            if (!exists) {
                file.createNewFile();
            }
            String str = "abc 123 你好 输出流";
            outputStream = new FileOutputStream(file);
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * ============= 字符流 ==============
     */

    @Test
    public void reader() throws Exception {

        // 1
        InputStream inputStream = new FileInputStream(path);
        Reader reader = new InputStreamReader(inputStream);
        int data = reader.read();
        StringBuilder s = new StringBuilder();
        while (data != -1) {
            char c = (char) data;
            s.append(c);
            data = reader.read();
        }
        System.out.println(s.toString());

        // 2
        Reader reader2 = new FileReader(path);
        int read = reader2.read();
        while (read != -1) {
            char c = (char) read;
            System.out.print(c);
            read = reader2.read();
        }
    }

    @Test
    public void writer() throws Exception {
        OutputStream outputStream = null;
        Writer writer = null;
        try {
            outputStream = new FileOutputStream(out);
            writer = new OutputStreamWriter(outputStream);
            writer.append("你好 字符输出流").append("hello");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
            outputStream.close();
        }
    }

    /**
     * 缓冲流
     */

    @Test
    public void bufferRead() throws Exception {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
    }

    @Test
    public void bufferWrite() throws Exception {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(out);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("123 你说哈 嘻嘻");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
