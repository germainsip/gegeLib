package org.gerblog.tools;

import java.util.regex.Pattern;

public class Verification {
    final static Pattern texte = Pattern.compile("\\p{IsAlphabetic}*$");
    final static Pattern num = Pattern.compile("\\p{Digit}*$");

    public static boolean verifTexte(String champ){
        return texte.matcher(champ).matches();
    }

    public static boolean verifNum(String champ){
        return num.matcher(champ).matches();
    }
}
