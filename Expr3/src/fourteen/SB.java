package fourteen;

public class SB extends SA {

    //返回最小公倍数
    @Override
    public int f(int a, int b) {
        //先得到最大公约数
        int bestDivisor  = b;
        int tmp = b; //相除的时候 b 会发生变化
        while (a % b != 0) {
            bestDivisor = a % b;
            a = b;
            b = bestDivisor;
        }
        System.out.println("最大公约数：" + bestDivisor);
        //返回（a*b）/m
        return (a * tmp) / bestDivisor;
    }
}