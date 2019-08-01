package com.mooyle.basis.nettydemo.test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Test002 {
    public static void main(String[] args) throws IOException {
        if(args.length != 2){
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        System.out.println(System.getProperty("file.encoding"));
    }
}
