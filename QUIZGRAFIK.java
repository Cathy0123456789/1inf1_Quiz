import java.awt.*;
import java.awt.event.*;

class QUIZGRAFIK
{
    Button antwort1;
    Button antwort2;
    Button antwort3;
    Button antwort4;
    Label fragenAnzeige;
    Label frage;

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

        // 4 Antwort-Buttons
        antwort1 = neueAntwort(abstandSeite, (int) (0.6 * hoehe), "Antwort 1");
        antwort2 = neueAntwort(breite - abstandSeite - antwortButtonBreite , antwort1.getY(), "Antwort 2");
        antwort3 = neueAntwort(abstandSeite, antwort1.getY() + antwortButtonHoehe + hoehe/20, "Antwort 3");
        antwort4 = neueAntwort(antwort2.getX(), antwort3.getY(), "Antwort 4");

        quizfenster.add(antwort1);
        quizfenster.add(antwort2);
        quizfenster.add(antwort3);
        quizfenster.add(antwort4);

        // "Frage:"
        fragenAnzeige = new Label();
        fragenAnzeige.setSize(breite, hoehe/40);
        fragenAnzeige.setAlignment(Label.CENTER);
        fragenAnzeige.setLocation(0, hoehe/5);
        fragenAnzeige.setFont(new Font("FragenAnzeige", Font.ITALIC, breite/75));
        fragenAnzeige.setText("Frage:");
        fragenAnzeige.setVisible(true);
        fragenAnzeige.setEnabled(true);
        quizfenster.add(fragenAnzeige);

        // Frage
        frage = new Label();
        frage.setSize(breite, hoehe/40);
        frage.setAlignment(Label.CENTER);
        frage.setLocation(0, hoehe/4);
        frage.setFont(new Font("Frage", Font.BOLD, antwortButtonHoehe/4));
        frage.setVisible(true);
        frage.setEnabled(true);
        quizfenster.add(frage);
    }

    /**
     * Vorlage zum Erstellen eines Antwort-Buttons
     * @param xPosition x-Position des Buttons
     * @param xPosition y-Position des Buttons
     * @param text Text-Anzeige des Buttons
     * @return neuen Button
     */

    Button neueAntwort(int xPosition, int yPosition, String text)
    {
        Button b = new Button();
        b.setSize(antwortButtonBreite, antwortButtonHoehe);
        b.setLocation(xPosition, yPosition);
        b.setFont(new Font("Antworten", Font.PLAIN, antwortButtonHoehe/5));
        b.setLabel(text);
        b.setVisible(true);
        b.setEnabled(true);
        return b;
    }

    void FrageAnzeigen(FRAGE f)
    {
        frage.setText(f.frage);
        antwort1.setLabel(f.antworten[0]);
        antwort2.setLabel(f.antworten[1]);
        antwort3.setLabel(f.antworten[2]);
        antwort4.setLabel(f.antworten[3]);
    }
}