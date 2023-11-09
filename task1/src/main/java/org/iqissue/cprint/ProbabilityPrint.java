package org.iqissue.cprint;

import org.iqissue.Node;

import java.util.Map;

import static org.iqissue.util.Color.*;

public class ProbabilityPrint {
    public static void printInitialFrequenciesNode(Map<Character, Node> probabilities) {
        System.out.println(PURPLE + "Initial frequency values:" + RESET);

        double countSum = 0.0;
        int i = 0;
        for (Map.Entry<Character, Node> entry : probabilities.entrySet()) {
            char ch = entry.getKey();

            Node node = probabilities.get(ch);
            double probability = node.getProbability();
            String character = ch == '\n' ? "\\n" : "" + ch;
            countSum += probability;

            System.out.printf(BLUE + "[%s]" + RESET + " = %.4f%s", character, probability, (++i % 7 == 0) ? "\n" : " ");
        }

        System.out.println(PURPLE + "\nSum of frequencies  = " + RESET + BOLD + countSum + "\n" + RESET);
    }
}
