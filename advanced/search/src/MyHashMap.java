import java.lang.invoke.MutableCallSite;
import java.util.Enumeration;
import java.util.Map;

public class MyHashMap<K, V> implements MyMap<K, V> {
    //要求 table.length 必须是 2 的幂次方
    private MyEntry<K,V>[] table = new MyEntry[16];
    //map中已经保存的有效key的个数
    private int size = 0;
    private static final double LOADER_FACTOR_THRESHOLD = 0.75;

    @Override
    public V get(K key) {
        //1.根据key得到下标
        //1.1求出key的hashCode();
        //若HashMap的K类型是自定义的类，必须要覆写hashCode()，否则无法根据相同的key找到唯一的下标
        int hash = key.hashCode();
        //让hash中的每一位都参与到找下标的过程，使得找到的下标，尽可能均匀
        hash = (hash >>> 16) ^ hash;
        //1.2利用hash得到合法的下标，前提是table.length 必须是 2 的幂次方
        int index = hash & (table.length - 1);

        //2.使用下标，找到链表的头节点的引用
        MyEntry<K, V> head = table[index];

        //3.在链表中，找到包含key的结点，返回该节点的value
        MyEntry<K, V> node = head;
        while (node != null) {
            //使用了key的equals方法。
            //如果使用自定义类作为HashMap的K，必须覆写类的equals方法，保证能判断是否相等
            if (key.equals(node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        hash = (hash >>> 16) ^ hash;
        int index = hash & (table.length - 1);
        MyEntry<K, V> head = table[index];
        MyEntry<K, V> node = head;
        while (node != null) {
            if (key.equals(node.key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }

        //链表遍历结束，没有找到
        //新建结点，并且把结点插入到链表中
        MyEntry<K, V> entry = new MyEntry<>(key, value);

        //考虑多线程的情况，使用尾插
        if (head == null) {
            table[index] = entry;
        } else {
            MyEntry<K, V> last = head;
            while (last != null) {
                last = last.next;
            }
            last.next = entry;
        }

        size++;

        // 为了减少冲突率，所以需要考虑降低 size / table.length 的值
        // 设定一个阈值，当 size / table.length 高于某个值时，进行扩容
        // 所谓的扩容，就是保证 size 不变，让 table.length 变大
        // 进而,使得 size / table.length 降低,进而减少冲突率
        if (size * 1.0/table.length > LOADER_FACTOR_THRESHOLD) {
            resize();
        }

        return null;
    }

    //扩容,需要
    //1. 保证 table.length 仍然是 2 的幂次方
    //2. 因为 table.length 变化了,所以 key 对象的下标一定会变化
    //所以,需要把所有的 key,重新计算下标,重新插入
    //
    private void resize() {
        //数组扩容
        MyEntry<K, V>[] newTable = new MyEntry[table.length * 2];

        for (int i = 0; i < table.length; i++) {
            MyEntry<K, V> head = table[i];
            MyEntry<K, V> node = head;
            while (node != null) {
                K key = node.key;
                V value = node.value;

                //利用key，找新的下标
                int hash = key.hashCode();
                hash = (hash >>> 16) ^ hash;
                int index = hash & (newTable.length - 1);

                //头插
                MyEntry<K, V> entry = new MyEntry<>(key, value);
                entry.next = newTable[index];
                newTable[index] = entry;

                node = node.next;
            }

        }

        //替换掉旧的table
        table = newTable;

    }
}
