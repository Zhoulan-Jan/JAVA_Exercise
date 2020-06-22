/**
 * 相当于链表的结点 Node 类
 */
public class MyEntry<K, V> {
    K key;
    V value;

    MyEntry<K, V> next = null;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
