package in.myatm.exception;
public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
