package aliu.problems.ds.linkedlist;

public class LRUCache<K, V> {

  private Node dummyHead;
  private Node dummyTail;

  private int size = 0;
  private int capacity = 0;


  public LRUCache(int capacity) {
    dummyHead = new Node(null, null);
    dummyTail = new Node(null,null);
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
    this.capacity = capacity;
  }

  public LRUCache() {
    this(10);
  }

  public void add(K k, V v) {
    Node node = findNode(k);
    if (node != null) {
      remove(node);
      addFirst(node);
      return;
    }

    Node newNode = new Node(k, v);
    if (size >= capacity) {
      remove(dummyTail.prev);
    } else {
      size++;
    }
    addFirst(newNode);
  }

  public V get(K k) {
    Node node = findNode(k);
    if (node == null) {
      return null;
    }

    remove(node);
    addFirst(node);
    return node.v;
  }

  private Node findNode(K k) {
    Node node = dummyHead.next;
    while(node != dummyTail) {
      if (node.k.equals(k)) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void addFirst(Node node) {
    node.next = dummyHead.next;
    dummyHead.next.prev = node;
    dummyHead.next = node;
    node.prev = dummyHead;
  }

  public int size() {
    return size;
  }

  private class Node {
    private K k;
    private V v;

    private Node prev;
    private Node next;

    public Node(K k, V v) {
      this.k = k;
      this.v = v;
    }
  }
}
