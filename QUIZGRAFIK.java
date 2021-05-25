import java.awt.*;
import java.awt.event.*;

class QUIZGRAFIK
{
    Button[] antworten;
    int gedrueckterButton;
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

        antworten = new Button[4];

        // 4 Antwort-Buttons
        antworten[0] = neueAntwort(abstandSeite, (int) (0.6 * hoehe));
        antworten[1] = neueAntwort(breite - abstandSeite - antwortButtonBreite , antworten[0].getY());
        antworten[2] = neueAntwort(abstandSeite, antworten[0].getY() + antwortButtonHoehe + hoehe/20);
        antworten[3] = neueAntwort(antworten[1].getX(), antworten[2].getY());

        for (Button i : antworten)
        {
            quizfenster.add(i);
            i.addMouseListener(new MouseListener()
                {
                    public void mousePressed(MouseEvent me) {}

                    public void mouseReleased(MouseEvent me) {}

                    public void mouseClicked(MouseEvent me)
                    {
                        i.setBackground(Color.GREEN);
                        for (Button j : antworten)
                        {
                            j.removeMouseListener(j.getMouseListeners()[0]);
                        }
                    }

                    public void mouseExited(MouseEvent me) {}

                    public void mouseEntered(MouseEvent me) {}
                });
        }

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
        frage.setSize(breite, antwortButtonHoehe/2);
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

    Button neueAntwort(int xPosition, int yPosition)
    {
        Button b = new Button();
        b.setSize(antwortButtonBreite, antwortButtonHoehe);
        b.setLocation(xPosition, yPosition);
        b.setFont(new Font("Antworten", Font.PLAIN, antwortButtonHoehe/5));
        b.setVisible(true);
        b.setEnabled(true);
        return b;
    }

    void FrageAnzeigen(FRAGE f)
    {
        frage.setText(f.frage);
        for (int i = 0; i < antworten.length; i++)
        {
            antworten[i].setLabel(f.antworten[i]);
        }
    }
}