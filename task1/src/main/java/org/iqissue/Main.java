package org.iqissue;

import org.iqissue.cprint.TablePrint;
import static org.iqissue.util.Color.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Text to be encoded");

        String text =
                """
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Amet massa vitae tortor condimentum lacinia quis. Ut lectus arcu bibendum at
                        varius vel pharetra vel. Interdum consectetur libero id faucibus nisl tincidunt. Urna et pharetra
                        pharetra massa massa ultricies mi quis hendrerit. Ultrices mi tempus imperdiet nulla. Nec feugiat nisl
                        pretium fusce id velit ut tortor. Fames ac turpis egestas sed tempus urna et pharetra. Ultrices in
                        iaculis nunc sed augue lacus viverra vitae. Diam ut venenatis tellus in metus vulputate eu. Justo eget
                        magna fermentum iaculis eu. Porta nibh venenatis cras sed felis eget velit. Turpis egestas pretium
                        aenean pharetra magna. Velit sed ullamcorper morbi tincidunt ornare. Ipsum a arcu cursus vitae congue
                        mauris rhoncus aenean vel. Diam quis enim lobortis scelerisque fermentum dui. Et molestie ac feugiat
                        sed lectus vestibulum mattis ullamcorper. Ut enim blandit volutpat maecenas volutpat blandit aliquam.
                        Consectetur adipiscing elit ut aliquam.""";


        System.out.println();
        Huffman huff = new Huffman();
        String data = huff.encode(text);

        int normalSize = text.length() * 8;
        int compressedSize = data.length();
        //double rate = 100.0 - (compressedSize * 100.0 / normalSize);

        System.out.println(RED + "Normal size: " + RESET + normalSize);
        System.out.println(RED + "Compressed size: " + RESET + compressedSize);
        //System.out.printf("Compressed is %.2f%% smaller than the original. %n", rate);
        System.out.println();
        System.out.println(RED + "Encoded data:" + RESET);
        String[] xx = cutString(data, 192);
        for (String zxc : xx) {
            System.out.println(zxc);
        }
        System.out.println();
        System.out.println(RED + "Decoded text:" + RESET);
        System.out.println(huff.decode(data));
        System.out.println();
        System.out.println();
        TablePrint.tableOutput(Huffman.probabilities, Huffman.getEncodedMap());
    }

    public static String[] cutString(String input, int chunkSize) {
        int len = input.length();
        int numOfChunks = (int) Math.ceil((double) len / chunkSize);
        String[] chunks = new String[numOfChunks];

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, len);
            chunks[i] = input.substring(start, end);
        }

        return chunks;
    }
}