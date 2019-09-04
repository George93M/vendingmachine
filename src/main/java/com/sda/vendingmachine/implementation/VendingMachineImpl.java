package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.NotSufficientFundException;
import com.sda.vendingmachine.exceptions.SoldOutException;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VendingMachineImpl implements IVendingMachine {


    private VendingStorage storage;
    private Bank bank;


    public Item getItem(int productCode) {
        Map<Integer, Queue<Item>> myStorageMap = storage.getStorageMap();

        Queue<Item> queueByProductCode = myStorageMap.get(productCode);

        if (queueByProductCode == null || queueByProductCode.size() == 0) {
            throw new SoldOutException("Product not available:");
        } else {
            return queueByProductCode.poll();
        }
    }

    public void payItem(int productCode, Queue<Coin> amountPayed) {
        Map<Integer, Queue<Item>> myStorageMap = storage.getStorageMap();

        Queue<Item> queueByProductCode = myStorageMap.get(productCode);
        BigDecimal amoutExpected = queueByProductCode.peek().getPrice();
        BigDecimal amountPayedAsBigDecimal =  getTotalMoneyAsBigDecimal(amountPayed);


        if (amountPayedAsBigDecimal.compareTo(amoutExpected) < 0) {
            throw  new NotSufficientFundException("Insufficient funds!");
        } else {
            bank.updateBank(amountPayed);
        }

    }

    public BigDecimal getTotalMoneyAsBigDecimal(Queue<Coin> money) {
        BigDecimal total= BigDecimal.ZERO;
        for (Coin m: money) {
            switch (m){
                case ONE_DOLLAR:
                    total= total.add(BigDecimal.valueOf(1));
                    break;
                case HALF:
                    total=total.add(BigDecimal.valueOf(0.5));
                    break;
                case PENNY:
                    total=total.add(BigDecimal.valueOf(0.01));
                    break;
                case QUARTER:
                    total=total.add(BigDecimal.valueOf(0.25));
                    break;
                case DIME:
                    total=total.add(BigDecimal.valueOf(0.1));
                    break;
                case NICKLE:
                    total=total.add(BigDecimal.valueOf(0.05));
                    break;
            }
        }
        return total;
    }

    public Queue<Coin> getChange(BigDecimal amountExpected, BigDecimal amountReceived) {
        return null;
    }

    public void cancelRequest() {

    }
}
