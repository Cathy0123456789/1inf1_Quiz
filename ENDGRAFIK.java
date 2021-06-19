import java.awt.*;
import java.awt.event.*;

class ENDGRAFIK
{
    Frame hauptfenster;
    Label ende;

    ENDGRAFIK (Frame hauptf, int breite, int hoehe, int punkte)
    {
        hauptfenster = hauptf;

        ende = new Label();
        ende.setSize(breite, hoehe/20);
        ende.setAlignment(Label.CENTER);
        ende.setLocation(0, hoehe/3);
        ende.setFont(new Font("Ende", Font.ITALIC, breite/50));
        ende.setText(String.format("Ende :) Du hast %d Punkte erreicht.", punkte));
        ende.setVisible(true);
        ende.setEnabled(true);

        hauptfenster.add(ende);
    }
}