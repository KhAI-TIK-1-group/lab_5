package org.iqissue.cprint;

import org.iqissue.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.iqissue.util.Color.*;

public class TablePrint {
    public static void tableOutput(Map<Character, Node> probabilities, Map<Character, String> codes) {
        String TStyle = ORANGE;
        String line = TStyle + "|" + RESET;

        ProbabilityPrint.printInitialFrequenciesNode(probabilities);

        String header = String.format("%s|-------------------------------------------------|%s\n", TStyle, RESET) +
                String.format("%s%s Character %s%s Probability %s%s Optimal Code %s%sCode Len%s%s\n", line, BOLD, line, BOLD, line, BOLD, line, BOLD, RESET, line) +
                String.format("%s|-----------|-------------|--------------|--------|%s\n", TStyle, RESET);

        System.out.print(header);

        List<Map.Entry<Character, String>> sortedEntries = new ArrayList<>(codes.entrySet());

        sortedEntries.sort((entry1, entry2) -> {
            Node node1 = probabilities.get(entry1.getKey());
            Node node2 = probabilities.get(entry2.getKey());
            return Double.compare(node2.getProbability(), node1.getProbability());
        });

        for (Map.Entry<Character, String> entry : sortedEntries) {
            char ch = entry.getKey();
            Node node = probabilities.get(ch);
            double probability = node.getProbability();
            String code = entry.getValue();
            String character = ch == '\n' ? "\\n" : String.valueOf(ch);

            System.out.printf("%s%s" + isNewLine(character) + "%s%s   %.4f    %s%s     %-7s  %s    %-4d%s\n",
                    line, MAGENTA, character, RESET, line, probability, line, RESET, code, line, code.length(), line
            );
        }

        System.out.println(TStyle + "|-------------------------------------------------|" + RESET);
    }

    private static String isNewLine(String character) {
        return (character.equals("\\n") ? "   [ %s ]  " : "   [ %s ]   ");
    }
}
