package com.sda.vendingmachine.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendingStorage {

    Map<Integer, Queue<Item>> storageMap;
}
