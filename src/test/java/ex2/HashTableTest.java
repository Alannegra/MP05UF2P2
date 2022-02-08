package ex2;

import ex2.HashTable;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void count() {
        /*int width = 5;
        int height = 5;
        Matrix m = new Matrix(width, height);
        Assertions.assertEquals(width, m.getWidth());*/

    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void put() {
        HashTable hashTable = new HashTable();

        hashTable.put("clave","valor");
        hashTable.put("2","pera");
        hashTable.put("3","manzana");
        hashTable.put("3","naranja");
        hashTable.put("5","platano");

        Assertions.assertEquals(hashTable.toString(), "\n" +
                " bucket[2] = [2, pera]\n" +
                " bucket[3] = [3, manzana] -> [3, naranja]\n" +
                " bucket[5] = [5, platano]\n" +
                " bucket[7] = [clave, valor]");
    }


    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();
        hashTable.put("clave","valor");
        hashTable.get("clave");
        Assertions.assertEquals(hashTable.get("clave"),"valor");
    }

    @org.junit.jupiter.api.Test
    void drop() {
    }
}