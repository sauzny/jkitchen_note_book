package com.sauzny.reactordemo;

import reactor.core.publisher.Flux;

public class Utils {

    public static void print(Flux<Object> flux){
        flux.subscribe(System.out::println);
    }
}
