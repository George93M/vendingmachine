package com.sda.vendingmachine.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;

import static com.sda.vendingmachine.bank.Coin.ONE_DOLLAR;

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
        double total = (pennyStack.size() * 0.01) + (nickleStack.size() * 0.05) + (dimeStack.size() * 0.10) +
                (halfStack.size() * 0.50) + (quarterStack.size() * 0.25) + (oneDollarStack.size() * 1);
        return  "\n" + "Amount of money in the bank " +
                "\n" + "Penny: " + pennyStack.size() +
                "\n" + "Nickles: " + nickleStack.size() +
                "\n" + "Dimes: " + dimeStack.size() +
                "\n" + "Half: " + halfStack.size() +
                "\n" + "Quarters: " + quarterStack.size() +
                "\n" + "Dollars: " + oneDollarStack.size() +
                "\n" + "Total: " + total;
    }

    public void updateBank(Queue<Coin> stack) {
        for (Coin m : stack) {
            switch (m) {
                case ONE_DOLLAR:
                    oneDollarStack.add(m);
                    break;
                case HALF:
                    halfStack.add(m);
                    break;
                case PENNY:
                    pennyStack.add(m);
                    break;
                case QUARTER:
                    quarterStack.add(m);
                    break;
                case DIME:
                    dimeStack.add(m);
                    break;
                case NICKLE:
                    nickleStack.add(m);
                    break;
            }
        }

    }
}
