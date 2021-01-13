package com.navi.channel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * RandomAccessFileTest Class
 *
 * @author navi
 * @date 2018/7/5
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("bbb.txt", "rw");
        Person person = new Person(101, "xiaoming", false, 187.2);
        person.write(randomAccessFile);
    }

}

@Data
@AllArgsConstructor
class Person {

    private int id;

    private String name;

    private Boolean gender;

    private Double height;

    public void write(RandomAccessFile raf) throws IOException {
        raf.write(id);
        raf.writeUTF(name);
        raf.writeDouble(height);
        raf.writeBoolean(gender);
    }
}
