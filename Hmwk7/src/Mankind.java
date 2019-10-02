public class Mankind {
    //字段
    private String name;
    private String sex;
    private double height;
    private double weight;
    private String idnum;

    //方法
    public void eat() {
        System.out.println(name + "在吃饭");
    }
    public void sleep() {
        System.out.println(name + "在睡觉");
    }

    //构造方法
//    public Mankind(String name, String sex, double height, double weight, String idnum) {
//        this.name = name;
//        this.sex = sex;
//        this.height = height;
//        this.weight = weight;
//        this.idnum = idnum;
//    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        if (sex == "男" || sex == "女") {
            this.sex = sex;
        }
        else {
            System.out.println("性别输入错误");
        }
    }

    public void setHeight(double height) {
        if (height > 0 && height < 2.8 ){
            this.height = height;
        }
        else {
            System.out.println("身高输入错误");
        }
    }

    public void setWeight(double weight) {
        if (weight > 0 && weight < 500){
            this.weight = weight;
        }
        else {
            System.out.println("体重输入错误");
        }
    }

    public void setIdnum(String idnum) {
                     //this.idnum = idnum;
        if (idnum.length() == 18) {
            if (checkCode(idnum) == true) {
                this.idnum = idnum;
            }
        } else {
            System.out.println("身份证输入错误");
        }
    }

    //身份证校验码
    public static boolean checkCode(String id) {
        int sum = 0;
        int[] value = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        for (int i = 0; i < value.length; i++) {
            sum += value[i] * (id.charAt(i) - '0'); //注意ascii码 //189
        }

        char[] code = {'1','0','X','9','8','7','6','5','4','3','2'};
        int ans = sum % 11;
        if (code[ans] == id.charAt(17)) {
            return true;
        } else {
            return false;
        }
    }

    //身份证年份
//    public static boolean checkYears(String id) {
//        //非闰年
//        int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
//
//    }

    //getter
    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getIdnum() {
        return idnum;
    }
}
