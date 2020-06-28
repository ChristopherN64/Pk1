package Praktikum_11.Exceptions;

public class EmptyFilenameException extends Exception{
    public EmptyFilenameException()
{
    super();
}
    public EmptyFilenameException(String msg)
    {
        super(msg);
    }
}
