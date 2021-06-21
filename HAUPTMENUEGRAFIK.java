import java.awt.*;
import java.awt.event.*;

class HAUPTMENUEGRAFIK
{
    Frame frame;
    Label begrueßung;
    Button start;

    HAUPTMENUEGRAFIK (Frame frame, int breite, int hoehe)
    {
        this.frame = frame;

        // "Herzlich Willkommen und viel Spaß"
        begrueßung = new Label();
        begrueßung.setSize(breite, hoehe/20);
        begrueßung.setAlignment(Label.CENTER);
        begrueßung.setLocation(0, hoehe/3);
        begrueßung.setFont(new Font("Willkommen", Font.ITALIC, breite/50));
        begrueßung.setText("Herzlich Willkommen und viel Spaß!");
        begrueßung.setVisible(true);
        begrueßung.setEnabled(true);

        frame.add(begrueßung);

        // Button zum Starten des Spiels
        start = new Button();
        start.setSize(breite/10, hoehe/15);
        start.setLocation((int) (0.45 * breite), (int) (0.45 * hoehe));
        start.setLabel("Spiel starten");
        start.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        start.setVisible(true);
        start.setEnabled(true);

        frame.add(start);
    }
}