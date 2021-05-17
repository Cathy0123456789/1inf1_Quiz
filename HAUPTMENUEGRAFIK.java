import java.awt.*;
import java.awt.event.*;

class HAUPTMENUEGRAFIK
{
    Frame hauptfenster;
    Label begrueßung;
    Button start;

    HAUPTMENUEGRAFIK (Frame hauptf)
    {
        hauptfenster = hauptf;
        
        hauptfenster = new Frame();
        hauptfenster.setSize(1000,500);
        hauptfenster.setLocation(10,50);
        hauptfenster.setVisible(true);
        hauptfenster.setLayout(null);

        begrueßung = new Label();
        begrueßung.setSize(200,50);
        begrueßung.setLocation(325,150);
        begrueßung.setVisible(true);
        begrueßung.setText("Herzlich Willkommen und viel Spaß!");
        begrueßung.setEnabled(true);

        hauptfenster.add(begrueßung);

        start = new Button();
        start.setSize(120,50);
        start.setLocation(375,250);
        start.setVisible(true);
        start.setLabel("Spiel starten");
        start.setEnabled(true);

        hauptfenster.add(start);
    }

    void Ausblenden()
    {
        // begrueßung.setVisible(false);
        // begrueßung.setEnabled(false);

        // start.setVisible(false);
        // start.setEnabled(false);
        
        hauptfenster.removeAll();
    }
}