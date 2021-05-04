import java.util.ArrayList;

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
    
    /*
     * Frage zu ArrayList hinzufuegen
     */
    
    void FrageHinzufuegen(FRAGE frage)
    {
        fragen.add(frage);
    }

    FRAGE Zufallsfrage()
    {
        int x = (int)(Math.random() * (fragen.size() + 1));
        return fragen.get(x);
    }
}