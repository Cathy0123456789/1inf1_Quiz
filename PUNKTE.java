import java.awt.*;
import java.awt.event.*;

class PUNKTE
{
    int punkte;
    Label punkteAnzeige;

    PUNKTE(Frame frame, int breite, int hoehe)
    {
        punkte = 0;

        punkteAnzeige = new Label();
        punkteAnzeige.setSize(breite, hoehe/20);
        punkteAnzeige.setAlignment(Label.LEFT);
        punkteAnzeige.setLocation((int) (0.9 * breite), hoehe/20);
        punkteAnzeige.setFont(new Font("Punkte", Font.BOLD, breite/100));
        punkteAnzeige.setText("Punkte: " + punkte);
        punkteAnzeige.setVisible(true);
        punkteAnzeige.setEnabled(true);

        frame.add(punkteAnzeige);
    }
    
    /**
     * Erhoeht die Punktzahl
     * @param zahl Zahl der hinzuaddierenden Punkte
     */

    void punkteHinzufuegen(int zahl)
    {
        punkte += zahl;
        punkteAnzeige.setText("Punkte: " + punkte);
    }
}