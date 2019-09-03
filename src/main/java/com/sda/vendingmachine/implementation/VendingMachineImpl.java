package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.SoldOutException;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    }

    public Queue<Coin> getChange(BigDecimal amountExpected, BigDecimal amountReceived) {
        return null;
    }

    public void cancelRequest() {

    }
}
