import java.awt.*;
import java.awt.event.*;

class PROGRAMM
{
    int punkte;
    int[] highscore;
    static QUIZ quiz;
    static FRAGE[] ausgewaehlteFragen;
    static GRAFIK grafik1;

    public static void main(String args[])
    {
        // neues Quiz mit 5 Fragen
        quiz = new QUIZ(5);

        // Kategorien aus dem Ordner "Fragen" einlesen
        quiz.KategorienEinlesen();

        // in jeder Kategorie alle Fragen im jeweiligen Ordner einlesen
        for (KATEGORIE kat : quiz.kategorien)
        {
            kat.FragenEinlesen();
        }

        KATEGORIE k = quiz.kategorien.get(3);

        ausgewaehlteFragen = new FRAGE[quiz.fragenanzahl];

        for (int i = 0; i < ausgewaehlteFragen.length; i++)
        {
            int a = k.Zufallsfrage();
            ausgewaehlteFragen[i] = k.fragen.get(a);
            k.fragen.remove(a);
        }

        Frame frame = new Frame();

        grafik1 = new GRAFIK(frame, ausgewaehlteFragen[0]);
        
        //grafik1.NaechsteFrage(ausgewaehlteFragen[1]);
    }
    
}