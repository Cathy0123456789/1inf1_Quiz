import java.awt.*;
import java.awt.event.*;

class HAUPTMENUEGRAFIK
{
    Frame hauptfenster;
    Label begrueßung;
   
    HAUPTMENUEGRAFIK ()
    {
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
    
    }
}