package com.sauzny.optional;

import com.sauzny.string.StringEx;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalEx {

    public static void main(String[] args) {

        // 这会出现一个空指针
        //Optional foo02 = Optional.of(null);
        //System.out.println(foo02);

        Optional foo01 = Optional.ofNullable(null);
        System.out.println(foo01);
        System.out.println(foo01.isPresent());
        System.out.println(foo01.isEmpty());
        System.out.println(foo01.orElse("orElse"));

        StringEx.printSplitLine();

        Optional foo02 = Optional.empty();
        System.out.println(foo02);
        System.out.println(foo02.isPresent());
        System.out.println(foo02.isEmpty());
        System.out.println(foo02.orElse("orElse"));

        StringEx.printSplitLine();

        Optional foo03 = Optional.of("optional something");
        System.out.println(foo03);
        System.out.println(foo03.isPresent());
        System.out.println(foo03.isEmpty());
        System.out.println(foo03.orElse("orElse"));

        StringEx.printSplitLine();

        List<Optional<String>> list = List.of (
                Optional.empty(),
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B"));

        //filter the list based to print non-empty values

        //if optional is non-empty, get the value in stream, otherwise return empty
        List<String> filteredList = list.stream()
                .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                .collect(Collectors.toList());

        //Optional::stream method will return a stream of either one
        //or zero element if data is present or not.
        List<String> filteredListJava9 = list.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println(filteredList);
        System.out.println(filteredListJava9);

        StringEx.printSplitLine();


        Optional<Integer> optional = Optional.of(1);

        optional.ifPresentOrElse( x -> System.out.println("Value: " + x),() ->
                System.out.println("Not Present."));

        optional = Optional.empty();

        optional.ifPresentOrElse( x -> System.out.println("Value: " + x),() ->
                System.out.println("Not Present."));


        StringEx.printSplitLine();

        Optional<String> optional1 = Optional.of("Mahesh");
        Supplier<Optional<String>> supplierString = () -> Optional.of("Not Present");
        optional1 = optional1.or( supplierString);
        optional1.ifPresent( x -> System.out.println("Value: " + x));
        optional1 = Optional.empty();
        optional1 = optional1.or( supplierString);
        optional1.ifPresent( x -> System.out.println("Value: " + x));
    }

}
