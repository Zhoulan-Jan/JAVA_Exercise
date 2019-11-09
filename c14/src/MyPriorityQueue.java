public class MyPriorityQueue {
    //优先级队列  优先级最高的元素（堆顶元素）先出队列
    //以大堆为例

    int[] arr = new int[100];
    int size = 0;

    //入队
    public void offer(int elem) {  //尾插元素，再对数组向上调整
        arr[size++] = elem;
        shiftUp(arr,size - 1);
    }

    public void shiftUp(int[] array, int index) { //index表示要调整的元素下标
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    //出队
    public int poll() {
        //用最后一个元素覆盖第一个元素
        int oldValue = arr[0];
        arr[0] = arr[--size];
        //第一个元素向下调整
        shiftDown(arr,0);
        return oldValue;
    }

    public void shiftDown(int[] array, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //取队首元素
    public int peek() {
        return arr[0];
    }
}
