import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.ArrayList;

class GRAFIK
{
    HAUPTMENUEGRAFIK hauptmenue;
    AUSWAHLGRAFIK auswahl;
    Frame frame;

    // Weite des Bildschirms in Pixel
    int breite;

    // Hoehe des Bildschirms in Pixel
    int hoehe;

    // Array mit Fragen
    ArrayList<FRAGE> fragen;

    // ArrayList mit Kategorien
    ArrayList<KATEGORIE> kategorien;

    GRAFIK(Frame f, ArrayList<FRAGE> fr, ArrayList<KATEGORIE> kat)
    {
        frame = f;
        fragen = fr;
        kategorien = kat;

        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setLayout(null);
        FrameGroesseAnpassen();

        HauptmenueHinzufuegen();

        Schließen();
    }

    /**
     * Findet Bildschirmgroesse heraus und passt Fenster-Groesse entsprechend an
     */

    void FrameGroesseAnpassen()
    {
        // Abmessungen des Bildschirms herausfinden
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        breite = screenSize.width;
        hoehe = screenSize.height;

        // Fenster-Groesse = Bildschirm-Groesse setzen
        frame.setSize(screenSize);
    }

    /**
     * Erstellt eine neue Hauptmenue-Oberflaeche, die sich durch Druecken eines
     * Buttons selbst uebermalt und eine Quizgrafik-Oberflaeche erstellt
     */

    void HauptmenueHinzufuegen()
    {
        hauptmenue = new HAUPTMENUEGRAFIK(frame, breite, hoehe);

        // Wenn Start Button gedrueckt wird, werden Frame-Inhalte geloescht und die Fragen angezeigt
        hauptmenue.start.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    frame.removeAll();
                    AuswahlgrafikHinzufuegen();
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });
    }

    /**
     * Erstellt eine neue Auswahlgrafik-Oberflaeche und zeigt erste Frage an
     */

    void AuswahlgrafikHinzufuegen()
    {
        auswahl = new AUSWAHLGRAFIK(frame, breite, hoehe, kategorien);
        
        // Wenn Start Button gedrueckt wird, werden Frame-Inhalte geloescht und die Fragen angezeigt
        auswahl.start.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    frame.removeAll();
                    QuizgrafikHinzufuegen();
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });
    }

    /**
     * Erstellt eine neue Quizgrafik-Oberflaeche und zeigt erste Frage an
     */

    void QuizgrafikHinzufuegen()
    {
        QUIZGRAFIK quiz = new QUIZGRAFIK(frame, breite, hoehe, fragen);
        quiz.FrageAnzeigen(fragen.get(0));
    }

    /**
     * Fenster mit "X" schließen können
     */

    void Schließen()
    {
        frame.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(1);
                }
            }); 
    }
}