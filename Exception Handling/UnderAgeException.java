package customExceptions;

public class UnderAgeException extends  RuntimeException{
    public UnderAgeException(String message){
        super(message);
    }
}
