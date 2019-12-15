 
/**
 *
 * @author AhmedSherif
 */
public class CreaditCardChecker {

    private long number;
    private  boolean Valid;

    public CreaditCardChecker(long number) {
        this.number = number;
    }

    // Prompt the user to enter a credit card number as a long integer
    public void print() {
        String numberAsString = Long.toString(number);
        if (isValid(number)) {

            System.out.println(" is valid");
            if (amrican1(number) == 37 || amrican2(number) == 34) {
                System.out.println(number + " is \" American Express-Card\"");
            }
            switch (numberAsString.charAt(0)) {

                case '4':
                    System.out.println(number + " is  \"Visa-Card\"");
                    break;
                case '5':
                    System.out.println(number + " is \" Master-Card\"");
                    break;
                case '6':
                    System.out.println(number + " is \" Discover-Card\"");

                    break;
                default:
                    break;
            }

        } else {
            System.out.println(number + " is invalid");
        }
    }

    /* Return true if the card number is valid */
    public  boolean isValid(long number) {
        boolean valid = ((getSize(number) >= 13 && getSize(number) <= 16)
                && (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37)
                || prefixMatched(number, 34) || prefixMatched(number, 6))
                && (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

        return Valid=valid;
    }

    /* Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        while (number > 0)// stop when number equal one
        {
            number /= 10;// 375110983372669-->37511098337266
            int digit = getDigit((int) (number % 10) * 2);// getDigit(6*2)==12 send to getDight to change it to 1+2=3
            sum += digit;// 0+3
            number /= 10;// 37511098337266-->3751109833726 
        }
        return sum;
    }

    /* Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        while (number > 0) {

            int digit = (int) (number % 10);// 375110983372669-->9
            digit = getDigit(digit);
            sum += digit;
            number /= 100;// 375110983372669-->3751109833726
        }
        return sum;
    }

    /*
	 * Return this number if it is a single digit, otherwise, return the sum ofthe
	 * two digits
     */
    public static int getDigit(int number) {
        // number=12
        if (number < 9) { // false
            return number;
        } else {// true
            return number / 10 + number % 10;// --->12/10--->1 && 12%10--->2=1+2=3
        }
    }

    /* Return the number of digits in d */
    public static int getSize(long d) {
        String num = d + "";
        return num.length();
    }

    /* Return true if the digit d is a prefix for number */
    // (long number, int d) --> (number,34)
    public static boolean prefixMatched(long number, int d) {

        if (d > number) {
            return false;
        }

        long difference = (getSize(number) - getSize(d));// 15-2=13

        return d == (int) (number / Math.pow(10, difference));// 375110983372669/10^13==37

    }

    /**
     * Return the first k number of digits from number. If the number of digits
     * in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {
        if (prefixMatched(number, k)) {
            return k;// --->37
        }
        return number;

    }

    /* get digit 37 */
    public static int amrican1(long number) {

        while (number > 38) {

            number /= 10;

        }
        return (int) number;

    }

    /* get digit 35 */
    public static int amrican2(long number) {

        while (number > 35) {

            number /= 10;

        }
        return (int) number;

    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public boolean isIsValid() {
        
        return Valid;
    }

     

}
