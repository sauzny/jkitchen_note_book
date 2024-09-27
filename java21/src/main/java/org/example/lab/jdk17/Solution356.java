package org.example.lab.jdk17;

import java.util.random.RandomGenerator;

/**
 * Java 17引入了一些增强的伪随机数生成器（PRNG）算法，以提高随机数生成的质量和性能。
 */

public class Solution356 {
    public static void main(String[] args) {
        String[] algorithms = {
                "L32X64MixRandom",
//              "L32X64StarStarRandom", //
                "L64X128MixRandom",
                "L64X128StarStarRandom",
                "L64X256MixRandom",
                "L64X1024MixRandom",
                "L128X128MixRandom",
                "L128X256MixRandom",
                "L128X1024MixRandom",
                "Xoshiro256PlusPlus",
                "Xoroshiro128PlusPlus"
        };
        for(String algorithm: algorithms){
            try {
                RandomGenerator randomGenerator = RandomGenerator.of(algorithm);
                int randomNum = randomGenerator.nextInt();
                System.out.println(algorithm+"=>" + randomNum);
            }catch (IllegalArgumentException e){
                System.out.println(algorithm);
            }

        }
    }
}
