import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class AUSWAHLGRAFIK
{
    Frame hauptfenster;
    Button start;
    // Checkbox Geschichte;
    // Checkbox geographie;
    // // Checkbox geographie;
    // // Checkbox geographie;
    // // Checkbox geographie;
    

    AUSWAHLGRAFIK (Frame hauptf, int breite, int hoehe, ArrayList<KATEGORIE> kategorie)
    {
         hauptfenster = hauptf;
         
         kategorie.get(0);
         
         for (int i=0; i<=kategorie.size(); i++)
         {
             // String S;
             // S = kategorie.get(i).name;
             Checkbox test = new Checkbox();   
             test.setSize(breite/5, hoehe/10);
             test.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + i));
             test.setLabel(kategorie.get(i).name);
             test.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
             test.setVisible(true);
             test.setEnabled(true);
         }
         

        // hauptfenster.add(start);
        
        //Checkbox kategorien
        //CheckboxGroup cbg = new CheckboxGroup();
        //add(new Checkbox( “RED”, false, cbg ) );
        //add(new Checkbox( "Shoes" ) );
        // Geschichte = new Checkbox();
        // Geschichte.setSize(breite/5, hoehe/10);
        // Geschichte.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe));
        // Geschichte.setLabel("Geschichte");
        // Geschichte.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // Geschichte.setVisible(true);
        // Geschichte.setEnabled(true);
         
        // // hauptfenster.add(Geschichte);
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