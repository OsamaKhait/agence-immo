import java.text.DecimalFormat;

public class Annonce {
    private String reference;
    private String date;
    private String description;
    private double prixM2Habitable;
    private BienImmobilier bien;
    private static final double COEF_NON_HABITABLE = 0.25;

    // Constructeur de la classe Annonce
    public Annonce(String reference, String date, String description, double prixM2Habitable, BienImmobilier bien) {
        this.reference = reference;
        this.date = date;
        this.description = description;
        this.prixM2Habitable = prixM2Habitable;
        this.bien = bien;
    }
    

    // Méthode pour calculer le prix total de l'annonce
    public double prix() {
        return bien.surfaceHabitable() * prixM2Habitable +
               bien.surfaceNonHabitable() * prixM2Habitable * COEF_NON_HABITABLE;
    }
    

    // Redéfinition de la méthode toString pour afficher les détails de l'annonce
    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return description + "\n" +
               "Annonce: " + reference + " du " + date + "\n" +
                bien.toString() + "\n" +
                description + "\n" +
               "- Prix du m2 habitable: " + prixM2Habitable + " euros \n" +
               "- Prix du m2 non habitable: " + (prixM2Habitable * COEF_NON_HABITABLE) + " euros \n" +
               "Valeur du bien : " + numberFormat.format(prix()) + " euros \n" +
               "Contact : " + bien.getVendeur().getEmail() + " / " + bien.getVendeur().getNumeroTelephone() + "\n" + "-----------------------------------" + "\n"; 
    }
}
