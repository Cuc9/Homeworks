package lesson4.parser;

/**
 * Created by arpi on 07.02.2016.
 */
public class Parser {
    public static int myParseInt(String s, int radix)
            throws NumberFormatException {
        boolean isNegative = false;
        int isFirstSign = 0;
        int digit;
        int rezult = 0;
        int i;

        if (s == null || s.length() == 0) {
            throw new NumberFormatException("First argument is null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("Second argument: " + radix + " is too small");
        } else if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("Second argument: " + radix + " is too big");
        }

        // looking for first - or +
        if (s.charAt(0) < '0') {
            isFirstSign = 1;
            if (s.charAt(0) == '-') {
                isNegative = true;
            } else if (s.charAt(0) != '+') {
                throw new NumberFormatException("Wrong string format");
            } else {
                isNegative = false;
            }
        }

        i = s.length() - 1;


        while (i >= isFirstSign) {
            digit = Character.digit(s.charAt(i), radix);
            if (digit == -1) {
                throw new NumberFormatException("Wrong string format");
            }
            rezult += digit * (int) Math.pow(radix, (s.length() - i - 1));
            i--;
        }
        if (isNegative) {
            rezult *= -1;
        }
        return rezult;
    }

    public static void main(String[] args) {
        String sDecimal = "9000000";
        try {
            int numDecimal = Parser.myParseInt(sDecimal, 10);
            System.out.println(numDecimal);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
