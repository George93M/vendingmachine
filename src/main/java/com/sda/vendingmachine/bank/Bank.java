package com.sda.vendingmachine.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Queue;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Bank {

    private Queue<Coin> pennyStack;
    private Queue<Coin> nickleStack;
    private Queue<Coin> dimeStack;
    private Queue<Coin> quarterStack;
    private Queue<Coin> halfStack;
    private Queue<Coin> oneDollarStack;



    @Override
    public String toString() {
        return "Moneda de un dolar:" +  oneDollarStack.size()+"\n" + "Halfstack:"  + halfStack.size() +"\n"+
                  "Quarterstack:" + quarterStack.size() +"\n"+ "Dimestack:" + dimeStack.size() +"\n"
                + "Niclestack:" + "\n"+ nickleStack.size() + "pennystack:" + "\n" + pennyStack.size() +"\n";
    }
}
