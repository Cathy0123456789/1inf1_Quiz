import java.awt.*;
import java.awt.event.*;

class QUIZGRAFIK
{
    // Antwort-Buttons
    Button[] antworten;

    // vom Spieler ausgewaehlte Antwort
    Button gedrueckterButton;

    // Frage, die derzeit angezeigt wird
    FRAGE frage;
    // "physische" Anzeige der Frage
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

        antworten = new Button[4];

        // 4 Antwort-Buttons
        antworten[0] = NeueAntwort(abstandSeite, (int) (0.6 * hoehe));
        antworten[1] = NeueAntwort(breite - abstandSeite - antwortButtonBreite , antworten[0].getY());
        antworten[2] = NeueAntwort(abstandSeite, antworten[0].getY() + antwortButtonHoehe + hoehe/20);
        antworten[3] = NeueAntwort(antworten[1].getX(), antworten[2].getY());

        for (Button i : antworten)
        {
            quizfenster.add(i);
            
            // Schauen, ob Antwort-Button angeklickt wird
            i.addMouseListener(new MouseListener()
                {
                    public void mousePressed(MouseEvent me) {}

                    public void mouseReleased(MouseEvent me) {}

                    public void mouseClicked(MouseEvent me)
                    {
                        gedrueckterButton = i;
                        AntwortAngeklickt();
                    }

                    public void mouseExited(MouseEvent me) {}

                    public void mouseEntered(MouseEvent me) {}
                });
        }

        // Frage
        fragenAnzeige = new Label();
        fragenAnzeige.setSize(breite, antwortButtonHoehe/2);
        fragenAnzeige.setAlignment(Label.CENTER);
        fragenAnzeige.setLocation(0, hoehe/4);
        fragenAnzeige.setFont(new Font("Frage", Font.BOLD, antwortButtonHoehe/4));
        fragenAnzeige.setVisible(true);
        fragenAnzeige.setEnabled(true);
        quizfenster.add(fragenAnzeige);
    }

    /**
     * Vorlage zum Erstellen eines Antwort-Buttons
     * @param xPosition x-Position des Buttons
     * @param xPosition y-Position des Buttons
     * @param text Text-Anzeige des Buttons
     * @return neuen Button
     */

    Button NeueAntwort(int xPosition, int yPosition)
    {
        Button b = new Button();
        b.setSize(antwortButtonBreite, antwortButtonHoehe);
        b.setLocation(xPosition, yPosition);
        b.setFont(new Font("Antworten", Font.PLAIN, antwortButtonHoehe/5));
        b.setVisible(true);
        b.setEnabled(true);
        return b;
    }

    /**
     * Vergleich der angeklickten Antwort mit der richtigen und entsprechende Gruen-
     * bzw. Rotfaerbung des Buttons
     */

    void AntwortAngeklickt()
    {
        for (Button j : antworten)
        {
            j.removeMouseListener(j.getMouseListeners()[0]);
        }
        if (gedrueckterButton.getLabel().equals(frage.antworten[frage.richtigeAntwort]))
        {
            gedrueckterButton.setBackground(Color.GREEN);
        }
        else
        {
            gedrueckterButton.setBackground(Color.RED);
        }
    }

    /**
     * Zeigt Frage und Antwortauswahlmöglichkeiten an
     * @param f Frage, die angezeigt werden soll
     */

    void FrageAnzeigen(FRAGE f)
    {
        frage = f;
        fragenAnzeige.setText(frage.frage);
        for (int i = 0; i < antworten.length; i++)
        {
            antworten[i].setLabel(f.antworten[i]);
        }
    }
}