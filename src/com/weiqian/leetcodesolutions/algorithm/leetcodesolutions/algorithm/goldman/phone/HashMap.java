package com.weiqian.leetcodesolutions.algorithm.leetcodesolutions.algorithm.goldman.phone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap {
    /*
       Table: List: |  |  |  |  |  |  | ...
                      l  l  l<key-value pair>

       Datastructure: List<List<Entry<U, V>>>;
 */

    class Entry<U, V>{
        public U key;
        public V value;

        public Entry(U key, V value){
            this.key = key;
            this.value = value;
        }
    }


    class MyHashMap {
        private int space;
        private List<List<Entry<Integer, Integer>>> table;

        /** Initialize your data structure here. */
        public MyHashMap() {
            this.space = 2069;
            this.table = new ArrayList<>();
            for(int i = 0; i < space; i++){
                this.table.add(new ArrayList<Entry<Integer,Integer>>());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hashIndex = key % this.space;
            List<Entry<Integer,Integer>> bucket = this.table.get(hashIndex);

            boolean exist = false;
            for(Entry<Integer,Integer> entry: bucket){
                if(entry.key.equals(key)){
                    entry.value = value;
                    exist = true;
                    break;
                }
            }

            if(!exist){
                bucket.add(new Entry<Integer, Integer>(key, value));
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hashIndex = key % this.space;
            List<Entry<Integer,Integer>> bucket = this.table.get(hashIndex);

            for(Entry<Integer, Integer> entry: bucket){
                if(entry.key.equals(key)){
                    return entry.value;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hashIndex = key % this.space;
            List<Entry<Integer, Integer>> bucket = this.table.get(hashIndex);

            for(Entry<Integer, Integer> entry: bucket){
                if(entry.key.equals(key)){
                    bucket.remove(entry);
                    break;
                }
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
