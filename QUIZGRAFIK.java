import java.awt.*;
import java.awt.event.*;

class QUIZGRAFIK
{
    Button antwort1;
    Button antwort2;
    Button antwort3;
    Button antwort4;
    Label fragenAnzeige;

    // Breite des Bildschirms
    int breite;

    // Hoehe des Bildschirms
    int hoehe;

    int antwortButtonBreite;
    int antwortButtonHoehe;

    QUIZGRAFIK (Frame quizfenster, int breite, int hoehe)
    {
        this.breite = breite;
        this.hoehe = hoehe;

        antwortButtonBreite = (int) (0.4 * breite);
        antwortButtonHoehe = hoehe/10;

        int abstandSeite = (int) (0.07 * breite);
        antwort1 = neueAntwort(abstandSeite, (int) (0.6 * hoehe), "Antwort 1");
        antwort2 = neueAntwort(breite - abstandSeite - antwortButtonBreite , antwort1.getY(), "Antwort 2");
        antwort3 = neueAntwort(abstandSeite, antwort1.getY() + antwortButtonHoehe + hoehe/20, "Antwort 3");
        antwort4 = neueAntwort(antwort2.getX(), antwort3.getY(), "Antwort 4");

        quizfenster.add(antwort1);
        quizfenster.add(antwort2);
        quizfenster.add(antwort3);
        quizfenster.add(antwort4);

        fragenAnzeige = new Label();
        fragenAnzeige.setSize(breite/25, hoehe/40);
        fragenAnzeige.setLocation(breite/2 - fragenAnzeige.getSize().width/2, hoehe/5);
        fragenAnzeige.setFont(new Font("Frage", Font.ITALIC, breite/75));
        fragenAnzeige.setText("Frage:");
        fragenAnzeige.setVisible(true);
        fragenAnzeige.setEnabled(true);
        quizfenster.add(fragenAnzeige);
    }

    Button neueAntwort(int xPosition, int yPosition, String text)
    {
        Button b = new Button();
        b.setSize(antwortButtonBreite, antwortButtonHoehe);
        b.setLocation(xPosition, yPosition);
        b.setVisible(true);
        b.setLabel(text);
        b.setEnabled(true);
        return b;
    }
}