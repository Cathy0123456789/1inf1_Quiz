import java.awt.*;
import java.awt.event.*;

class PROGRAMM
{
    int punkte;
    int[] highscore;
    static QUIZ quiz;
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

        
        // KATEGORIE k = quiz.kategorien.get(0);
        // FRAGE f = k.Zufallsfrage();
        
        Frame frame = new Frame();
        
        grafik1 = new GRAFIK(frame);
    }
}