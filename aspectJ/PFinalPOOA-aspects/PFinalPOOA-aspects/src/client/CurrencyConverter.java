package client;

public class CurrencyConverter {
    public static float convertEuroToCAD(float montantEuro) {
        return montantEuro * 1.5f; // faux taux de conversion de 1 Euro pour 1.5 CAD
    }

    public static float convertCADToEuro(float montantCAD) {
        return montantCAD / 1.5f;
    }
}
