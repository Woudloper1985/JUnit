package be.vdab.taken;

import java.util.StringTokenizer;

class WoordTeller {

    int telWoorden(String zin) {
        // in delim schrijf je simpelweg alle delimiters achter elkaar tussen "":
        return new StringTokenizer(zin, " ,").countTokens();
    }

    //In principe is de Tokenizer verouderd, maar om gewoon woorden te tellen is ie nog ideaal.
//    int telWoorden(String zin) {
//        return zin.split("[ ,]+").length;
//    }

}
