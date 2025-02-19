package com.day01.ioprogramming.advancedproblems.encryptanddecryptCSVdata;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import com.opencsv.*;

public class CsvEncryptDecrypt {
    private static final String AES = "AES";
    private static final String SECRET_KEY = "1234567890123456";

    private static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static String decrypt(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    public static void writeEncryptedCsv(String csvFile) throws Exception {
        List<String[]> data = Arrays.asList(
                new String[]{"ID", "Name", "Email", "Salary"},
                new String[]{"1", "John Doe", encrypt("john@example.com", SECRET_KEY), encrypt("50000", SECRET_KEY)},
                new String[]{"2", "Jane Smith", encrypt("jane@example.com", SECRET_KEY), encrypt("60000", SECRET_KEY)}
        );

        try (FileWriter writer = new FileWriter(csvFile);
             CSVWriter csvWriter = new CSVWriter(writer)) {
            csvWriter.writeAll(data);
        }
        System.out.println("Encrypted CSV written successfully!");
    }

    public static void readDecryptedCsv(String csvFile) throws Exception {
        try (FileReader reader = new FileReader(csvFile);
             CSVReader csvReader = new CSVReader(reader)) {

            List<String[]> rows = csvReader.readAll();
            for (int i = 0; i < rows.size(); i++) {
                String[] row = rows.get(i);
                if (i > 0) {
                    row[2] = decrypt(row[2], SECRET_KEY);
                    row[3] = decrypt(row[3], SECRET_KEY);
                }
                System.out.println(Arrays.toString(row));
            }
        }
    }


}

