package javaCore.java8;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class StringJoinerTest {

    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner(",");

        IntStream.rangeClosed(1,10).forEach(item -> stringJoiner.add("" + item));

        System.out.println(stringJoiner.toString());



    }
}
