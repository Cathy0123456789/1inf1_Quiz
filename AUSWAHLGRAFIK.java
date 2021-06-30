import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class AUSWAHLGRAFIK
{
    Frame frame;
    Button start;
    Label kat;

    // ArrayList mit allen Kategorien
    ArrayList<KATEGORIE> kategorie;

    // Checkboxen zum Auswaehlen der zu spielenden Kategorien
    Checkbox[] checks;

    AUSWAHLGRAFIK (Frame frame, int breite, int hoehe, ArrayList<KATEGORIE> kategorie)
    {
        this.frame = frame;
        this.kategorie = kategorie;

        // Button zum Starten des Spiels
        start = new Button();
        start.setSize(breite/10, hoehe/15);
        start.setLocation((int) (0.45 * breite), (int) (0.7 * hoehe));
        start.setLabel("Spiel starten");
        start.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        start.setVisible(true);
        start.setEnabled(true);

        frame.add(start);

        // für jede Kategorie eine Checkbox
        checks = new Checkbox[kategorie.size()];

        int nummer = 0;

        for (int i = 0; i < checks.length; i++)
        {
            checks[i] = new Checkbox();
        }

        for (Checkbox c : checks)
        {            
            c.setSize(breite/5, hoehe/25);
            c.setLocation((int) (0.45 * breite), (int) (0.65 * hoehe - c.getHeight() * checks.length + 40 * nummer));
            c.setLabel(kategorie.get(nummer).name);
            c.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
            c.setVisible(true);
            c.setEnabled(true);

            frame.add(c);
            nummer++;
        }

        // "Kategorien:"
        kat = new Label();
        kat.setSize(breite, hoehe/20);
        kat.setAlignment(Label.CENTER);
        kat.setLocation(0, checks[0].getY() - checks[0].getHeight() * 2);
        kat.setFont(new Font("Kategorien", Font.BOLD, breite/50));
        kat.setText("Kategorien:");
        kat.setVisible(true);
        kat.setEnabled(true);

        frame.add(kat);
    }
    
    /**
     * Liest aus, welche Checkboxen vom Spieler ausgewaehlt wurden
     * @return ausgewaehlte Kategorien
     */

    ArrayList<KATEGORIE> CheckboxenAuslesen()
    {
        ArrayList<KATEGORIE> ausgewaehlteKat = new ArrayList<KATEGORIE>();
        for (Checkbox c : checks)
        {
            if (c.getState())
            {
                for (KATEGORIE suche : kategorie)
                {
                    if (suche.name.equals(c.getLabel()))
                    {
                        ausgewaehlteKat.add(suche);
                    }
                }
            }
        }
        return ausgewaehlteKat;
    }
}