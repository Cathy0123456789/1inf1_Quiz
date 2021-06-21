import java.util.ArrayList;
import java.io.File;

class QUIZ
{
    public ArrayList<KATEGORIE> kategorien;

    // Fragenanzahl pro Quiz
    int fragenanzahl;

    QUIZ(int fragenanzahl)
    {
        this.fragenanzahl = fragenanzahl;
        kategorien = new ArrayList<KATEGORIE>();
    }

    /**
     * Liest Ordner-Namen (= Kategorien) aus dem Ordner "Fragen" ein
     */

    void KategorienEinlesen()
    {
        File[] directories = new File("Fragen").listFiles(File::isDirectory);

        for (File i : directories)
        {
            String kat = i.toString();
            kategorien.add(new KATEGORIE(kat.substring(7, kat.length())));
        }
    }
}