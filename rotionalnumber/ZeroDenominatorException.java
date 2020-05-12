package LabDataStructure.rotionalnumber;


/**
 * ZeroDenominatorException - a runtime exception that signals there was a zero denominator
 * for a Rational number.
 * 
 * @author Charles Hoot
 * @version 5.0
 */
public class ZeroDenominatorException extends RuntimeException
{

	public ZeroDenominatorException(String reason)
	{
		super(reason);
	}
}
