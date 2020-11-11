package com.kbe.homework.homework19;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;


public class DecoratorIODecrypt extends FilterInputStream {
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     * @param key for decrypt data
     */

    private String key;
    private static final int MAX_LENGTH_KEY = 5;

    protected DecoratorIODecrypt(InputStream in, String key) {
        super(in);
        setKey(key);
    }

    private void setKey(String key){
        Objects.requireNonNull(key, "key is not be null");
        if (key.length() > MAX_LENGTH_KEY)
            throw new IllegalArgumentException("length of key is not be > 5");
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int quantityOfByte = super.read(b);
        decryptData(b, key);
        return quantityOfByte;
    }

    /**
     * @param bytes массив байт, который нужно расшифровать
     * @param key   ключ по которому расшифровываются данные
     */
    private static void decryptData(byte[] bytes, String key){
        byte[] byteKey = key.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ byteKey[i % byteKey.length]);
        }
    }
}
