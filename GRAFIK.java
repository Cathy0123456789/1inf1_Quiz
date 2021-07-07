import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.ArrayList;

class GRAFIK
{
    Frame frame;

    HAUPTMENUEGRAFIK hauptmenue;
    AUSWAHLGRAFIK auswahl;

    // Weite des Bildschirms in Pixel
    int breite;

    // Hoehe des Bildschirms in Pixel
    int hoehe;

    QUIZ quiz;

    // ArrayList mit allen Kategorien
    ArrayList<KATEGORIE> kategorien;
    // ArrayList mit vom Spieler ausgewaehlten Kategorien
    ArrayList<KATEGORIE> ausgewaehlteKat;

    // Verteilung der Fragen auf Schwierigkeitsgrade
    int [] anzahlFragen;

    GRAFIK(Frame f, QUIZ quiz, int[] anzahlFragen)
    {
        frame = f;
        this.quiz = quiz;
        this.anzahlFragen = anzahlFragen;
        kategorien = quiz.kategorien;

        // neues Fenster erstellen
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

        // Wenn Button gedrueckt wird, werden Frame-Inhalte geloescht und die Kategorien-Auswahl angezeigt
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
                    // Abspeicherung der vom Spieler ausgewaehlten Kategorien
                    ausgewaehlteKat = auswahl.CheckboxenAuslesen();
                    if (ausgewaehlteKat.size() != 0)
                    {
                        frame.removeAll();
                        QuizgrafikHinzufuegen();
                    }
                    else
                    {
                        Label auswaehlen = new Label();
                        auswaehlen.setSize(breite, hoehe/20);
                        auswaehlen.setAlignment(Label.CENTER);
                        auswaehlen.setLocation(0, auswahl.start.getY() + hoehe/10);
                        auswaehlen.setFont(new Font("new", Font.PLAIN, breite/75));
                        auswaehlen.setText("Bitte mindestens eine Kategorie auswählen :)");
                        auswaehlen.setVisible(true);
                        auswaehlen.setEnabled(true);
                        frame.add(auswaehlen);
                    }
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
        QUIZGRAFIK q = new QUIZGRAFIK(frame, breite, hoehe, quiz, ausgewaehlteKat, anzahlFragen);
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