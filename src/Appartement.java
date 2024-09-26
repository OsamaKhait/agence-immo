import java.util.List;
import java.util.ArrayList;

public class Appartement extends BienImmobilier {
    private boolean ascenseur;
    private int etage;
    protected List<Piece> pieces = new ArrayList<>();

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, int etage) {
        super(rue, ville, codePostal, vendeur);
        this.ascenseur = false;
        this.etage = etage;
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, int etage, boolean ascenseur) {
        super(rue, ville, codePostal, vendeur);
        this.ascenseur = ascenseur;
        this.etage = etage;
    }
    

    public List<Piece> getPieces() {
        return super.pieces;
    }

    public String typeBien() {
        long count = getPieces().stream()
                .filter(piece -> piece.getTypePiece().isSurfaceHabitable())
                .count();
        return "T" + (count > 7 ? "7+" : count);
    }

    @Override
    public String toString() {
        String resultat = "Appartement de type " + typeBien();
        if (ascenseur) {
            resultat += " avec ascenseur";
        }
        resultat += " situé au " + etage;
        resultat += super.toString();
        return resultat;
    }
}
