package com.example.demo.ebcidc;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400Float8;
import org.junit.jupiter.api.Test;

public class Converter {

    @Test
    public void test() {
        Integer intObject = new Integer(1123);

        // Number Converter

        AS400Bin4 bin4Converter = new AS400Bin4();

        byte[] data = bin4Converter.toBytes(intObject);

        int length = bin4Converter.getByteLength();
        String s = new String(data);

        System.out.println("length: " + length + "; data: " + bin4Converter.toString());

    }
}
