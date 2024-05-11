package liudrcx.ds.list.linkedlist;


import liudrcx.problems.linkedlist.LRUCache;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {

  @Test
  public void testCache() {
    LRUCache<String, String> cache = new LRUCache<>(2);
    cache.add("a", "aa");
    cache.add("b", "bb");
    cache.add("c", "cc");

    assertThat(cache.size()).isEqualTo(2);
    assertThat(cache.get("a")).isNull();
    assertThat(cache.get("c")).isEqualTo("cc");

    cache.add("d", "dd");
    cache.add("e", "ee");

    assertThat(cache.get("b")).isNull();;
  }
}
