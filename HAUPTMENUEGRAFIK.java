import java.awt.*;
import java.awt.event.*;

class HAUPTMENUEGRAFIK
{
    Frame hauptfenster;
    Label begrueßung;
    Button start;

    HAUPTMENUEGRAFIK (Frame hauptf, int breite, int hoehe)
    {
        hauptfenster = hauptf;

        begrueßung = new Label();
        begrueßung.setSize(breite/3, hoehe/20);
        begrueßung.setLocation(breite/3, hoehe/3);
        begrueßung.setFont(new Font("Willkommen", Font.ITALIC, breite/50));
        begrueßung.setText("Herzlich Willkommen und viel Spaß!");
        begrueßung.setVisible(true);
        begrueßung.setEnabled(true);

        hauptfenster.add(begrueßung);

        start = new Button();
        start.setSize(breite/10, hoehe/10);
        start.setLocation((int) (0.45 * breite), (int) (0.45 * hoehe));
        start.setLabel("Spiel starten");
        start.setVisible(true);
        start.setEnabled(true);

        // Wenn Start Button gedrueckt wird, wird Frame weiß
        start.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    hauptfenster.removeAll();
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });

        hauptfenster.add(start);
    }
}