package org.iqissue;

import java.util.*;

public class Huffman {
    private static Node root;
    private static Map<Character, String> codemap = new HashMap<>();
    public static Map<Character, Node> probabilities = new HashMap<>();

    private char[] getChars(String text) {
        return text.toCharArray();
    }

    private PriorityQueue<Node> countFrequencies(char[] letters) {
        Map<Character, Node> count = new HashMap<>();
        for (char ch : letters) {
            count.computeIfAbsent(ch, k -> new Node(ch, 0)).add();
            count.get(ch).addProbability(1.0 / letters.length);
        }
        probabilities.putAll(count);
        return new PriorityQueue<>(count.values());
    }

    private Map<Character, String> createCodeMap() {
        Map<Character, String> result = new TreeMap<>();
        root.fillCodeMap(result, "");
        return result;
    }


    private Node createTree(PriorityQueue<Node> nodes) {
        while (nodes.size() > 1) {
            Node node1 = nodes.poll();
            Node node2 = nodes.poll();
            nodes.add(new Node(node1, node2));
        }
        return nodes.poll();
    }



    public String encode(String text) {
        char[] letters = getChars(text);
        root = createTree(countFrequencies(letters));
        codemap = createCodeMap();

        StringBuilder data = new StringBuilder();
        for (char ch : letters) {
            data.append(codemap.get(ch));
        }
        return data.toString();
    }

    public String decode(String data) {
        Node current = root;

        StringBuilder result = new StringBuilder();
        for (char ch : getChars(data)) {
            if (ch == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current.isLeaf()) {
                result.append(current.getSymbol());
                current = root;
            }
        }
        return result.toString();
    }

    public static Map<Character, String> getEncodedMap() {
        return codemap;
    }
}