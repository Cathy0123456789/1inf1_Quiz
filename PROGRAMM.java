import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class PROGRAMM
{
    int punkte;
    int[] highscore;
    static QUIZ quiz;
    static ArrayList<FRAGE> alleFragen;
    static ArrayList<FRAGE> zuStellendeFragen;
    static GRAFIK grafik1;

    public static void main(String args[])
    {
        // neues Quiz mit 5 Fragen
        quiz = new QUIZ(10);

        // Kategorien aus dem Ordner "Fragen" einlesen
        quiz.KategorienEinlesen();

        // in jeder Kategorie alle Fragen im jeweiligen Ordner einlesen
        for (KATEGORIE kat : quiz.kategorien)
        {
            kat.FragenEinlesen();
        }

        // Array mit allen Fragen
        alleFragen = new ArrayList<FRAGE>();

        // Array mit den Fragen, die gestellt werden sollen
        zuStellendeFragen = new ArrayList<FRAGE>();

        // Anzahl Fragen nach Schwierigkeitsgrad: 2-2-3-2-1
        int[] anzahlFragen = {2, 2, 3, 2, 1};

        for (KATEGORIE kat : quiz.kategorien)
        {
            for (FRAGE fr : kat.fragen)
            {
                alleFragen.add(fr);
            }
        }

        for (int p = 1; p <= anzahlFragen.length; p++)
        {
            ArrayList<FRAGE> ausgewaehlteFragen = new ArrayList<FRAGE>();
            for (FRAGE f : alleFragen)
            {
                if (f.schweregrad == p)
                {
                    ausgewaehlteFragen.add(f);
                }
            }

            for (int i = 0; i < anzahlFragen[p-1]; i++)
            {
                int a = Zufallsfrage(ausgewaehlteFragen);
                zuStellendeFragen.add(ausgewaehlteFragen.get(a));
                ausgewaehlteFragen.remove(a);
            }
        }

        Frame frame = new Frame();

        grafik1 = new GRAFIK(frame, quiz, anzahlFragen);
    }

    private static int Zufallsfrage(ArrayList al)
    {
        int x = (int)(Math.random() * al.size());
        return x;
    }
}