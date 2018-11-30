package src.main.java;// Lab done by Khondoker Ahnaf Prio and Charles Menne

// We chose q = 11917049
// 2q+1 = p = 23834099
// g = 3
//
//-----------------------------------
// Matt Munns values
// p = 47186099
// g = 8
// B = 9298565

// shared key using our p and g = 19081956
// a = 69


// shared key using his p and g = 36283730
// b = 1337

import java.math.BigInteger;

public class DH {
    public static void main (String[] args) {
        BigInteger p = BigInteger.valueOf(23834099);
        BigInteger q = BigInteger.valueOf(11917049);

        // Calculate first shared key
        System.out.println(BigInteger.valueOf(9298565).modPow(BigInteger.valueOf(69), p));

        // Calculate second shared key
        System.out.println(BigInteger.valueOf(922548).modPow(BigInteger.valueOf(1337), BigInteger.valueOf(47186099)));

        // Checking for generator g, there are a lot
        /*for (int i = 0; i < 23834099; i++) {
            BigInteger g2 = BigInteger.valueOf(i).modPow(BigInteger.valueOf(2), p);
            BigInteger gq = BigInteger.valueOf(i).modPow(q, p);

            if (!(g2.equals(1) && gq.equals(1))) {
                System.out.println(i);
            }
        }*/
    }
}
