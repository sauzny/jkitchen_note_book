package org.example.lab.jdk18;

/*
向量（Vector） API 最初由 JEP 338 提出，并作为孵化 API集成到 Java 16 中。
第二轮孵化由 JEP 414 提出并集成到 Java 17 中，
第三轮孵化由 JEP 417 提出并集成到 Java 18 中，
第四轮由 JEP 426 提出并集成到了 Java 19 中。
向量计算由对向量的一系列操作组成。

向量 API 用来表达向量计算，该计算可以在运行时可靠地编译为支持的 CPU 架构上的最佳向量指令，从而实现优于等效标量计算的性能。

向量 API 的目标是为用户提供简洁易用且与平台无关的表达范围广泛的向量计算。
 */

import jdk.incubator.vector.FloatVector;

public class Solution417 {

    // 有些类无法引入

    /*
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    public static void main(String[] args) {

    }

    private static void scalarComputation(float[] a, float[] b, float[] c) {
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }

    private static void vectorComputation(float[] a, float[] b, float[] c) {
        int i = 0;
        int upperBound = SPECIES.loopBound(a.length);
        for (; i < upperBound; i += SPECIES.length()) {
            // FloatVector va, vb, vc;
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            var vc = va.mul(va)
                    .add(vb.mul(vb))
                    .neg();
            vc.intoArray(c, i);
        }
        for (; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }
    */

}
