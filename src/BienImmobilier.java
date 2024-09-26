import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class BienImmobilier {
    private String rue;
    private String ville;
    private String codePostal;
    private Vendeur vendeur;
    protected List<Piece> pieces = new ArrayList<>();

    public BienImmobilier(String rue, String ville, String codePostal, Vendeur vendeur) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.vendeur = vendeur;
    }

    public void ajouterPiece(Piece piece) {
        pieces.add(piece);
    }

    public double surfaceHabitable() {
        return pieces.stream()
                .filter(piece -> piece.getTypePiece().isSurfaceHabitable())
                .mapToDouble(Piece::surface)
                .sum();
    }

    public double surfaceNonHabitable() {
        return pieces.stream()
                .filter(piece -> !piece.getTypePiece().isSurfaceHabitable())
                .mapToDouble(Piece::surface)
                .sum();
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "\nLocalisation : " + rue + " " + codePostal + " " + ville +
                "\nDescription du bien : \n" + pieces.toString() +
                "\nPour une surface habitable de : " + numberFormat.format(surfaceHabitable()) +
                " m2 et une surface non habitable de : " + numberFormat.format(surfaceNonHabitable()) + " m2.";
    }
}
