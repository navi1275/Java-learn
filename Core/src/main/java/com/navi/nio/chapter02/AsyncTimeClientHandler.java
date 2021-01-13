package com.navi.chapter02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * MultiplexerTimeServer Class
 *
 * @author navi
 * @date 29/03/2018
 */
public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>,Runnable {

    private String host;
    private int port;

    CountDownLatch latch;

    AsynchronousSocketChannel client;


    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }


    @Override
    public void run() {

        latch = new CountDownLatch(1);
        client.connect(new InetSocketAddress(host, port), this, this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] bytes = "QUERY TIME ORDER".getBytes();

        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(attachment.hasRemaining()){
                    client.write(attachment, attachment, this);
                }else{
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    client.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                                attachment.flip();
                                byte[] bytes = new byte[attachment.remaining()];
                                attachment.get(bytes);
                            String body = "";
                            try {
                                body = new String(bytes, "utf-8");
                                System.out.println("Now is:" + body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                client.close();
                                latch.countDown();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    client.close();
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        if (!writeBuffer.hasRemaining()) {
            System.out.println("Send Order 2 server succeed.");
        }
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {

    }
}
