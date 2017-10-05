package org.erlend.test.java8test.simulator;


import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TestJava8 {

    @Test
    public void testLambda() throws Exception {
        List<String> list = Arrays.asList("one", "two ", " three");
        list.stream().forEach(String::format);
        list.stream().map(String::trim).forEach(System.out::println);
        list.stream().map(s -> {
            s.charAt(0);
            return s.trim();
        }).forEach(System.out::println);
        list.stream().map(String::trim).forEach(System.out::println);
        list.stream().forEach(String::new);
    }

    @Test
    public void compareJava7Java8() throws Exception {
        ActionListener al = e -> System.out.println(e.getActionCommand());
        // Java 8
        ActionListener a2 = e -> System.out.println(e.getActionCommand());
    }

    @Test
    public void testRange() throws Exception {
        IntStream.range(1, 11).forEach(System.out::println);
    }

    @Test
    public void testOptional() throws Exception {
        Optional<String> opt = Optional.of("test");
        if (opt.isPresent()) {
            String str = opt.get();
            System.out.println(str);
        }
        opt = Optional.ofNullable(null);
        String str = opt.orElse("other");
        System.out.println(str);
    }

    @Test
    public void testParallel() throws Exception {
        IntStream.range(1, 5).parallel().peek(System.out::println).filter(i -> (i > 2)).forEach(System.err::println);
    }
}
