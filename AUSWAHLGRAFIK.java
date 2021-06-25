import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class AUSWAHLGRAFIK
{
    Frame hauptfenster;
    Button start;
    
    Checkbox Geschichte;
    Checkbox test;
    // Checkbox geographie;
    // // Checkbox geographie;
    // // Checkbox geographie;
    // // Checkbox geographie;
    
   



    AUSWAHLGRAFIK (Frame hauptf, int breite, int hoehe, ArrayList<KATEGORIE> kategorie)
    {

        hauptfenster = hauptf;

        // Button zum Starten des Spiels
        start = new Button();
        start.setSize(breite/10, hoehe/15);
        start.setLocation((int) (0.45 * breite), (int) (0.45 * hoehe));
        start.setLabel("Spiel starten");
        start.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        start.setVisible(true);
        start.setEnabled(true);

        hauptfenster.add(start);
       
        
        for (int i=0; i<kategorie.size(); i++)
        {
          
            test = new Checkbox();   
            test.setSize(breite/5, hoehe/10);
            test.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + 20 * i));
            test.setLabel(kategorie.get(i).name);
            test.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
            test.setVisible(true);
            test.setEnabled(true);
            
            hauptfenster.add(test);
                  
        }
         

        
        
        // Geschichte = new Checkbox();
        // Geschichte.setSize(breite/5, hoehe/10);
        // Geschichte.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe));
        // Geschichte.setLabel("Geschichte");
        // Geschichte.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // Geschichte.setVisible(true);
        // Geschichte.setEnabled(true);

        // hauptfenster.add(Geschichte);
        // geographie = new Checkbox();
        // geographie.setSize(breite/5, hoehe/10);
        // geographie.setLocation((int) (0.6 * breite), (int) (0.7 * hoehe));
        // geographie.setLabel("Geographie");
        // geographie.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // geographie.setVisible(true);
        // geographie.setEnabled(true);
        //kategorien.setCheckboxGroup(cbg);
        // hauptfenster.add(geographie);
        
       

    }
}