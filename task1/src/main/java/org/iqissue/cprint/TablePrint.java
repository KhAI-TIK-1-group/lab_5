package org.iqissue.cprint;

import org.iqissue.Node;

import java.util.Map;

import static org.iqissue.util.Color.*;

public class TablePrint {
    public static void tableOutput(Map<Character, Node> probabilities, Map<Character, String> codes) {

        String line = YELLOW + "|" + RESET;
        //System.out.println(CYAN + "Input string:" + RESET);
        //System.out.println(Main.getInitialString());

        //System.out.println();
        //ProbabilityUtils.printInitialFrequenciesChar(probabilities);

        System.out.println(YELLOW + "|----------------------------------------------------|" + RESET);
        System.out.println(line + " Character " + line + " Probability " + line + "  Optimal Code  " + line + "Code Len " + line);
        System.out.println(YELLOW + "|-----------|-------------|----------------|---------|" + RESET);

        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            char ch = entry.getKey();

            Node node = probabilities.get(ch);
            double probability = node.getProbability();
            String code = codes.get(ch);
            String character = ch == '\n' ? "\\n" : "" + ch;
            System.out.printf(line + LIGHT_BLUE + "   [ %s ]   " + RESET + line + "   %.4f    " + line + "    %-10s  " + line + "    %-4d " + line + "%n",
                    character, probability, code, code.length());
        }

        System.out.println(YELLOW + "|----------------------------------------------------|" + RESET);
    }
}
