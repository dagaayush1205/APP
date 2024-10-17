public class five {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(1000.0); 
        
        // Update the balance using the mutable function (e.g., deposit)
        account.updateBalance(500.0);  // Depositing 500
        System.out.println("Updated Balance: " + account.getBalance());

        // Calculate interest using the immutable function
        double interest = InterestCalculator.calculateInterest(account.getBalance(), 5.0);  // 5% interest rate
        System.out.println("Interest Earned: " + interest);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Mutable function to update the balance
    public void updateBalance(double amount) {
        this.balance += amount;  // Modify the balance
    }

    // Getter to access balance
    public double getBalance() {
        return balance;
    }
}

class InterestCalculator {
    // Immutable function to calculate interest earned
    public static double calculateInterest(double balance, double rate) {
        return balance * (rate / 100);
    }
}

