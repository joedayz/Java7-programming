/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author tmcginn
 */
public class ByteChannelCopyTest {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: ByteChannelCopyTest <original file> <copy>");
            System.exit(-1);
        }
        try (FileChannel fcIn = new FileInputStream(args[0]).getChannel();
                FileChannel fcOut = new FileOutputStream(args[1]).getChannel()) {
            System.out.println("File size: " + fcIn.size());
            // Create a buffer to read into
            ByteBuffer buff = ByteBuffer.allocate((int) fcIn.size());
            System.out.println("Bytes remaining: " + buff.remaining());
            System.out.println ("Bytes read: " + fcIn.read(buff));
            buff.position(0);
            System.out.println ("Buffer: " + buff);
            System.out.println("Bytes remaining: " + buff.remaining());
            System.out.println("Wrote: " + fcOut.write(buff) + "   bytes");
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

    }
}
