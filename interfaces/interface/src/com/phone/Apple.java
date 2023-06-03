package com.phone;

public class Apple implements Phone{

    @Override
    public String name() {
        return "iphone";
    }

    @Override
    public String manufacturer() {
        return "Apple";
    }

    @Override
    public int memory() {
        return 128;
    }
    
}
