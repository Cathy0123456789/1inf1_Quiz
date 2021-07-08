import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HIGHSCORE
{
    Frame frame;
    int breite;
    int hoehe;

    // erreichte Punkteanzahl
    int punkte;

    // Highscore-Liste mit Punkteanzahlen
    int[] highscore;
    // Highscore-Liste mit Spielernamen
    String[] spielerNamen;

    // Eingabe-Feld fuer Spielernamen
    JTextField jtext;
    // Name des Spielers
    String name;

    // Highscore anzeigen lassen
    Button b;

    // Datei mit abgespeicherter Highscore-Liste
    String datei;

    HIGHSCORE(Frame frame, int breite, int hoehe, int punkte)
    {
        this.frame = frame;
        this.punkte = punkte;

        // neue Highscore-Liste mit 5 Plätzen
        highscore = new int[5];
        spielerNamen = new String[highscore.length];

        datei = "Highscore.txt";
        DateiInhaltLesen();

        jtext = new JTextField("Namen eingeben");
        jtext.setAlignmentY(JTextField.CENTER);
        jtext.setBounds(breite/2 - breite/6, (int) (0.45 * hoehe), breite/8, hoehe/15);
        jtext.setFont(new Font("Name", Font.BOLD, breite/75));
        frame.add(jtext);

        b = new Button();
        b.setSize(breite/9, hoehe/15);
        b.setLocation(breite/2 + breite/6 - jtext.getSize().width, (int) (0.45 * hoehe));
        b.setLabel("Highscore anzeigen");
        b.setFont(new Font("Antworten", Font.PLAIN, b.getSize().height/5));
        b.setVisible(true);
        b.setEnabled(true);

        frame.add(b);
    }

    /**
     * Speichert den Inhalt der Textdatei in Attributen ab
     */

    void DateiInhaltLesen()
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

    /**
     * Vergleicht Punkte mit Highscore-Liste und updated sie, wenn noetig
     * @param punkte erreichte Punktzahl
     */

    void PunkteErreicht(int punkte)
    {
        for (int i = 0; i < highscore.length; i++)
        {
            if (punkte > highscore[i])
            {
                for (int j = (highscore.length - 1); j > i; j--)
                {
                    highscore[j] = highscore[j-1];
                    spielerNamen[j] = spielerNamen[j-1];
                }
                highscore[i] = punkte;
                spielerNamen[i] = name;
                DateiSchreiben();
                break;
            }
        }
    }

    /**
     * Schreibt abgespeicherte Highscore-Liste in Datei
     */

    void DateiSchreiben()
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter(datei));

            for (int i = 0; i < highscore.length; i++)
            {
                writer.println(highscore[i]);
                writer.println(spielerNamen[i]);
            }

            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Fehler aufgetreten.");
            e.printStackTrace();
        }
    }

    /**
     * Zeigt Highscore-Liste auf Grafik-Oberflaeche an
     */

    void HighScoreAnzeigen()
    {
        for (int i = 1; i <= highscore.length; i++)
        {
            // Nummerierung durch Liste
            Label nr = new Label();
            nr.setSize(b.getSize().width/3, b.getSize().height);
            nr.setAlignment(Label.CENTER);
            nr.setLocation(jtext.getX() + jtext.getSize().width*5/6, b.getY() + b.getSize().height + hoehe/15 + i * 50);
            nr.setFont(new Font("Ende", Font.PLAIN, breite/75));
            nr.setText(String.valueOf(i));
            nr.setVisible(true);
            nr.setEnabled(true);

            frame.add(nr);

            // Punkteanzahl
            Label s = new Label();
            s.setSize(nr.getSize());
            s.setAlignment(Label.CENTER);
            s.setLocation(nr.getX() + nr.getSize().width + breite/10, nr.getY());
            s.setFont(new Font("Ende", Font.PLAIN, breite/75));
            s.setText(String.valueOf(highscore[i-1]));
            s.setVisible(true);
            s.setEnabled(true);

            frame.add(s);

            //Name des Spielers
            Label n = new Label();
            n.setSize(s.getSize());
            n.setLocation(s.getX() + s.getSize().width + breite/10, s.getY());
            n.setFont(s.getFont());
            n.setText(String.valueOf(spielerNamen[i-1]));
            n.setVisible(true);
            n.setEnabled(true);

            frame.add(n);
        }
    }
}