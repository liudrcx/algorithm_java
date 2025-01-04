package algo.hashtable;

public class HashTable<K, V> {

  Entry<K, V>[] data;

  int size;

  float loadfactor = 0.75f;

  int threshold;

  public HashTable() {
    data = _initDataArray(16);
    size = 0;
    loadfactor = 0.75f;
    threshold = (int) (loadfactor * data.length);
  }

  void _put(int hash, K key, V value) {
    int idx = hash & (data.length - 1);

    Entry<K, V> prev = data[idx];
    Entry<K, V> current = prev.next;
    while(current != null) {
      if (current.key.equals(key)) {
        current.value = value;
        return;
      }
      prev = current;
      current = current.next;
    }

    Entry<K, V> newEntry = new Entry<>(hash, key, value);
    prev.next = newEntry;
    size++;

    if (size > threshold) {
      _resize();
    }
  }

  V _get(int hash, K key) {
    int idx = hash & (data.length - 1);

    Entry<K, V> current = data[idx].next;
    while(current != null) {
      if (current.key.equals(key)) {
        return current.value;
      }
      current = current.next;
    }

    return null;
  }

  V _remove(int hash, K key) {
    int idx = hash & (data.length - 1);

    Entry<K, V> prev = data[idx];
    Entry<K, V> current = prev.next;
    while(current != null) {
      if (current.key.equals(key)) {
        break;
      }
      prev = current;
      current = current.next;
    }

    if (current == null) {
      return null;
    }

    prev.next = current.next;
    size--;
    return current.value;
  }

  private void _resize() {
    Entry<K, V>[] newTable = _initDataArray(data.length << 1);
    for (int i = 0; i < data.length; i++) {
      Entry<K, V> current = data[i].next;
      if (current != null) {
        Entry<K, V> aHead = newTable[i];
        Entry<K, V> aCurrent = aHead;

        Entry<K, V> bHead = newTable[i + data.length];
        Entry<K, V> bCurrent = bHead;

        while(current != null) {
          if ((current.hash & data.length) == 0) {
            aCurrent.next = current;
            aCurrent = aCurrent.next;
          } else {
            bCurrent.next = current;
            bCurrent = bCurrent.next;
          }
          current = current.next;
        }

        aCurrent.next = null;
        bCurrent.next = null;
      }
    }

    data = newTable;
    threshold = (int) (loadfactor * data.length);
  }

  private Entry<K, V>[] _initDataArray(int size) {
    Entry<K, V>[] table = new Entry[size];
    for (int i = 0; i < size; i++) {
      table[i] = new Entry<>(-1, null, null);
    }
    return table;
  }

  public int size() {
    return size;
  }

  static class Entry<K, V> {

    int hash;

    K key;

    V value;

    Entry<K, V> next;

    public Entry(int hash, K key, V value) {
      this.hash = hash;
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Entry{" +
        "hash=" + hash +
        ", key=" + key +
        ", value=" + value +
        '}';
    }
  }

}
