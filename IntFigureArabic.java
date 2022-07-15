package calculator;

class IntFigureArabic extends IntFigure {

    public IntFigureArabic(int value) {
        figure = value;
    }

    public IntFigureArabic(String s) throws CalcException {
        try {
            figure = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            throw new CalcException("Некорректное число");
        }
        if (figure < 1 || figure > 10)
            throw new CalcException("Нарушено условие 1 <= ... <= 10");
    }
    
    @Override
    public String toString() {
        return figure.toString();
    }
    
}
