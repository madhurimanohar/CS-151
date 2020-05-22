public class Bank implements Runnable {
    private Account a = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawMoney(5);
            if (a.getBalance() <= -1) {
                System.out.println("Overdrawn amount");
            }
            depositMoney(1);
        }
    }
    
    private void withdrawMoney(int amount) {
        if (a.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing money");
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException ex) {
                // catch exception
            }
            a.withdrawnMoney(amount);
            System.out.println(Thread.currentThread().getName() + " has withdrawn money");
        } 
        else {
            System.out.println(Thread.currentThread().getName() + " doesn't have enough money to draw since current balance is " + a.getBalance());
        }
    }
    
    private void depositMoney(int amount) {
        if (a.getBalance() > 0) {
            System.out.println(Thread.currentThread().getName() + " is depositing money");
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException ex) {
                // catch exception
            }
            a.depositedMoney(amount);
            System.out.println(Thread.currentThread().getName() + " has deposited money");
        } 
        else {
            System.out.println(Thread.currentThread().getName() + " doesn't have enough money for depositing since current balance is " + a.getBalance());
        }
    }
    
    public static void main(String[] args) {
        Bank b = new Bank();
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        t1.setName("Account 1");
        t2.setName("Account 2");
        t1.start();
        t2.start();
    }
}