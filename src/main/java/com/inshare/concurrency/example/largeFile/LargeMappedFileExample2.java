package com.inshare.concurrency.example.largeFile;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Guichao
 * @since 2018/9/17
 */
@Slf4j
public class LargeMappedFileExample2 {

    private final static String filePath = "D:\\Spring Boot Projects\\testFile\\abc.txt";

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        randomAccessFile.setLength(1024*1024);  // 预分配 1M 的文件控件
        randomAccessFile.close();

        String s1 = "第一个字符串";
        String s2 = "第二个字符串";
        String s3 = "第三个字符串";
        String s4 = "第四个字符串";
        String s5 = "第五个字符串";

        new FileWriteThread(1024*1, s1.getBytes()).start();
        new FileWriteThread(1024*2, s2.getBytes()).start();
        new FileWriteThread(1024*3, s3.getBytes()).start();
        new FileWriteThread(1024*4, s4.getBytes()).start();
        new FileWriteThread(1024*5, s5.getBytes()).start();
    }

    private static class FileWriteThread extends Thread {
        private int skip;
        private byte[] content;

        public FileWriteThread(int skip, byte[] content) {
            this.skip = skip;
            this.content = content;
        }

        public void run() {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(filePath, "rw");
                randomAccessFile.seek(skip);
                randomAccessFile.write(content);
            } catch (Exception e) {
                log.error("exception", e);
            } finally {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    log.error("IOException", e);
                }
            }
        }
    }
}
