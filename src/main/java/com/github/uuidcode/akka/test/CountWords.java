package com.github.uuidcode.akka.test;

public class CountWords {
    private String line;

    public static CountWords of() {
        return new CountWords();
    }

    public String getLine() {
        return this.line;
    }

    public CountWords setLine(String line) {
        this.line = line;
        return this;
    }
}
