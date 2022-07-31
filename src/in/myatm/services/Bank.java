package in.myatm.services;
import in.myatm.exception.InsufficientBalanceException;
import in.myatm.exception.InvalidAmountException;


public interface Bank {
    public void deposit(double amount) throws InvalidAmountException;
    public double withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException;
    public void checkBalance();
}
