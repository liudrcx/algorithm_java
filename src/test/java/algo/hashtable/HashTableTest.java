package algo.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTest {

  @Test
  public void testPut() {
    HashTable<Integer, Integer> hashTable = new HashTable<>();
    hashTable._put(1, 1, 1);
    hashTable._put(2, 2, 2);
    hashTable._put(17, 17, 17);

    assertEquals(3, hashTable.size());
    assertEquals(1, hashTable.data[1].next.key);
    assertEquals(1, hashTable.data[1].next.value);
    assertEquals(17, hashTable.data[1].next.next.key);
    assertEquals(17, hashTable.data[1].next.next.value);
    assertEquals(2, hashTable.data[2].next.key);
    assertEquals(2, hashTable.data[2].next.value);
  }

  @Test
  public void testGet() {
    HashTable<Integer, Integer> hashTable = new HashTable<>();
    hashTable._put(1, 1, 1);
    hashTable._put(2, 2, 2);
    hashTable._put(17, 17, 17);

    assertEquals(1, hashTable._get(1, 1));
    assertEquals(2, hashTable._get(2, 2));
    assertEquals(17, hashTable._get(17, 17));
    assertNull(hashTable._get(3, 1));
    assertNull(hashTable._get(17, 2));
  }

  @Test
  public void testRemove() {
    HashTable<Integer, Integer> hashTable = new HashTable<>();
    hashTable._put(1, 1, 1);
    hashTable._put(2, 2, 2);
    hashTable._put(17, 17, 17);

    hashTable._remove(17, 17);

    assertEquals(2, hashTable.size());
    assertEquals(1, hashTable.data[1].next.key);
    assertEquals(1, hashTable.data[1].next.value);
    assertNull(hashTable.data[1].next.next);
    assertEquals(2, hashTable.data[2].next.key);
    assertEquals(2, hashTable.data[2].next.value);
  }

  @Test
  public void testResize() {
    HashTable<Integer, Integer> hashTable = new HashTable<>();
    for (int i = 0; i < 17; i++) {
      hashTable._put(i, i, i);
    }

    assertEquals(32, hashTable.data.length);
    assertEquals(17, hashTable.size());
    assertEquals(16, hashTable.data[16].next.key);
    assertEquals(16, hashTable.data[16].next.value);
  }
}
