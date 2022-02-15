package ex2;

import ex2.HashTable;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void putOneElementInVoidTable1() {
        HashTable hashTable = new HashTable();

        hashTable.put("un","elemento");

        Assertions.assertEquals( "\n" +
                " bucket[9] = [un, elemento]",hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInNoVoidTable2() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2]" , hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInNoVoidTable3() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("13","elemento13");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [13, elemento13]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInNoVoidTable4() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("1","elemento2");
        hashTable.put("1","elemento3");
        hashTable.put("12","elemento4");

        hashTable.put("5","elemento5");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento] -> [1, elemento2] -> [1, elemento3] -> [12, elemento4]\n" +
                " bucket[5] = [5, elemento5]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInVoidTable5() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento");
        hashTable.put("1","update");

        Assertions.assertEquals( "\n" +
                " bucket[1] = [1, elemento] -> [1, update]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInNoVoidTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("2","updated");

        Assertions.assertEquals( "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [2, updated]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInNoVoidTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("13","elemento13");
        hashTable.put("2","updated");

        Assertions.assertEquals( "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [2, updated]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void put() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","valorr");
        hashTable.put("1","valorr");
        hashTable.put("2","pera");
        hashTable.put("3","manzana");
        hashTable.put("4","naranja");
        hashTable.put("5","platano");
        
        Assertions.assertEquals(hashTable.toString(), "\n" +
                " bucket[2] = [2, pera]\n" +
                " bucket[3] = [3, manzana] -> [3, naranja]\n" +
                " bucket[5] = [5, platano]\n" +
                " bucket[7] = [clave, valorr]");
    }

    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();
        hashTable.put("clave","valor");
        //hashTable.get("clave");
        Assertions.assertEquals(hashTable.get("clave"),"valor");
    }

    @org.junit.jupiter.api.Test
    void getOneElementInVoidTable1() {
        HashTable hashTable = new HashTable();
        hashTable.put("clave","valor");
        Assertions.assertEquals(hashTable.get("clave"),"valor");
    }

    @org.junit.jupiter.api.Test
    void getOneElement2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","valor");
        hashTable.put("1","colision");
        Assertions.assertEquals(hashTable.get("1"),"colision");
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
        Assertions.assertEquals( "1",hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","manzana");
        hashTable.put("2","manzana");
        hashTable.put("3","manzana");
        Assertions.assertEquals("16",hashTable.size());
    }

}