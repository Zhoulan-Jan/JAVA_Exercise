class LinkNode {
    public int data;
    public LinkNode next = null;

    //data的构造方法
    public LinkNode(int data) {
        this.data = data;
    }
}

public class LinkedList {
    //第一个节点
    private LinkNode head = null;

    //打印链表
    public void display() {
        System.out.print("[");
        LinkNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }

    //头插法
    public void addFirst(int elem) {
        LinkNode node = new LinkNode(elem);
        //空链表
        if (head == null) {
            this.head = node; //新节点变成第一个节点
        }
        //不为空链表
        else {
            node.next = this.head; //attention this.head.next error
            this.head = node;
        }
        return;
    }

    //尾插法
    public void addLast(int elem) {
        LinkNode node = new LinkNode(elem);
        //空链表
        if (this.head == null) {
            this.head = node;
        }
        //不为空链表
        else {
            //找到最后的结点
            LinkNode last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        return;
    }

    //链表长度
    public int size() {
        int length = 0;
        LinkNode cur = this.head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //任意位置插入
    public void addIndex(int index,int elem) {
        LinkNode node = new LinkNode(elem);
        //index合法性校验  负数or大于链表长度 size的调用？
        int length = size();
        if (index < 0 || index > length){
            return;
        }
        //头插
        if (index == 0){
            addFirst(elem);
        }
        //尾插
        else if (index == length- 1) {
            addLast(elem);
        }
        //中间位置插入
        else {
            //找到前一个节点
            LinkNode prev = findNodeIndex(index - 1);
            //重点
            node.next = prev.next;
            prev.next = node;
        }
        return;
    }

    //查找是否包含关键字key
    public boolean contains(int key) {
        if(findNodeValue(key) != null) return true;
        else return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //空链表
        if (this.head == null) return;
        //头节点
        else if (head.data == key) {
            this.head = this.head.next;
        }
        //删除中间节点
        else {
            LinkNode prev = findPrevNodeValue(key);
            //重点  要考虑没有该元素的问题
            if (prev == null) return;
            else {
                prev.next = prev.next.next;
            }
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        //空链表
        if (this.head == null) return;
        //头节点
        else if (this.head.data == key) {
            this.head = this.head.next;
        }
        //中间节点
        else {
            LinkNode cur = this.head;
            while (cur != null) {
                LinkNode prev = findPrevNodeValue(key);
                if (prev == null) return;
                else{
                    prev.next = prev.next.next;
                }
                cur = cur.next;
            }
        }
    }

    //根据下标找节点
    public LinkNode findNodeIndex(int index) {
        LinkNode node = this.head;
        while (index != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    //根据元素值找节点
    public LinkNode findNodeValue(int val) {
            LinkNode node = this.head;
            for (;node != null; node = node.next) {
                if (node.data == val) {
                    return node;
                }
            }
            return null;//没找到应该返回什么
    }

    //根据元素值找前一个节点
    public LinkNode  findPrevNodeValue(int val) {
        LinkNode node = this.head;
        for (;node.next != null; node = node.next) {
            if (node.next.data == val) {
                return node;
            }
        }
        return null;//没找到应该返回什么
    }

    public void clear(){
        this.head = null;
    }
}
