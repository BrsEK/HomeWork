package com.kbe.homework.homework19;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Objects;

public class EncryptDataClass {


    public static String getDecryptedDataFromFile(File file, String key) {
        String decryptText = null;
        try (DecoratorIODecrypt decryptIn = new DecoratorIODecrypt(
                new FileInputStream(file), key);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ) {
            byte[] bytes = new byte[3];
            int quantityOfBytes;
            while ((quantityOfBytes = decryptIn.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, quantityOfBytes);
            }
            decryptText = new String(byteArrayOutputStream.toByteArray());
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return decryptText;
    }

    public static void printEncryptedDataToFile(File file, String data, String key) {

        byte[] bytesData = data.getBytes();

        try (DecoratorIOEncrypt encryptOutput = new DecoratorIOEncrypt(
                new BufferedOutputStream(new FileOutputStream(file)), key)) {
            encryptOutput.write(bytesData);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
