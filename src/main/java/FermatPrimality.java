package src.main.java;// Lab done by Khondoker Ahnaf Prio and Charles Menne

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class FermatPrimality {

    // We check if the number is prime
    public static boolean isPrime(BigInteger n, int iteration) {
        // Go through base case of 0, 1, and 2
        if (n.equals(BigInteger.valueOf(0)) || n.equals(BigInteger.valueOf(1)))
            return false;
        if (n.equals(BigInteger.valueOf(2)))
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        int counter = 0;
        Random rand = new Random();
        for (int i = 0; i < iteration; i++) {
            counter++;
            BigInteger r = BigInteger.valueOf(Math.abs(rand.nextInt()));
            BigInteger a = r.mod(n.subtract(BigInteger.valueOf(1))).add(BigInteger.valueOf(1));
            if (!(a.modPow(n.subtract(BigInteger.valueOf(1)), n).equals(BigInteger.valueOf(1)))) {
                System.out.println("Number of candidates tried to determine composite: " + counter);
                return false;
            }
        }

        return true;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Running the Fermat primality test\n");
        FermatPrimality fp = new FermatPrimality();
        System.out.println("Input number: ");
        BigInteger num = scan.nextBigInteger();
        System.out.println("\nInput number of k tests: ");

        int k = scan.nextInt();
        boolean prime = fp.isPrime(num, k);
        if (prime) {
            System.out.println("\n" + num + " is prime!");
        } else {
            System.out.println("\n" + num + " is composite!");
        }
    }


}