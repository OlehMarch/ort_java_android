package arithmetics;

import java.util.concurrent.ExecutionException;

public class ArithmeticOperations {
	
	public static int calculate(int first, int second, String sign) throws ArithmeticException {
		
		 int result = 0;

         switch (sign)
         {
             case "+":
                 {
                     result = first + second;
                     break;
                 }

             case "-":
                 {
                     result = first - second;
                     break;
                 }

             case "*":
                 {
                     result = first * second;
                     break;
                 }

             case "/":
                 {
                	 if (second == 0)
                	 {
                		 throw new ArithmeticException();
                	 }
                     result = first / second;
                     break;
                 }

             default: break;
         }

         return result;
		
	}
}
