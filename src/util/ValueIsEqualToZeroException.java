package util;

public class ValueIsEqualToZeroException extends Exception
{
    public ValueIsEqualToZeroException()
    {
        super("Invalid. The value should be greatter than zero.");
    }
}
