package src.main.java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BabyStepGiantStep {

    public static void main(String[] args) {
        System.out.println(babyStepGiantStep(BigInteger.valueOf(47186099), BigInteger.valueOf(8), BigInteger.valueOf(5)));
    }

    public static BigInteger babyStepGiantStep(BigInteger cyclicGroup, BigInteger alpha, BigInteger beta) {
        BigInteger m = sqrt(cyclicGroup.subtract(BigInteger.valueOf(1)));
        Map<Integer, BigInteger> alphaStore = new HashMap<>();

        for (int j = 0; j < m.intValue(); j++) {
            BigInteger alphaPowJ = alpha.modPow(BigInteger.valueOf(j), cyclicGroup);
            alphaStore.put(j, alphaPowJ);
        }

        BigInteger mInverse = alpha.modPow(m.multiply(cyclicGroup.subtract(BigInteger.valueOf(2))), cyclicGroup);

        for (int i = 0; i < m.intValue(); i++) {
            BigInteger y = (beta.multiply(mInverse.modPow(BigInteger.valueOf(i), cyclicGroup))).mod(cyclicGroup);
            for (Map.Entry<Integer, BigInteger> entry : alphaStore.entrySet()) {
                if (y.equals(entry.getValue())) {

                    return (m.multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(entry.getKey())));
                }
            }
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
