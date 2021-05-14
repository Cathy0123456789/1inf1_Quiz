import java.awt.*;
import java.awt.event.*;

class GRAFIKOBERFLAECHE
{
    Frame f;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Label x;

    GRAFIKOBERFLAECHE ()
    {
        f = new Frame();
        f.setSize(1000,500);
        f.setLocation(10,50);
        f.setVisible(true);
        f.setLayout(null);

        b1 = new Button();
        b1.setSize(120,50);
        b1.setLocation(50,300);
        b1.setVisible(true);
        b1.setLabel("Antwort 1");
        b1.setEnabled(true);

        b2 = new Button();
        b2.setSize(120,50);
        b2.setLocation(250,300);
        b2.setVisible(true);
        b2.setLabel("Antwort 2");
        b2.setEnabled(true);

        b3 = new Button();
        b3.setSize(120,50);
        b3.setLocation(450,300);
        b3.setVisible(true);
        b3.setLabel("Antwort 3");
        b3.setEnabled(true);

        b4 = new Button();
        b4.setSize(120,50);
        b4.setLocation(650,300);
        b4.setVisible(true);
        b4.setLabel("Antwort 4");
        b4.setEnabled(true);

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);

        x = new Label();
        x.setSize(200,50);
        x.setLocation(325,150);
        x.setVisible(true);
        x.setText("Frage:");
        x.setEnabled(true);

        f.add(x);
    }    
}