package com.tj.kuan;

import java.util.Arrays;

public class NumberPlusOne {
    public int[] plusOne(int[] digits) {
        if(null == digits) return new int[]{};
        int i= digits.length -1;
        while (true){
            if (i<0){
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                return newDigits;
            }
            if (digits[i] ==9) {
                digits[i--] =0;
            } else {
                digits[i] +=1;
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        int[] digits = {0};
        System.out.println(Arrays.toString(new NumberPlusOne().plusOne(digits)));
    }
}
