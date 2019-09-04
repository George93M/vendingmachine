package com.sda.vendingmachine;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.implementation.IVendingMachine;
import com.sda.vendingmachine.implementation.VendingMachineImpl;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class VendingMachineTest {

    public static void main(String[] args) {

        Item heidiChccolate = new Item(1, "Ciocolata Heidi", BigDecimal.valueOf(5));
        Item mineralWater = new Item(2, "Mineral Water", BigDecimal.valueOf(7));
        Item cocaCola = new Item(3, "Coca Cola", BigDecimal.valueOf(10));


        /////////// randul cu heidi contine 3 bucati

        Queue<Item> chocolateItemQueue = new ArrayDeque<Item>();

        chocolateItemQueue.add(heidiChccolate);
        chocolateItemQueue.add(heidiChccolate);
        chocolateItemQueue.add(heidiChccolate);


        Queue<Item> colaItemQueue = new ArrayDeque<Item>();
        colaItemQueue.add(cocaCola);

        Queue<Item> mineralWaterItemQueue = new ArrayDeque<Item>();
        mineralWaterItemQueue.add(mineralWater);


        Map<Integer, Queue<Item>> storageMap = new HashMap<>();
        storageMap.put(22, chocolateItemQueue);
        storageMap.put(23, colaItemQueue);
        storageMap.put(24, mineralWaterItemQueue);



        VendingStorage vendingStorage = new VendingStorage(storageMap);
        System.out.println(vendingStorage);

        Bank bank = new Bank();
        Queue<Coin> oneDollars = new ArrayDeque<>();
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);

        Queue<Coin> dimes = new ArrayDeque<>();
        dimes.add(Coin.DIME);

        Queue<Coin> halfs = new ArrayDeque<>();
        halfs.add(Coin.HALF);
        halfs.add(Coin.HALF);

        Queue<Coin> penny = new ArrayDeque<>();
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);

        bank.setOneDollarStack(oneDollars);
        bank.setDimeStack(dimes);
        bank.setHalfStack(halfs);
        bank.setPennyStack(penny);
        bank.setQuarterStack(new ArrayDeque<>());
        bank.setNickleStack(new ArrayDeque<>());


        System.out.println(bank);
        System.out.println("Vending storage is:" +"\n" + vendingStorage + "\n");
        System.out.println();

        VendingMachineImpl vendingMachine= new VendingMachineImpl();
        vendingMachine.setBank(bank);
        vendingMachine.setStorage(vendingStorage);
        vendingMachine.getItem(23);

        System.out.println("Product is :" +"\n" +  vendingMachine.getItem(22));

        vendingMachine.getItem(22);

        Queue<Coin> wallet = new ArrayDeque<>();
        wallet.add(Coin.ONE_DOLLAR);
        wallet.add(Coin.ONE_DOLLAR);
        wallet.add(Coin.ONE_DOLLAR);
        wallet.add(Coin.ONE_DOLLAR);
        wallet.add(Coin.ONE_DOLLAR);
        wallet.add(Coin.QUARTER);
        wallet.add(Coin.HALF);
        wallet.add(Coin.DIME);
        wallet.add(Coin.NICKLE);
        wallet.add(Coin.PENNY);

        vendingMachine.payItem(22,wallet);
        System.out.println(vendingMachine.getTotalMoneyAsBigDecimal(wallet));
        System.out.println(wallet);
        System.out.println(bank);


    }
}
