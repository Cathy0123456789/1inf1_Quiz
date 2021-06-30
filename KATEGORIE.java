import java.util.ArrayList;
import java.io.File;

class KATEGORIE
{
    // Name der Kategorie
    String name;

    // Speicherung aller Fragen einer Kategorie in einer ArrayList
    ArrayList<FRAGE> fragen;

    KATEGORIE(String kategorieName)
    {
        name = kategorieName;
        fragen = new ArrayList<FRAGE>();
    }

    /**
     * Liest Fragen aus dem Ordner mit dem jeweiligen Kategorien-Name ein
     */

    void FragenEinlesen()
    {
        String[] pfadnamen;
        File f = new File("Fragen\\" + name);

        pfadnamen = f.list();

        for (String i : pfadnamen)
        {
            fragen.add(new FRAGE());
        }

        for (int i = 0; i < fragen.size(); i++)
        {
            fragen.get(i).DateiInhaltLesen("Fragen\\" + name + "\\" + pfadnamen[i]);
        }
    }
}