package com.joker.aops;


import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy{
    @Override
    public final String buy(double price) {
        System.out.println(String.format("女孩子花了%s买了一套仙女裙",price));
        return "仙女裙";
    }
}
