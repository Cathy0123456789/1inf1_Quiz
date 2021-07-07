import java.awt.*;
import java.awt.event.*;

class ENDGRAFIK
{
    Frame frame;

    Label ende;

    // Button um zurueck zum Hauptmenue zu gelangen
    Button start;

    HIGHSCORE high;

    ENDGRAFIK(Frame frame, int breite, int hoehe, int punkte)
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

        start = new Button();
        start.setSize(breite/10, hoehe/15);
        start.setLocation((int) (0.45 * breite), (int) (0.60 * hoehe));
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
                    // neues Spiel beginnen
                    frame.dispose();
                    PROGRAMM p = new PROGRAMM();
                    p.main(new String[1]);
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });

        frame.add(start);

        high = new HIGHSCORE(frame, breite, hoehe, punkte);

        high.b.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    // eingegebenen Namen in Highscore-Liste einfuegen
                    if (!high.jtext.getText().equals("Namen eingeben"))
                    {
                        boolean nameExistiert = false;
                        Label waehlen = new Label();

                        for (String namen : high.spielerNamen)
                        {
                            if (high.jtext.getText().equals(namen))
                            {
                                nameExistiert = true;
                                waehlen.setSize(breite/6, hoehe/20);
                                waehlen.setLocation(breite/8, (int) (0.45 * hoehe));
                                waehlen.setFont(new Font("new", Font.ITALIC, breite/75));
                                waehlen.setText("Name existiert bereits");
                                waehlen.setVisible(true);
                                waehlen.setEnabled(true);
                                frame.add(waehlen);
                                break;
                            }
                        }
                        
                        if (!nameExistiert)
                        {
                            frame.remove(waehlen);
                            high.name = high.jtext.getText();
                            high.PunkteErreicht(punkte);
                            start.setLocation(start.getX(), start.getY() + hoehe/5);
                            high.HighScoreAnzeigen();
                            high.b.removeMouseListener(this);
                        }
                    }
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });
    }
}