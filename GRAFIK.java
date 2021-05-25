import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

class GRAFIK
{
    HAUPTMENUEGRAFIK hauptmenue;
    Frame frame;

    // Weite des Bildschirms in Pixel
    int breite;

    // Hoehe des Bildschirms in Pixel
    int hoehe;

    GRAFIK(Frame f, FRAGE fr)
    {
        frame = f;
        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setLayout(null);
        FrameGroesseAnpassen();

        HauptmenueHinzufuegen(fr);

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

        // nur zum Test:
        // System.out.println(breite);
        // System.out.println(hoehe);
    }

    /**
     * Erstellt eine neue Hauptmenue-Oberflaeche, die sich durch Druecken eines
     * Buttons selbst uebermalt und eine Quizgrafik-Oberfläche erstellt
     */

    void HauptmenueHinzufuegen(FRAGE f)
    {
        hauptmenue = new HAUPTMENUEGRAFIK(frame, breite, hoehe);

        // Wenn Start Button gedrueckt wird, werden Frame-Inhalte geloescht und die Fragen angezeigt
        hauptmenue.start.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    Uebermalen();
                    QuizgrafikHinzufuegen(f);
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });
    }

    /**
     * Erstellt eine neue Quizgrafik-Oberflaeche
     */

    void QuizgrafikHinzufuegen(FRAGE f)
    {
        QUIZGRAFIK quiz = new QUIZGRAFIK(frame, breite, hoehe);
        quiz.FrageAnzeigen(f);
    }

    /**
     * Loescht alle Inhalte des Frames
     */

    void Uebermalen()
    {
        frame.removeAll();   
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