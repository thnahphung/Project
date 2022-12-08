package bean;

import java.text.DecimalFormat;

public class Format {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public static String format(int num) {
        return decimalFormat.format(num).replace(",", ".");
    }

}
