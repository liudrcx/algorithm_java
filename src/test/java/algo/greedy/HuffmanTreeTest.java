package algo.greedy;

import algo.greedy.HuffmanTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HuffmanTreeTest {

  @Test
  public void testCoding() {
    HuffmanTree tree = new HuffmanTree("abbccccccc");
    assertEquals("0001011111111", tree.encode());
    assertEquals("abbccccc", tree.decode("00010111111"));
  }
}
