package main.java.br.edu.amazonia.utils.format;

import java.text.DecimalFormat;

public class FormatadorUtils {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatarDouble(double valor) {
        return df.format(valor);
    }
}
