import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

class GRAFIK
{
    HAUPTMENUEGRAFIK hauptmenue;
    Frame frame;

    // Weite des Bildschirms
    int breite;

    // Hoehe des Bildschirms
    int hoehe;

    GRAFIK(Frame f)
    {
        frame = f;
        
        FrameGroesseAnpassen();

        HauptmenueHinzufuegen();

        // Fenster mit "X" schließen können
        frame.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(1);
                }
            }); 
    }

    void FrameGroesseAnpassen()
    {
        // Abmessungen des Bildschirms herausfinden
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        breite = screenSize.width;
        hoehe = screenSize.height;

        // neues Fenster in Groesse des Bildschirms oeffnen
        frame.setSize(screenSize);
        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setLayout(null);

        // nur zum Test:
        // System.out.println(breite);
        // System.out.println(hoehe);
    }

    void HauptmenueHinzufuegen()
    {
        hauptmenue = new HAUPTMENUEGRAFIK(frame, breite, hoehe);
    }

    /*
     * Loescht alle Inhalte des Frames
     */

    void Uebermalen()
    {
        frame.removeAll();   
    }

    void QuizgrafikHinzufuegen()
    {
        QUIZGRAFIK quiz = new QUIZGRAFIK(frame, breite, hoehe);
    }
}