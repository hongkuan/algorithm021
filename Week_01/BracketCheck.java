package com.tj.kuan;

import java.util.Stack;

public class BracketCheck {
    public boolean isValid(String s) {
        if (null == s || s.length()%2 != 0 )return false;
        String a = "{", b = "}", c = "[", d = "]", e = "(", f = ")";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(String.valueOf(s.charAt(i)));
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        if (!stack.pop().equals("{")){
                            return false;
                        }
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        if (!stack.pop().equals("[")){
                            return false;
                        }
                    }
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        if (!stack.pop().equals("(")){
                            return false;
                        }
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
