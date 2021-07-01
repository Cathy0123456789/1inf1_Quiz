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

    int punkte;

    int[] highscore;
    String[] spielerNamen;

    Button b;

    String datei;

    HIGHSCORE(Frame frame, int breite, int hoehe, int punkte)
    {
        this.frame = frame;
        this.punkte = punkte;

        highscore = new int[5];
        spielerNamen = new String[highscore.length];

        datei = "Highscore.txt";
        DateiInhaltLesen();

        JTextField jtext = new JTextField();
        jtext.setBounds(breite/2, hoehe/5, breite/20, hoehe/20);
        jtext.setFont(new Font("Name", Font.BOLD, breite/75));
        frame.add(jtext);

        b = new Button();
        b.setSize(breite/9, hoehe/15);
        b.setLocation((int) (0.45 * breite), (int) (0.65 * hoehe));
        b.setLabel("Highscore anzeigen");
        b.setFont(new Font("Antworten", Font.PLAIN, b.getSize().height/5));
        b.setVisible(true);
        b.setEnabled(true);

        b.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    if (jtext.getText() != "")
                    {
                            
                    }
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });
    }

    /**
     * Speichert den Inhalt einer Textdatei in Attributen ab
     * @param datei die einzulesende Datei
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
                // spielerNamen[i] = myReader.nextLine();
            }

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Fehler aufgetreten.");
            e.printStackTrace();
        }

        for (int i : highscore)
        {
            System.out.println(i);
        }
        // for (String i : spielerNamen)
        // {
        // System.out.println(i);
        // }
    }

    void PunkteErreicht(int punkte)
    {
        for (int i = 0; i < highscore.length; i++)
        {
            if (punkte > highscore[i])
            {
                for (int j = (highscore.length - 1); j > i; j--)
                {
                    highscore[j] = highscore[j-1];
                }
                highscore[i] = punkte;
                DateiSchreiben();
                break;
            }
        }
    }

    void DateiSchreiben()
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter(datei));

            for (int i = 0; i < highscore.length; i++)
            {
                writer.println(highscore[i]);
            }

            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Fehler aufgetreten.");
            e.printStackTrace();
        }
    }
}