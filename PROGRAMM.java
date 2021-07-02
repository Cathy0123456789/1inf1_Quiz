import java.awt.*;
import java.awt.event.*;

class PROGRAMM
{
    static QUIZ quiz;
    static GRAFIK grafik1;

    public static void main(String args[])
    {
        // neues Quiz mit 10 Fragen
        quiz = new QUIZ(10);

        // Kategorien aus dem Ordner "Fragen" einlesen
        quiz.KategorienEinlesen();

        // in jeder Kategorie alle Fragen im jeweiligen Ordner einlesen
        for (KATEGORIE kat : quiz.kategorien)
        {
            kat.FragenEinlesen();
        }

        // Anzahl Fragen nach Schwierigkeitsgrad: 2-2-3-2-1
        int[] anzahlFragen = {2, 2, 3, 2, 1};

        Frame frame = new Frame();

        grafik1 = new GRAFIK(frame, quiz, anzahlFragen);
    }
}