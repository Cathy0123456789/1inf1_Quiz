import java.awt.*;
import java.awt.event.*;

class ENDGRAFIK
{
    Frame frame;
    Label ende;
    Button start;

    ENDGRAFIK (Frame frame, int breite, int hoehe, int punkte)
    {
        this.frame = frame;

        // "Ende: Du hast __ Punkte erreicht."
        ende = new Label();
        ende.setSize(breite, hoehe/20);
        ende.setAlignment(Label.CENTER);
        ende.setLocation(0, hoehe/3);
        ende.setFont(new Font("Ende", Font.ITALIC, breite/50));
        ende.setText(String.format("Ende :) Du hast %d Punkte erreicht.", punkte));
        ende.setVisible(true);
        ende.setEnabled(true);
        
        frame.add(ende);
        
        // Button um zurueck zum Hauptmenue zu gelangen
        start = new Button();
        start.setSize(breite/10, hoehe/15);
        start.setLocation((int) (0.45 * breite), (int) (0.45 * hoehe));
        start.setLabel("Neues Spiel starten");
        start.setFont(new Font("Neu", Font.PLAIN, start.getSize().height/5));
        start.setVisible(true);
        start.setEnabled(true);
        
        start.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    frame.removeAll();
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });
            
        frame.add(start);
    }
}