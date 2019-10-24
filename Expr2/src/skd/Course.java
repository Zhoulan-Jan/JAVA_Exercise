package skd;

public class Course {
    private String cNumber;
    private String Cname;
    private String Cuit;

    public Course(String cNumber, String cname, String cuit) {
        this.cNumber = cNumber;
        Cname = cname;
        Cuit = cuit;
    }

    public String printCourseInfo() {
        return "课程编号：" +cNumber + "  课程名：" + Cname
                + "  学分数：" + Cuit;
    }
}
