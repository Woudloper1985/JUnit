package be.vdab.theorie;

public class RepositoryException extends RuntimeException {
    public RepositoryException(Exception oorzaak){
        super(oorzaak);
    }
}