package src.main.java;

import java.util.Scanner;

public class PollardRho
{
    private static final long C = 1;

    private long function(long X)
    {
        return X * X + C;
    }

    // This will give us the divisors
    private long rho(long N)
    {
        long x1 = 2, x2 = 2, divisor;
        if (N % 2 == 0)
            return 2;
        do
        {
            x1 = function(x1) % N;
            x2 = function(function(x2)) % N;
            divisor = gcd(Math.abs(x1 - x2), N);
        } while (divisor == 1);
        return divisor;
    }

    // Generates gcd of the two numbers
    public  long gcd(long p, long q)
    {
        if (p % q == 0)
            return q;
        return gcd(q, p % q);
    }

    // Checks if this is prime
    public boolean isPrime(long N)
    {
        for (int i = 2; i <= Math.sqrt(N); i++)
            if (N % i == 0)
                return false;
        return true;
    }

    // Generates the factors
    public void factor(long N)
    {
        if (N == 1) ;
        if (isPrime(N))
        {
            System.out.println(N);
            return;
        }
        long divisor = rho(N);
        factor(divisor);
        factor(N / divisor);
    }

    // Driver function
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number:");
        long N = scan.nextLong();
        System.out.println("\nFactors are : ");
        PollardRho pr = new PollardRho();
        pr.factor (N);
    }
}