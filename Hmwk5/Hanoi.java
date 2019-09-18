public class Hanoi{
    public static void main(String[] args) {
        int plate = 5;
        char A = 'A';
        char B = 'B';
        char C = 'C';
        H(plate,A,B,C);
    }

    public static void H(int n, char A,char B,char C){
        if (n == 1){
            System.out.pri
            ntf("%c --> %c\n",A,C);
        }
        else {
            H(n-1,A,C,B);
            System.out.printf("%c --> %c\n",A,C);
            H(n-1,B,A,C);
        }
    }
}
