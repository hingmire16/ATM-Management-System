import  java.util.Scanner;
import in.myatm.exception.InsufficientBalanceException;
import in.myatm.exception.InvalidAmountException;
import in.myatm.services.Bank;

public class ATM
{
    public static void main(String[] args) {
        String bankName = null;
        String nextOption = null;
        int option=0;
        double amount = 0.0;
        double withdrawAmount = 0.0;

        Scanner sc=new Scanner(System.in);

        outer:
        while(true) {
            System.out.println("Enter ATM card (BankName) :");
            bankName="in.myatm.services." + sc.next();
            try {
                Bank bank=(Bank)Class.forName(bankName) .getDeclaredConstructor () .newInstance () ;

                inner:
                while(true) {
                    System.out.println("\n******************WELCOME******************");
                    System.out.println("\n------------Choose Operation------------");
                    System.out.println("1.Deposit");
                    System.out.println("2.Withdraw");
                    System.out.println("3.Balance Enquiry");
                    System.out.println("4.Exit");
                    option=sc.nextInt();

                    try{
                        switch(option) {
                            case 1:System.out.println("Enter Amount to deposit : ");
                                amount=sc.nextDouble();
                                bank.deposit(amount);
                                System.out.println(amount + "Rs deposited in your account successfully.");
                                break;

                            case 2:System.out.println("Enter amount to withdraw : ");
                                amount=sc.nextDouble();
                                withdrawAmount=bank.withdraw(amount);
                                System.out.println("Collect "+withdrawAmount+" Cash");
                                break;

                            case 3: bank.checkBalance();
                                 break;

                            case 4:
                                break inner;

                            default:System.out.println("Invalid Option");
                        } //Switch Case

                        System.out.println("\n DO you want to continue Enter Yes or No:");
                        nextOption=sc.next();
                        if(nextOption.equalsIgnoreCase("No")) {
                            System.out.println("Thank You !!!! ");
                            break outer;
                        }
                    } //Inner Try Block

                    catch(InvalidAmountException | InsufficientBalanceException |Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } //Outer Try Block
            catch(ClassNotFoundException e) {
                System.out.println("\nEntered bank name is not valid..."+"\nPlease enter valid bank name:");
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
