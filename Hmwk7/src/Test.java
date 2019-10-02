import java.nio.channels.MembershipKey;

public class Test {
    public static void main(String[] args) {
        //testConstruction();
        testsetSetter();
        testidnum();
    }

    public static void testsetSetter(){
        Mankind Cora = new Mankind();
        Mankind Lisa = new Mankind();

        System.out.println("测试setSex：");
        Lisa.setSex("女");
        Cora.setSex("无");
        System.out.println("Lisa的性别是：" + Lisa.getSex());
        System.out.println("Cora的性别是：" + Cora.getSex());

        System.out.println("测试setHeight：");
        Lisa.setHeight(1.57);
        Cora.setHeight(3.25);
        System.out.println("Lisa的身高是：" + Lisa.getHeight());
        System.out.println("Cora的身高是：" + Cora.getHeight());

        System.out.println("测试setWeight：");
        Lisa.setWeight(44.5);
        Cora.setWeight(600);
        System.out.println("Lisa的体重是：" + Lisa.getWeight());
        System.out.println("Cora的体重是：" + Cora.getWeight());
    }

    public static void testidnum() {
        Mankind Cora = new Mankind();
        Mankind Lisa = new Mankind();

        System.out.println("测试setIdnum：");
        Lisa.setIdnum("34052419800101001X");
        Cora.setIdnum("340524198001010018");
        System.out.println("Lisa的身份证号是：" + Lisa.getIdnum());
        System.out.println("Cora的身份证号是：" + Cora.getIdnum());
    }

    public static void testConstruction(){
        System.out.println("测试构造方法：");
//        Mankind Botter = new Mankind("Botter","无",
//                1.81,75.2,"331056199905264499");
//
//        Mankind Cora = new Mankind("Cora","女",
//                1.51,88,"331056199905315569");
//
//        Mankind Harry = new Mankind("Harry","男",
//                1.78,50,"331056197905264499");
//
//        Mankind Ron = new Mankind("Ron","男",
//                1.92,500,"331056199905264499");
//
//        Mankind George = new Mankind("George","男",
//                2.9,62.5,"331056199905264499");
//
//        Mankind Eve = new Mankind("Eve","女",
//                1.2,50.5,"3310561999052564499");
//
//        Mankind Jane = new Mankind("Jane","女",
//                0.8,44.5,"3310561999052625299");
//
//        Botter.eat();
    }
}
