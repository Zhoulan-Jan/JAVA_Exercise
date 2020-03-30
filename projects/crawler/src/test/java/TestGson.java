import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class TestGson {
    static class Test {
        private int aaa; //因为 aaa 的值 1 是 int 类型的
        private int bbb;
    }
    public static void main(String[] args) {
        //创建一个 Gson 对象
        Gson gson = new GsonBuilder().create();

        //把键值对数据转为 JSON 格式的字符串
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "曹操");
        map.put("skill1", "三段跳");
        map.put("skill2", "剑气");
        String res = gson.toJson(map);
        System.out.println(res);

        //把 JSON 格式字符串转为键值对数据
        String jsonStr = "{\"aaa\":1, \"bbb\":2}";
        //Test.class 取出当前这个类的类对象
        // fromJson 方法实现，依赖 反射 机制
        Test t = gson.fromJson(jsonStr, Test.class);
        System.out.println(t.aaa);
        System.out.println(t.bbb);
    }
}
