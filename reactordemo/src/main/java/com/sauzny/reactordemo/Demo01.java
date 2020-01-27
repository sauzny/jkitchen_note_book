package com.sauzny.reactordemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Demo01 {

    public static void foo01(){

        Flux flux01 = Flux.just(1, 2, 3, 4, 5, 6);
        Mono mono01 = Mono.just(1);

        Utils.print(flux01);
    }


    public static void main(String[] args) {
        Demo01.foo01();
    }
}
