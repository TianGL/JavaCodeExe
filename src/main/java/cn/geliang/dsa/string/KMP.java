package cn.geliang.dsa.string;

import org.springframework.util.StringUtils;

/**
 * @Classname KMP
 * @Description TODO
 * @Date 2019-09-03
 * @Created by Geliang TIAN
 */
public class KMP {
    private int[] buildNext(String str) {
        int n = str.length();
        int[] next = new int[n+1];
        char[] chars = str.toCharArray();
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < n) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    private int compareStr(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;
        int[] next = buildNext(p);
        while (sIdx < s.length() && pIdx < p.length()) {
            if (pIdx == -1 || s.charAt(sIdx) == p.charAt(pIdx)) {
                sIdx++;
                pIdx++;
            } else {
                pIdx = next[pIdx];
            }
        }
        if (pIdx == p.length()) {
            return sIdx - pIdx;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String s = "abababca";
        String p = "abca";
        System.out.println(kmp.compareStr(s, p));
    }
}
