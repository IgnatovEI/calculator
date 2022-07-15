package calculator;

class Operation {

    private String operationType;
    private IntFigure figure1, figure2;

    public Operation(String input) throws CalcException
    {
        String[] figures;

        if (input.indexOf("+") > -1)
        {
            figures = input.split("\\+");
            operationType = "+";
        }
        else if (input.indexOf("-") > -1)
        {
            figures = input.split("-");
            operationType = "-";
        }
        else if (input.indexOf("*") > -1)
        {
            figures = input.split("\\*");
            operationType = "*";
        }
        else if (input.indexOf("/") > -1)
        {
            figures = input.split("/");
            operationType = "/";
        }
        else
            throw new CalcException("Строка не содержит корректной математической операции");

        if (figures.length > 2)
            throw new CalcException("Более одного знака одной и той же операции");

        try
        {
            figure1 = new IntFigureArabic(figures[0].trim());
        }
        catch (Exception ex)
        {
            try
            {
                figure1 = new IntFigureRoman(figures[0].trim());
            }
            catch (Exception ex1)
            {
                throw new CalcException("1-е число не является корректным числом 1 <= ... <= 10");
            }
        }

        try {
            figure2 = new IntFigureArabic(figures[1].trim());
        }
        catch (Exception ex) {
            try {
                figure2 = new IntFigureRoman(figures[1].trim());
            }
            catch (Exception ex1) {
                throw new CalcException("2-е число не является корректным числом 1 <= ... <= 10");
            }
        }
    }

    public IntFigure work() throws CalcException {
        IntFigure result;

        if (figure1 instanceof IntFigureArabic) // 1-е число - арабское
        {
            if (figure2 instanceof IntFigureArabic) // 2-е - тоже арабское
            {
                if (operationType.equals("+"))
                    result = new IntFigureArabic(figure1.getFigure() + figure2.getFigure());
                else if (operationType.equals("-"))
                    result = new IntFigureArabic(figure1.getFigure() - figure2.getFigure());
                else if (operationType.equals("*"))
                    result = new IntFigureArabic(figure1.getFigure() * figure2.getFigure());
                else
                    result = new IntFigureArabic(figure1.getFigure() / figure2.getFigure());
            }
            else  // 2-е - римское
                throw new CalcException("Числа разного типа");
        }
        else // 1-е число - римское
        {
            if (figure2 instanceof IntFigureRoman)  // 2-е - тоже римское
            {
                int res;
                if (operationType.equals("+"))
                    res = figure1.getFigure() + figure2.getFigure();
                else if (operationType.equals("-"))
                    res = figure1.getFigure() - figure2.getFigure();
                else if (operationType.equals("*"))
                    res = figure1.getFigure() * figure2.getFigure();
                else
                    res = figure1.getFigure() / figure2.getFigure();
                
                if (res <= 0)
                    throw new CalcException("Римскими цифрами нельзя записать неположительное число");

                result = new IntFigureRoman(res);
            }
            else  // 2-е - арабское
                throw new CalcException("Числа разного типа");
        }

        return result;
    }

}
