package be.vdab.taken;

import java.util.StringTokenizer;

class WoordTeller {

    int telWoorden(String zin) {
        // in delim schrijf je simpelweg alle delimiters achter elkaar tussen "":
        return new StringTokenizer(zin, " ,").countTokens();
        // dit betekent: splits op spatie en komma - niet op het geheel spatie-en-komma!
    }

    //In principe is de Tokenizer verouderd, maar om gewoon woorden te tellen is ie nog ideaal.
//    int telWoorden(String zin) {
//        return zin.split("[ ,]+").length; --> dit levert een verzameling met 1 leeg element op als er geen woorden in staan
    //, dus dan moet je nog een controle inbouwen op null of isEmpty... omslachtig in dit geval.
//    }

}
