public class Test {
    public static void main(String[] args) {
        Banker banker = new Banker();
        banker.getNeed(banker.max, banker.alloction);
        banker.printAllocateRes(banker.max, banker.alloction, banker.need, banker.available);
        banker.SecurityAlgorithm();
        banker.BankerAlgorithm();
    }
}
