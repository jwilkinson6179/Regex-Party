package com.regex.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediumRegex {

    // Get the links and Text inside link tags
    // <a href="http://www.hackerrank.com"><h1><b>HackerRank</b></h1></a>
    // Format should return http://www.hackerrank.com, HackerRank
    public String detectLinksAndText(String input){
        String regex = "<a href=\"([^\"]+)\"(?:[^>]*)?>(?:<[^>]+>)*([^<]*)(?:</[^>]+>)*</a>";
        Pattern p = Pattern.compile(regex);
        String result = "";
        Matcher m = p.matcher(input);

        while(m.find()){
            String url = m.group(1);
            String text = m.group(2);
            result += url + "," + text;
        }

        return result;
    }

    // Given a sentence return the count of the subWord
    // Only count the instances where "is" is not followed or preceded by non-word character
    // Example in sentence "existing pessimist optimist this is" and the subWord = "is"
    // subWord occurs in "existing" once
    // subWord occurs in "pessimist" once
    // subWord occurs in "optimist" once
    // subWord occurs in "this" but is followed by a space
    // subWord occurs at end of sentence but is preceded by space
    public int subWordCount(String sentence, String subWord){
        Pattern p = Pattern.compile("(?<=\\w)" + subWord + "(?=\\w)");
        Matcher m = p.matcher(sentence);
        int counter = 0;
        while(m.find()){
            counter++;
        }
        return counter;
    }

    // Write a program to count the total number of frowny smileys in a string.
    // Here are the rules for how to find smileys and determine whether they are happy or frowny:
    // Optionally, a smiley may start with eyebrows. Eyebrows are marked with the character >.
    // Each smiley must have a pair of eyes. The characters used for eyes are :, ;, or 8.
    // Using only eyes, it's difficult to determine whether a smiley is happy or not. So you need to proceed further with the analysis.
    // Optionally, a smiley may cry. Any tears must follow the eyes and are marked with the character '.
    // But be careful, they could be tears of happiness.
    // Optionally, a smiley may have a nose marked with -, o or ~.
    // The last and most evident sign of the smiley's mood is its mouth.
    // A frowny smiley has a mouth marked with one of these characters: (, C, <, [, {, or @.
    // The distinguishing feature of a happy smiley face is a mouth marked with ), ], }, D, or 3.
    // Each smiley starts with eyebrows or eyes and ends with the mouth.
    public int printFrownCount(String input){
        int counter = 0;
        String[] word = input.split(" ");
        for(String s : word){
            if(s.matches(".*[@<C{\\[ \\\\( ].*")){
                counter++;
            }
        }
        return counter;
    }

}
