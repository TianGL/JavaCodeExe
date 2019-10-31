package cn.geliang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Cnm
 * @Description TODO
 * @Date 2019-08-31
 * @Created by Geliang TIAN
 */
public class Cnm {
    private static int MAXN=1000000;
    private static int M = 1000000007;
    private static boolean[] arr;

    // 计算素数
    private static List<Integer> producePrime() {
        arr = new boolean[MAXN];
        Arrays.fill(arr, false);
        List<Integer> prim = new ArrayList<>();
        prim.add(2);
        int i;
        for (i = 3; i * i < MAXN; i += 2) {
            if (!arr[i]) {
                prim.add(i);
                for (int j = i * i; j < MAXN; j += i) {
                    arr[j] = false;
                }
            }
        }
        while (i <= MAXN) {
            if (! arr[i]) {
                prim.add(i);
                i = i+ 2;
            }
        }

        return prim;
    }

// x!的质因数p的幂次
    private static int calc(int x, int p) {
        int ans = 0;
        long rec = p;
        while (x >= rec) {
            ans += x/rec;
            rec *= p;
        }
        return ans;
    }

    // 计算x的k次方
    private static long pow(int x, int k, int MOD) {
        long ans = 1;
        while (k != 0) {
            if ((k & 1) != 0) {
                ans = (ans * x) % MOD;
            }
            x = (x*x) % MOD;
            k >>= 1;
        }
        return ans;
    }

    private static int Combination(int n, int m) {
        List<Integer> prime = producePrime();
        long ans = 1;
        int num = 0;
        for (int i = 0; i < prime.size() && prime.get(i) <= n; i++) {
            // c(n, m) = n!/(m!(n-m)!)
            //System.out.println(i);
            num = calc(n, prime.get(i)) - calc(m, prime.get(i)) - calc(n-m, prime.get(i));
            ans = (ans*pow(prime.get(i), num, M)) % M;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(Combination(4,2));
        System.out.println(Combination(5,1));
        System.out.println(Combination(6,4));
    }


}
