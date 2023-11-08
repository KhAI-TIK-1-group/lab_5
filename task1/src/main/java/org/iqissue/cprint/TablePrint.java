package org.iqissue.cprint;

import java.util.Map;

import static org.iqissue.util.Color.*;

public class TablePrint {
    public static void tableOutput(Map<Character, String> codes) {

        String line = YELLOW + "|" + RESET;
        System.out.println(CYAN + "Input string:" + RESET);
        //System.out.println(Main.getInitialString());

        System.out.println();
        //ProbabilityUtils.printInitialFrequenciesChar(probabilities);

        System.out.println(YELLOW + "|--------------------------------------|" + RESET);
        System.out.println(line + " Character " + line + "  Optimal Code  " + line + "Code Len " + line);
        System.out.println(YELLOW + "|-----------|----------------|---------|" + RESET);

        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            char character = entry.getKey();
            String code = codes.get(character);
            System.out.printf(line + LIGHT_BLUE + "   [ %c ]   " + RESET + line + "    %-10s  " + line + "    %-4d " + line + "%n",
                    character, code, code.length());
        }

        System.out.println(YELLOW + "|--------------------------------------|" + RESET);
    }
}
