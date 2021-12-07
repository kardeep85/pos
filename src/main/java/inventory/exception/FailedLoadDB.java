package inventory.exception;

public class FailedLoadDB extends RuntimeException{

    public FailedLoadDB(String message) {
        super(message);
    }

}
