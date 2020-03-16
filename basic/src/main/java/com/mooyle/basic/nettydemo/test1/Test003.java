package com.mooyle.basic.nettydemo.test1;

import java.nio.ByteBuffer;

public class Test003 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while( i ++ < bb.limit()){
            if(bb.get() != 0)
                System.out.println("nonzero");
        }
        System.out.println("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy");
        char c;
        System.out.println("limit:"+bb.limit());
        System.out.println("position:"+bb.position());
        while(bb.position() <=2){
            c = bb.getChar();
            System.out.print(c + " ");
        }
        System.out.println("capacity:"+bb.capacity());
        System.out.println("limit:"+bb.limit());
        System.out.println("position:"+bb.position());
        bb.compact();
        System.out.println("capacity:"+bb.capacity());
        System.out.println("limit:"+bb.limit());
        System.out.println("position:"+bb.position());
        bb.position(0);
        while((c = bb.getChar()) != 0){
            System.out.print(c + " ");
        }
        bb.clear();
        bb.asShortBuffer().put((short)471);
        System.out.println(bb.getShort());
        bb.rewind();
        bb.asIntBuffer().put(12345);
        System.out.println(bb.getInt());
        bb.rewind();
        bb.asLongBuffer().put(345834058304L);
        System.out.println(bb.getLong());
        bb.rewind();
        bb.asFloatBuffer().put(4805430);
        System.out.println(bb.getFloat());
        bb.rewind();
        bb.asDoubleBuffer().put(97979);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
