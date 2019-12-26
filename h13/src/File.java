import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void op() {
        try {
            FileReader fr = new FileReader("d:\\student.txt");
            FileWriter fw = new FileWriter("d:\\st.txt");
            int tmp = fr.read();
            while (tmp != -1) {
                fw.write("盛望 \n");
                tmp = fr.read();
            }
            fr.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        op();
    }
}
