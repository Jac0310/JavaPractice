// Java code​​​​​​‌​​​‌​​‌​​‌​​‌​​​​​‌​​‌‌​ below
import java.util.*;
import java.io.*;
import java.nio.*;
import java.math.*;

class Solution {
    public static boolean isTwin(String a, String b) {
        boolean result = true;
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        Arrays.sort(as);
        Arrays.sort(bs);
        if (!(a.length() == b.length())) result = false;

        for (int i = 0; i < as.length; i++)
        {
            if (as[i] != bs[i]) result = false;
        }
        return result;
    }
}