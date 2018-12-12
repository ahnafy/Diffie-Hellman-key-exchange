package src.main.java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BabyStepGiantStep {
    public static void main(String[] args) {
        // We used the BabyStepGiantStep algorithm in breaking other groups keys. The method used below
        // takes a groups p and g values along with the corresponding A or B values and returns the small
        // a or b used as a key. We did this for the groups below.

        // Our value which was 69 and 1337 returns when we use our algorithm
        // Abe and Francisco's return as 363313

        // Using Matt Munn's p, g, and A values returns 420, which was his 'a' value.
        System.out.println(babyStepGiantStep(BigInteger.valueOf(47186099), BigInteger.valueOf(8), BigInteger.valueOf(922548)));
        // Using our p and g values with his B value returns 100, which is his 'b' value.
        System.out.println(babyStepGiantStep(BigInteger.valueOf(23834099), BigInteger.valueOf(3), BigInteger.valueOf(9298565)));

        // Using Avery and Kai's p, g, and A values returns 2467 for 'a'.
        //System.out.println(babyStepGiantStep(BigInteger.valueOf(658996103), BigInteger.valueOf(5), BigInteger.valueOf(213962984)));
        // Using David Chong's p and g values with Avery's B value returns 2345 for 'b'.
        //System.out.println(babyStepGiantStep(BigInteger.valueOf(35530787), BigInteger.valueOf(2), BigInteger.valueOf(28406022)));
        // Using David Chong's p, g, and A values returns 5047569 for 'a'.
        //System.out.println(babyStepGiantStep(BigInteger.valueOf(35530787), BigInteger.valueOf(2), BigInteger.valueOf(30328638)));

        // Using RJ's p, g, and B values returns 612 for 'b'.
        //System.out.println(babyStepGiantStep(BigInteger.valueOf(31608887), BigInteger.valueOf(5), BigInteger.valueOf(14670634)));
        // Using RJ's p, g, and A values returns 143 for 'a'.
        //System.out.println(babyStepGiantStep(BigInteger.valueOf(31608887), BigInteger.valueOf(5), BigInteger.valueOf(27301765)));

    }



    /***
     *
     * @param cyclicGroup This is the groups p value
     * @param alpha This is the groups g value
     * @param beta This is the groups A or B value
     * @return a or b
     */
    private static BigInteger babyStepGiantStep(BigInteger cyclicGroup, BigInteger alpha, BigInteger beta) {
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

    private static BigInteger sqrt(BigInteger n) {
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
