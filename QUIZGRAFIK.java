import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    Frame frame;

    // Breite des Bildschirms
    int breite;
    // Hoehe des Bildschirms
    int hoehe;
    
    // Breite des Antwort-Buttons
    int antwortButtonBreite;
    // Hoehe des Antwort-Buttons
    int antwortButtonHoehe;

    // Array mit den zu stellenden Fragen
    ArrayList<FRAGE> fragen;
    // Position der gestellten Frage
    int nummer;
    
    PUNKTE punkte;

    QUIZGRAFIK (Frame frame, int breite, int hoehe, ArrayList<FRAGE> fragen)
    {
        this.frame = frame;
        this.breite = breite;
        this.hoehe = hoehe;
        this.fragen = fragen;
        
        nummer = 0;
        
        punkte = new PUNKTE(frame, breite, hoehe);

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
            frame.add(i);

            // Schauen, ob Antwort-Button angeklickt wird
            MouseListenerHinzufuegen(i);
        }

        // Frage
        fragenAnzeige = new Label();
        fragenAnzeige.setSize(breite, antwortButtonHoehe/2);
        fragenAnzeige.setAlignment(Label.CENTER);
        fragenAnzeige.setLocation(0, hoehe/4);
        fragenAnzeige.setFont(new Font("Frage", Font.BOLD, antwortButtonHoehe/4));
        fragenAnzeige.setVisible(true);
        fragenAnzeige.setEnabled(true);
        frame.add(fragenAnzeige);

        FrageAnzeigen(fragen.get(nummer));
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
        b.setBackground(Color.LIGHT_GRAY);
        return b;
    }
    
    /**
     * Fuegt MouseListener fuer Button hinzu, welcher bei Anklicken des Buttons 
     * weiteres ausloest
     * @param b Button, auf den der MouseListener angewendet werden soll
     */

    void MouseListenerHinzufuegen(Button b)
    {
        b.addMouseListener(new MouseListener()
            {
                public void mousePressed(MouseEvent me) {}

                public void mouseReleased(MouseEvent me) {}

                public void mouseClicked(MouseEvent me)
                {
                    gedrueckterButton = b;
                    AntwortAngeklickt();
                }

                public void mouseExited(MouseEvent me) {}

                public void mouseEntered(MouseEvent me) {}
            });

    }

    /**
     * Vergleich der angeklickten Antwort mit der richtigen und entsprechende Gruen-
     * bzw. Rotfaerbung des Buttons, dann Weiterschaltung zur naechsten Frage
     */

    void AntwortAngeklickt()
    {
        // Verhinderung des Anklickens eines weiteren Buttons
        for (Button j : antworten)
        {
            j.removeMouseListener(j.getMouseListeners()[0]);
        }
        
        // angeklickte Antwort blinkt zweimal gelb
        for (int i = 0; i < 2; i++)
        {
            gedrueckterButton.setBackground(Color.YELLOW);
            warten(500);
            gedrueckterButton.setBackground(Color.LIGHT_GRAY);
            warten(500);
        }

        if (gedrueckterButton.getLabel().equals(frage.antworten[frage.richtigeAntwort-1]))
        {
            // falls Antwort richtig, Gruenfaerbung
            gedrueckterButton.setBackground(Color.GREEN);
            // Punkteanzahl erhoehen
            punkte.punkteHinzufuegen(frage.schweregrad * 10);
        }
        else
        {
            // falls Antwort falsch, Rotfaerbung & Gruenfaerbung der richtigen Antwort
            gedrueckterButton.setBackground(Color.RED);
            warten(1000);
            for (Button j : antworten)
            {
                if(j.getLabel().equals(frage.antworten[frage.richtigeAntwort-1]))
                {
                    j.setBackground(Color.GREEN);
                }
            }
        }

        warten(2000);

        // zur naechsten Frage wechseln, falls es noch eine gibt, ansonsten Ende anzeigen
        if (nummer < (fragen.size() - 1))
        {
            NaechsteFrage();
        }
        else
        {
            frame.removeAll();
            ENDGRAFIK ende = new ENDGRAFIK(frame, breite, hoehe, punkte.punkte);
        }
    }

    /**
     * Wartet eingegebene Zeit und macht nichts
     * @param zeit Zeit, die gewartet werden soll
     */
    
    void warten(int zeit)
    {
        try{
            Thread.sleep(zeit);
        } catch (InterruptedException e) {}
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
    
    /**
     * Zeigt naechste Frage an
     */

    void NaechsteFrage()
    {
        nummer++;
        FrageAnzeigen(fragen.get(nummer));
        for (Button i : antworten)
        {
            i.setBackground(Color.LIGHT_GRAY);
            MouseListenerHinzufuegen(i);
        }
    }
}