package Praktikum_6.Exceptions;

public class CancelException extends Exception {
    public CancelException()
    {
        super();
    }
    public CancelException(String msg)
    {
        super(msg);
    }
}
