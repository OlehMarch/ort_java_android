package ghh0stex.calculator;

/**
 * Created by GHhos on 18.11.2016.
 */

public class Calculation
{
    public static String Calculate(String fstOperand, String secOperand, String operation)
    {
        double firstOperand = 0;
        double secondOperand = 0;
        double result = 0;

        firstOperand = Double.valueOf(fstOperand);
        secondOperand = Double.valueOf(secOperand);

        switch (operation)
        {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand == 0)
                {
                    throw new ArithmeticException();
                }
                else
                {
                    result = firstOperand / secondOperand;
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }

        return String.valueOf(result);
    }
}
