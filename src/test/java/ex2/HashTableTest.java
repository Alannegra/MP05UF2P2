package ex2;

import ex2.HashTable;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void putOneElementVoidTable() {
        HashTable hashTable = new HashTable();

        hashTable.put("un","elemento");

        Assertions.assertEquals(hashTable.toString(), "\n" +
                " bucket[9] = [un, elemento]");
    }

    @org.junit.jupiter.api.Test
    void putOneElementNoVoidTable() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");

        Assertions.assertEquals(hashTable.toString(), "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2]");
    }

    @org.junit.jupiter.api.Test
    void putOneElementN2oVoid() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");

        Assertions.assertEquals(hashTable.toString(), "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2]");
    }

    @org.junit.jupiter.api.Test
    void put() {
        HashTable hashTable = new HashTable();

        hashTable.put("clave","valorr");
        hashTable.put("2","pera");
        hashTable.put("3","manzana");
        hashTable.put("3","naranja");
        hashTable.put("5","platano");

        Assertions.assertEquals(hashTable.toString(), "\n" +
                " bucket[2] = [2, pera]\n" +
                " bucket[3] = [3, manzana] -> [3, naranja]\n" +
                " bucket[5] = [5, platano]\n" +
                " bucket[7] = [clave, no va]");
    }

    @org.junit.jupiter.api.Test
    void put2(){
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
                " bucket[7] = [clave, No me va]");
    }


    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();
        hashTable.put("clave","valor");
        //hashTable.get("clave");
        Assertions.assertEquals(hashTable.get("clave"),"valor");
    }

    @org.junit.jupiter.api.Test
    void drop() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","valor");
        hashTable.put("2","valor2");
        hashTable.put("2","valor3");
        hashTable.put("2","valor4");
        hashTable.drop("1");
        Assertions.assertEquals(hashTable.toString(),"\n" +
                " bucket[2] = [2, valor2] -> [2, valor3] -> [2, valor4]");

    }

    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","pera");
        Assertions.assertEquals("2",hashTable.count());

    }

    @org.junit.jupiter.api.Test
    void size() {
    }

}