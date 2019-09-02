package com.sda.vendingmachine;

import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class VendingMachineTest {

    public static void main(String[] args) {

        Item heidiChccolate = new Item(1, "Ciocolata Heidi", BigDecimal.valueOf(5));
        Item mineralWater = new Item(2, "Mineral Water", BigDecimal.valueOf(7));
        Item cocaCola = new Item(3, "Coca Cola", BigDecimal.valueOf(10));

        Queue<Item> itemQueue = new ArrayDeque<Item>();
        itemQueue.add(heidiChccolate);
        itemQueue.add(mineralWater);
        itemQueue.add(cocaCola);

        VendingStorage vendingStorage = new VendingStorage();
        Map<Integer, Queue<Item>> storageMap = vendingStorage.getStorageMap();

        storageMap.put(22, itemQueue);
    }
}