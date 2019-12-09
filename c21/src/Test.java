public class Test {
    public static void main(String[] args) {
        Add.add(9,"梳妆凳","800","18-05-15","古典风格");
        //根据家具名称删除
        Delete.delete("梳妆凳");
        //根据家具名称得到家具的全部信息
        Find.find("衣柜");
        //根据家具名称修改 价格 日期 风格
        Modify.modify("桌子","330","18-02-25","现代前卫风格");
    }
}
