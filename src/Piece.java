import java.text.DecimalFormat;

public abstract class Piece {
    private TypePiece typePiece;
    private String niveau;

    public Piece(TypePiece typePiece, String niveau) {
        this.typePiece = typePiece;
        this.niveau = niveau;
    }

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public String getNiveau() {
        return niveau;
    }

    public abstract double surface();

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return typePiece + " surface : " + numberFormat.format(surface()) + " m2\n";
    }
     
}
