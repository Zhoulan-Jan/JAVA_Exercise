public class Test {
    public static void main(String[] args) {
        //创建对象
//        Person Peter = new Person("Peter",
//                "男","computer");
//
//        Person Botter = new Person("Botter",
//                "男","computer");
//
//        Person Alan = new Person("Alan",
//                "男","science");
//
//        Person Elma = new Person("Elma",
//                "女","computer");
//
//        Person Macy = new Person("Macy",
//                "女","computer");
//
//        Person Lynn = new Person("Lynn",
//                "女","English");
        //是隔离的

        Person [] personsArray = {
               new Person("Peter", "男","computer"),
               new Person("Botter", "男","computer"),
               new Person("Alan", "男","science"),
               new Person("Elma", "女","computer"),
               new Person("Macy", "女","computer"),
               new Person("Lynn", "女","English")
        };  //类似结构体数组
        numOfGirl(personsArray);
    }

    //在同一个专业里找女生数量  该专业的人数
    public static void numOfGirl(Person[] pers){
        int girl1= 0;
        int girl2= 0;
        int girl3= 0;
        int numCom = 0;
        int numEng = 0;
        int numSc = 0;


        for (Person x:pers){
            //找计算机专业学生数量
            if (x.profession.equals("computer")){
                numCom++;
                if(x.sex.equals("女")){
                    girl1++;
                }
            }
            //找科学专业学生数量
            if (x.profession.equals("science")){
                numSc++;
                if(x.sex.equals("女")){
                    girl2++;
                }
            }
            //找英语专业学生数量
            if (x.profession.equals("English")){
                numEng++;
                if(x.sex.equals("女")){
                    girl3++;
                }
            }
        }
        System.out.println("计算机专业女生数量：" + girl1);
        System.out.println("计算机专业男生数量："+(numCom-girl1));

        System.out.println("科学专业女生数量：" + girl2);
        System.out.println("科学专业男生数量："+(numSc-girl2));

        System.out.println("英语专业女生数量：" + girl3);
        System.out.println("英语专业男生数量："+(numEng-girl3));
    }
}
