package skd;

public class Acount {
    private int id;
    private double balance;
    private double annualInterestRate;
    private String dateCreated;

    public Acount() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        //月利率*12== 年利率
        return this.annualInterestRate/12;
    }

    public void withDraw(int money) {
        this.balance -= money;
    }

    public void deposit(int money) {
        this.balance += money;
    }
}
