package calculator;

import java.util.Scanner;

public class Main {

    public static String calc(String input) throws CalcException {
        Operation action = new Operation(input);
        IntFigure result = action.work();
        return result.toString();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try
        {
            String result = calc(str);
            System.out.println(result);
        }
        catch (CalcException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
