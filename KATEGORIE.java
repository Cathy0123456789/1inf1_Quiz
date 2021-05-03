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

    void Zufallszahl()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(5 + (int)(Math.random() * (5 + 1)));
        }
    }

    FRAGE Zufallsfrage()
    {
        int x = fragen.size() + (int)(Math.random() * (fragen.size() + 1));
        return fragen.get(x);
    }
}