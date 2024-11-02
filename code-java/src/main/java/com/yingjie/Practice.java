package com.yingjie;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {
        Practice practice = new Practice();
        Arrays.asList("1", "2", null, null).stream().peek(System.out::println).collect(Collectors.toList());
    }


}