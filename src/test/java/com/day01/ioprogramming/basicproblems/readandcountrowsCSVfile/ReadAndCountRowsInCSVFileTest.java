package com.day01.ioprogramming.basicproblems.readandcountrowsCSVfile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadAndCountRowsInCSVFileTest {
    @Test
    void countRowTest(){
        int a=ReadAndCountRowsInCSVFile.readAndCountRowsInCSVFile("readData.csv");
        assertEquals(5,a);
    }

}
