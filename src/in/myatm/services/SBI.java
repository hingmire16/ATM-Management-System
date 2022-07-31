package in.myatm.services;
import in.myatm.exception.InsufficientBalanceException;
import in.myatm.exception.InvalidAmountException;

public class SBI implements Bank {
    private double bal;

    public void deposit(double amount) throws InvalidAmountException {
        if(amount<=0)
            throw new InvalidAmountException("Invalid Amount");
        bal=bal+amount;
    }

    public double withdraw(double amount)throws InvalidAmountException, InsufficientBalanceException {
        if(amount<=0)
            throw new InvalidAmountException("Invalid Amount");
        else if(amount>bal)
            throw new InsufficientBalanceException("Insufficient Balance");
        bal=bal-amount;
        return amount;
    }

    public void checkBalance() {
        System.out.println("Amount left in your account = "+this.bal);
    }
}
