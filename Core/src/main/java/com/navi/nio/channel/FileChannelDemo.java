package com.navi.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by navi on 17/2/13.
 */
public class FileChannelDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("aaa.txt", "rw");
            FileChannel channel = file.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(20);
            int read = channel.read(buffer);
            while(read != -1){
                System.out.println("Read " + read);
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                System.out.println();
                buffer.clear();
                read = channel.read(buffer);
            }
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
