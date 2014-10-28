package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamCopyTest {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println ("Usage: ByteStreamCopyTest <original file> <copy>");
            System.exit(-1);
        }
        byte[] b = new byte[128]; int bLen = b.length;
        // Example use of InputStream methods
        try (FileInputStream fis = new FileInputStream (args[0]);
             FileOutputStream fos = new FileOutputStream (args[1])) {
            System.out.println ("Bytes available: " + fis.available());
            int count = 0; int read = 0;
            while ((read = fis.read(b)) != -1) {
                if (read < bLen) fos.write(b, 0, read);
                else fos.write(b);
                count += read;
            }
            System.out.println ("Wrote: " + count);
        } catch (FileNotFoundException f) {
            System.out.println ("File " + args[0] + " not found.");
        } catch (IOException e) {
            System.out.println ("IOException: " + e);
        }
    }
}
