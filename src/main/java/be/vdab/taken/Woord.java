package be.vdab.taken;
//kak
class Woord {
    private final String woord;

    Woord(String woord) {
        this.woord = woord;
    }

    boolean isPalindroom() {
        var omgekeerd = new StringBuilder(woord).reverse().toString();
        return woord.equals(omgekeerd);
    }
}
