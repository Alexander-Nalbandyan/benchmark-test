//package com.puredev;
//
//import lombok.val;
//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.Fork;
//import org.openjdk.jmh.annotations.OutputTimeUnit;
//import org.openjdk.jmh.annotations.Threads;
//
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.concurrent.TimeUnit;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Fork(value = 1, warmups = 1)
//@Threads(4)
//@OutputTimeUnit(TimeUnit.SECONDS)
//public class RegexpBenchmark {
//    private final static String email = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
//    private final static Pattern emailPatternStatic = Pattern.compile(email);
//
//
//    @Benchmark
//    public String benchmarkCompileEachTime() {
//        Pattern emailPattern = Pattern.compile(email);
//        Matcher matcher = emailPattern.matcher("user" + ThreadLocalRandom.current().nextInt() + "#upwork.com");
//        String validEmailAddress = "test@me.ok";
//        if (matcher.find()) {
//            validEmailAddress = matcher.group();
//        }
//        return validEmailAddress;
//    }
//
//    @Benchmark
//    public String benchmarkCompileOnce() {
//        Matcher matcher = emailPatternStatic.matcher("user" + ThreadLocalRandom.current().nextInt() + "#upwork.com");
//        String validEmailAddress = "test@me.ok";
//        if (matcher.find()) {
//            validEmailAddress = matcher.group();
//        }
//        return validEmailAddress;
//    }
//}