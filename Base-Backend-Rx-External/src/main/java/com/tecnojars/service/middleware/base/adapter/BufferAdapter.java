package com.tecnojars.service.middleware.base.adapter;

import io.vertx.reactivex.core.buffer.Buffer;

public class BufferAdapter {
    public static byte[] toByte(Buffer buffer){
        int length = buffer.length();
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = buffer.getByte(i);
        }
        return result;
    }

    public static Buffer toBuffer(byte[] data) {
        Buffer buffer = Buffer.buffer();
        int length = data.length;

        for (int i = 0; i < length; i++) {
            buffer.appendByte(data[i]);
        }
        return buffer;
    }
}
