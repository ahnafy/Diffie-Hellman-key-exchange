package src.main.java;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class MillerRabin {

    // Check if a number is prime
    public static boolean isPrime(BigInteger n, int iteration) {
        // Go through base case of 0, 1, and 2
        if (n.equals(BigInteger.valueOf(0)) || n.equals(BigInteger.valueOf(1)))
            return false;
        if (n.equals(BigInteger.valueOf(2)))
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        BigInteger s = n.subtract(BigInteger.valueOf(1));
        while (s.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            s = s.divide(BigInteger.valueOf(2));
        }

        int counter = 0;
        Random rand = new Random();
        for (int i = 0; i < iteration; i++) {
            counter++;
            BigInteger r = BigInteger.valueOf(Math.abs(rand.nextInt()));
            BigInteger a = r.mod((n.subtract(BigInteger.valueOf(1))).add(BigInteger.valueOf(1))), temp = s;
            BigInteger mod = a.modPow(temp, n);

            while (!Objects.equals(temp, n.subtract(BigInteger.valueOf(1))) && !mod.equals(BigInteger.valueOf(1)) && !mod.equals(n.subtract(BigInteger.valueOf(1)))) {
                mod = mod.multiply(mod).mod(n);
                temp = temp.multiply(BigInteger.valueOf(2));
            }
            if (!mod.equals(n.subtract(BigInteger.valueOf(1))) && temp.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                System.out.println("Number of candidates tried to determine composite: " + counter);
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Running the Miller Rabin test\n");
        MillerRabin mr = new MillerRabin();
        System.out.println("Input Number: ");
        BigInteger num = scan.nextBigInteger();
        System.out.println("\nInput number of k tests: ");
        int k = scan.nextInt();
        boolean prime = mr.isPrime(num, k);
        if (prime) {
            System.out.println("\n" + num + " is prime!");
        } else {
            System.out.println("\n" + num + " is composite!");
        }

    }
}