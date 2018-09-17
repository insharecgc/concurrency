package com.inshare.concurrency.example.largeFile;

import lombok.extern.slf4j.Slf4j;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Guichao
 * @since 2018/9/17
 */
@Slf4j
public class LargeMappedFileExample1 {

    private final static String filePath = "D:\\Spring Boot Projects\\testFile\\test.dat";

    private final static int length = 0x8000000;    // 128MB

    public static void main(String[] args) throws Exception{
        FileChannel fileChannel = new RandomAccessFile(filePath, "rw").getChannel();
        MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);

        for (int i=0; i<length; ++i) {
            out.put((byte)'x');
        }
        log.info("Write finish");

        // 读取文件中间6个字节内容
        for (int i=length/2; i<length/2+6; ++i) {
            log.info("{} value is {}", i, out.get(i));
        }
        fileChannel.close();
    }
}
