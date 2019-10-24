package skd;

public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getInt() {
        return value;
    }

    public boolean isEven() {
        if (this.value % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isOdd() {
        if (this.value % 2 != 0) {
            return true;
        }
        return false;
    }

    public boolean isPrime() {
        for (int i = 2; i < value/2;i++) {
            if (this.value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(int x) {
        if (this.value == x) {
            return true;
        }
        return false;
    }

    public int parseInt(String x) {
        return Integer.valueOf(x);
    }
}
