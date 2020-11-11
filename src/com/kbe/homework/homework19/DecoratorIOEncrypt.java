package com.kbe.homework.homework19;

import java.io.*;
import java.util.Objects;


public class DecoratorIOEncrypt extends FilterOutputStream {


    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     * @param key for crypt data
     */

    private String key;
    private static final int MAX_LENGTH_KEY = 5;

    public DecoratorIOEncrypt(OutputStream out, String key) {
        super(out);
        setKey(key);
    }

    private void setKey(String key){
        Objects.requireNonNull(key, "key is not be null");
        if (key.length() > MAX_LENGTH_KEY)
            throw new IllegalArgumentException("length of key is not be > 5");
        this.key = key;
    }

    @Override
    public void write(byte[] b) throws IOException {
        encryptData(b, key);
        super.write(b);
    }

    /**
     * @param bytes массив байт, который нужно зашифровать
     * @param key   ключ по которому шифруются данные
     */
    private static void encryptData(byte[] bytes, String key){
        byte[] byteKey = key.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ byteKey[i % byteKey.length]);
        }
    }
}
