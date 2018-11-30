package src.main.java;// Lab done by Khondoker Ahnaf Prio and Charles Menne

// We chose q = 11917049
// 2q+1 = p = 23834099


import java.math.BigInteger;

public class DH {
    public static void main (String[] args) {
        BigInteger p = BigInteger.valueOf(23834099);
        BigInteger q = BigInteger.valueOf(11917049);
        for (int i = 0; i < 23834099; i++) {
            BigInteger g2 = BigInteger.valueOf(i).modPow(BigInteger.valueOf(2), p);
            BigInteger gq = BigInteger.valueOf(i).modPow(q, p);

            if (!(g2.equals(1) && gq.equals(1))) {
                System.out.println(i);
            }
        }
    }
}
