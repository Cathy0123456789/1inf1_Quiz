import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

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

        HauptmenueHinzufuegen();

        frame.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(1);
                }
            }); 
    }

    void HauptmenueHinzufuegen()
    {
        hauptmenue = new HAUPTMENUEGRAFIK(frame, breite, hoehe);
    }

    void HauptmenueAusblenden()
    {
        hauptmenue.Ausblenden();   
    }

    void QuizgrafikHinzufuegen()
    {
        QUIZGRAFIK quiz = new QUIZGRAFIK(frame, breite, hoehe);
    }
}