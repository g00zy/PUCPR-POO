package util;

public class valueIsLessThanZeroException extends Exception
{
    public valueIsLessThanZeroException()
    {
        super("Invalid. Negative numbers are not supported. The value should be greatter than zero.");
    }
}
