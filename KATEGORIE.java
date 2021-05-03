import java.util.ArrayList;

class KATEGORIE
{
    String name;
    ArrayList<FRAGE> fragen;

    KATEGORIE(String kategorieName)
    {
        name = kategorieName;
        ArrayList<FRAGE> fragen = new ArrayList<FRAGE>();
    }

    FRAGE Zufallsfrage()
    {
        int x = (int)(Math.random() * (fragen.size() + 1));
        return fragen.get(x);
    }
}