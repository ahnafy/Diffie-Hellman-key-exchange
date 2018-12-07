package src.main.java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BabyStepGiantStep {

    public static void main(String[] args) {
        System.out.println(babyStepGiantStep(BigInteger.valueOf(23834099), BigInteger.valueOf(3), BigInteger.valueOf(8)));
    }

    public static BigInteger babyStepGiantStep(BigInteger cyclicGroup, BigInteger alpha, BigInteger beta) {
        BigInteger cardinality = cyclicGroup.subtract(BigInteger.ONE);
        BigInteger m = sqrt(cardinality);
        Map<Integer, BigInteger> alphaStore = new HashMap<>();

        for (int j = 0; j < m.intValue(); j++) {
            BigInteger alphaPowJ = alpha.modPow(BigInteger.valueOf(j), cyclicGroup);
            alphaStore.put(j, alphaPowJ);
        }

        BigInteger mInverse = alpha.modInverse(cyclicGroup);

        BigInteger y = beta;

        for (int i = 0; i < m.intValue(); i++) {
            for (Map.Entry<Integer, BigInteger> entry : alphaStore.entrySet()) {
                if (y.equals(entry.getValue())) {

                    return (m.multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(entry.getKey())));
                }
            }
            //System.out.println(y);
            y = y.multiply(mInverse);
        }

        return null;
    }

    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }
}
