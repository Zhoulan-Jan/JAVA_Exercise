public class JudgeZodiac{
    public static void main(String[] args) {
        int year = 1986;
       
        Judge(year);

        String Zodiac = Judge2 (year);
        System.out.println(Zodiac);
    }

    //判断生肖
    public static void Judge (int year){
        int n = (year - 1779) % 12;
        switch(n){
            case 0: System.out.println("猪");
                    break;
            case 11: System.out.println("狗");
                    break;
            case 10: System.out.println("鸡");
                    break;
            case 9: System.out.println("猴");
                    break;
            case 8: System.out.println("羊");
                    break;
            case 7: System.out.println("马");
                    break;
            case 6: System.out.println("蛇");
                    break;
            case 5: System.out.println("龙");
                    break;
            case 4: System.out.println("兔");
                    break;
            case 3: System.out.println("虎");
                    break;
            case 2: System.out.println("牛");
                    break;
            case 1: System.out.println("鼠");
                    break;
        }
    }

    //有返回值
    public static String Judge2(int year){
        int n = (year - 1779) % 12;
        switch (n){
            case 0:return "猪"; 
            case 11:return "狗"; 
            case 10:return "鸡";
            case 9:return "猴";
            case 8:return "羊"; 
            case 7:return "马"; 
            case 6:return "蛇"; 
            case 5:return "龙"; 
            case 4:return "兔"; 
            case 3:return "虎"; 
            case 2:return "牛"; 
            case 1:return "鼠"; 
            default: return "输入错误";
        }
    }
}