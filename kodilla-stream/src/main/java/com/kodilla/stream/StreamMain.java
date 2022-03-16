package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Beautiful and interesting text",text -> text.toUpperCase());
        poemBeautifier.beautify("Beautiful and interesting text",text -> "ABC "+text  );
        poemBeautifier.beautify("Beautiful and interesting text",text -> text + " ABC");
        poemBeautifier.beautify("Beautiful and interesting text",text -> text.substring(0,9));
        poemBeautifier.beautify("Beautiful and interesting text",text -> text.replace("e","B"));
        poemBeautifier.beautify("Beautiful and interesting text",text -> text.replace("and interesting","and touching"));

    }

}