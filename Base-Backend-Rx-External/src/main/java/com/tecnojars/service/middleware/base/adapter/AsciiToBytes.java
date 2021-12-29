package com.tecnojars.service.middleware.base.adapter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AsciiToBytes {
    public static byte[] fromAsciiToBytesDocument(List<Long> lst) {

        return toPrimitives(lst.stream()
                .map(Long::byteValue)
                .collect(Collectors.toList()))
                ;
    }

    public static byte[] fromAsciiIntegerToBytesDocument(List<Integer> lst) {

        return toPrimitives(lst.stream()
                .map(Integer::byteValue)
                .collect(Collectors.toList()))
                ;
    }

    public static byte[] fromAsciiObjectToBytesDocument(List<Object> lst) {

        return toPrimitives(lst.stream()
                .map(o -> (Integer)o)
                .map(Integer::byteValue)
                .collect(Collectors.toList()))
                ;
    }

    private static byte[] toPrimitives(List<Byte> lstBytes) {
        byte[] bytes = new byte[lstBytes.size()];

        for (int i = 0; i < lstBytes.size(); i++) {
            bytes[i] = lstBytes.get(i);
        }
        try {
            String documentString = new String(bytes, "UTF-8");
            documentString = documentString.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
            return documentString.getBytes("UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bytes;
    }
}