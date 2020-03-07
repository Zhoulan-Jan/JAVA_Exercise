package http.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//整个对象保存在文件里要实现序列化
public class User implements Serializable {
    public int num;
    public String name;
    public String balance; //账户余额

    public User(int num, String name, String balance) {
        this.num = num;
        this.name = name;
        this.balance = balance;
    }

    static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "哈利波特", "500"));
        users.add(new User(2, "赫敏", "800"));
        users.add(new User(3, "罗恩", "200"));
        users.add(new User(4, "王俊凯", "9999"));
    }

    static User fineUser(String username) {
        for (User user : users) {
            if (user.name.equals(username)) {
                return user;
            }
        }
        return null;
    }
}
