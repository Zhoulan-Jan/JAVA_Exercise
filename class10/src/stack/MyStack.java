package stack;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;

    //入栈
    public void push(int elem) {
        array[size++] = elem;
    }

    //出栈
    public int pop() {
        return array[--size];
    }

    //取栈顶元素
    public int peek() {
        return array[size - 1];
    }

    //栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //栈的长度
    public int size() {
        return size;
    }
}
