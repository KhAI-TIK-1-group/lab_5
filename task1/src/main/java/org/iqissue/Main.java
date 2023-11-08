package org.iqissue;

import org.iqissue.cprint.TablePrint;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Type the text to be encoded");
        System.out.println("Use Huffman for a default text, or leave blank to stop.");
        String text = in.nextLine().trim();

        if (text.isEmpty()) {
            return;
        }

        if (text.equalsIgnoreCase("Huffman")) {
            text =
                    """
                            In computer science and information theory, a Huffman code is a particular type
                            of optimal prefix code that is commonly used for lossless data compression. The
                            process of finding and/or using such a code proceeds by means of Huffman coding,
                            an algorithm developed by David A. Huffman while he was a Ph.D. student at MIT,
                            and published in the 1952 paper "A Method for the Construction of
                            Minimum-Redundancy Codes".""";
        }

        System.out.println();
        Huffman huff = new Huffman();
        String data = huff.encode(text);

        int normalSize = text.length() * 8;
        int compressedSize = data.length();
        double rate = 100.0 - (compressedSize * 100.0 / normalSize);

        System.out.println("Normal size: " + normalSize);
        System.out.println("Compressed size: " + compressedSize);
        System.out.printf("Compressed is %.2f%% smaller than the original. %n", rate);
        System.out.println();
        System.out.println("Encoded data:");
        System.out.println(data);
        System.out.println();
        System.out.println("Decoded text:");
        System.out.println(huff.decode(data));
        System.out.println();
        System.out.println();
        TablePrint.tableOutput(Huffman.probabilities, Huffman.getEncodedMap());
    }
}