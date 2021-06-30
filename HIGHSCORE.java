import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HIGHSCORE
{
    int[] highscore;
    String[] spielerNamen;

    HIGHSCORE()
    {
        highscore = new int[5];
        spielerNamen = new String[5];
        
        DateiInhaltLesen("Highscore.txt");
        
        // for (int i : highscore)
        // {
            // System.out.println(i);
        // }
        // for (String i : spielerNamen)
        // {
            // System.out.println(i);
        // }
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

            for (int i = 0; i < 5; i++)
            {
                highscore[i] = Integer.parseInt(myReader.nextLine());
                spielerNamen[i] = myReader.nextLine();
            }

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Fehler aufgetreten.");
            e.printStackTrace();
        }
    }
}