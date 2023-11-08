package org.iqissue;

import java.util.Map;

public class Node implements Comparable<Node> {

    private char symbol;
    private double probability;
    private static int count;

    private Node left;
    private Node right;

    public Node(char symbol, double probability) {
        this.symbol = symbol;
        this.probability = probability;
    }

    public Node(Node left, Node right) {
        this.symbol = '+';
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getFrequency() {
        if (isLeaf())
            return count;
        return left.getFrequency() + right.getFrequency();
    }

    public double getProbability() {
        return probability;
    }

    public void addProbability(double prob) {
        probability += prob;
    }

    public char getSymbol() {
        return symbol;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void add() {
        count++;
    }

    @Override
    public int compareTo(Node o) {
        return getFrequency() - o.getFrequency();
    }

    @Override
    public String toString() {
        return String.format("%.4f", getProbability());
    }

    public void fillCodeMap(Map<Character, String> codemap, String work) {
        if (isLeaf()) {
            codemap.put(getSymbol(), work);
            return;
        }

        left.fillCodeMap(codemap, work + "0");
        right.fillCodeMap(codemap, work + "1");
    }
}
