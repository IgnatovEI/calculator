package calculator;

class IntFigureRoman extends IntFigure {

    public IntFigureRoman(int value) {
        figure = value;
    }

    public IntFigureRoman(String s) throws Exception {
        figure = stringToInt(s);
    }
    
    private static Integer stringToInt(String s) throws CalcException {
        switch (s)
        {
            case "I" :
                return 1;
            case "II" :
                return 2;
            case "III" :
                return 3;
            case "IV" :
                return 4;
            case "V" :
                return 5;
            case "VI" :
                return 6;
            case "VII" :
                return 7;
            case "VIII" :
                return 8;
            case "IX" :
                return 9;
            case "X" :
                return 10;
            default:
                throw new CalcException("Нет корректного римского числа 1 <= ... <= 10");
        }
    }

    @Override
    public String toString() {
        return intToString();
    }

    private String intToString() {
        int digit1 = figure % 10;
        int digit2 = figure / 10;

        String result = makeStringOneDigit(digit2, 2) + makeStringOneDigit(digit1, 1);

        return result;
    }
    
    private String makeStringOneDigit(int fig, int digitNumber) {
        String s1, s2, s3;
        if (digitNumber == 1)
        {
            s1 = "I";
            s2 = "V";
            s3 = "X";
        }
        else
        {
            s1 = "X";
            s2 = "L";
            s3 = "C";
        }
        
        String result = "";
        switch (fig)
        {
            case 1: 
            case 2: 
            case 3:
                for(int i = 1; i <= fig; ++i)
                    result += s1;
                break;
            case 4:
                result = s1 + s2;
                break;
            case 5:
                result = s2;
                break;
            case 6: case 7: case 8:
                result = s2;
                for(int i = 6; i <= fig; ++i)
                    result += s1;
                break;
            case 9:
                result = s1 + s3;
                break;
            case 10:
                result = s3;
                break;
        }
        
        return result;
    }
    
}
