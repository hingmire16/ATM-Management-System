package in.myatm.exception;
public class InvalidAmountException extends Throwable{
    public InvalidAmountException() {
        super();
    }

    public InvalidAmountException(String msg) {
        super(msg);
    }
}
