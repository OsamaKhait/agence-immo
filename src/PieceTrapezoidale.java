public class PieceTrapezoidale extends Piece {
    private double base1;
    private double base2;
    private double hauteur;

    public PieceTrapezoidale(TypePiece typePiece, String niveau, double base1, double base2, double hauteur) {
        super(typePiece, niveau);
        this.base1 = base1;
        this.base2 = base2;
        this.hauteur = hauteur;
    }

    @Override
    public double surface() {
        return ((base1 + base2 / 2) * hauteur);
    }
}