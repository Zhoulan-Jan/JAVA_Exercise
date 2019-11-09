public class Heap {
    //建一个大根堆

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    //向下调整
    //size 指要调整为堆的部分
    //index指要调整的结点下标
    public void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1; //左孩子
        while (child < size) {
            //找到较大的子树
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            //比较父节点与左/右孩子结点，父节点小则交换，否则break
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            //更新父节点，孩子结点
            parent = child;
            child = parent * 2 + 1;
        }
    }

    //向上调整
    public void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            //比较孩子结点与父节点
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            //更新孩子结点，父结点
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    //建堆
    public void createHeap(int[] array, int size) {
        //从最后一个非叶子结点往前调整  (向下调整）
        for (int i = (size - 1 - 1)/2; i >= 0; i--) {
            shiftDown(array, size, i);
        }

        //从第一个结点向后调整 （向上调整）
        for (int j = 0; j < size; j++) {
            shiftUp(array, size, j);
        }
    }
}