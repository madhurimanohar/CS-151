public class Account {
    private int balance = 20;

    public int getBalance() {
        return balance;
    }

    public void withdrawnMoney(int money) {
        int newbalance = balance;
        newbalance = newbalance - money;
        balance = newbalance;
    }
    
    public void depositedMoney(int money) {
        balance += money;
    }
}