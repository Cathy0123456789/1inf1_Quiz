import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FRAGE
{
    String frage;

    // Speicherung der 4 Antworten in einem Array
    String[] antworten;

    // Platz der richtigen Antwort im Array
    int richtigeAntwort;

    int schweregrad;

    FRAGE()
    {
        antworten = new String [4];
    }

    /**
     * Vergleich der eingegebenen Antwort mit der richtigen Loesung
     * @param antwort die zu vergleichende Antwort
     * @return wahr, falls eingegebene Antwort richtig
     */

    boolean IstAntwortRichtig(int antwort)
    {
        if (antwort == richtigeAntwort)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Ausgabe der Frage sowie der 4 Antwortmoeglichkeiten auf der Konsole
     */

    void FrageAusgeben()
    {
        System.out.println(frage);
        for (String i : antworten)
        {
            System.out.println(i);
        }
    }

    /**
     * Speichert den Inhalt einer Textdatei in Attributen ab
     * @param datei die einzulesende Datei
     */

    void DateiInhaltLesen(String datei)
    {
        try
        {
            File myObj = new File(datei);
            Scanner myReader = new Scanner(myObj);

            frage = myReader.nextLine();
            for (int i = 0; i < 4; i++)
            {
                antworten[i] = myReader.nextLine(); 
            }
            richtigeAntwort = Integer.parseInt(myReader.nextLine());
            schweregrad = Integer.parseInt(myReader.nextLine());

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Fehler aufgetreten.");
            e.printStackTrace();
        }
    }
}