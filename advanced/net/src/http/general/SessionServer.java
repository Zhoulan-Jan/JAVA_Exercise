package http.general;

import java.io.*;
import java.util.UUID;

public class SessionServer {
    private static String dir = "会话Session";

    //存放用户信息（存放在以id命名的文件中），给出Session-id
    public static String put(User user) throws IOException {
        String SessionId = UUID.randomUUID().toString();
        String filename = dir + "\\" + SessionId;
        OutputStream os = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(user);
        os.close();
        return SessionId;
    }

    //根据Session-id，给出用户信息
    public static User get(String SessionId) throws IOException {
        String filename = dir + "\\" + SessionId;
        InputStream is = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(is);

        User user = null;
        try {
            user = (User) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        is.close();
        return user;
    }
}
