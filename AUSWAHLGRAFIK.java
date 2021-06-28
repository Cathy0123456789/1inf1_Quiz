import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class AUSWAHLGRAFIK
{
    Frame hauptfenster;
    Button start;
    
    Checkbox Geschichte;
    Checkbox test;
    Checkbox test1;
    Checkbox test2;
    Checkbox test3;
    Checkbox test4;
    Checkbox test5;
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
       
        // int j = kategorie.size();
        
        // test = new Checkbox();   
        // test.setSize(breite/5, hoehe/10);
        // test.setLocation((int) (0.5 * breite), (int) (0.6 * hoehe + 20 * j));
        // test.setLabel(kategorie.get(j).name);
        // test.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // test.setVisible(true);
        // test.setEnabled(true);
            
        // hauptfenster.add(test);
        
        // j = j -1;
        
        // test1 = new Checkbox();   
        // test1.setSize(breite/5, hoehe/10);
        // test1.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + 20 * j));
        // test1.setLabel(kategorie.get(j).name);
        // test1.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // test1.setVisible(true);
        // test1.setEnabled(true);
            
        // hauptfenster.add(test1);
        
        // j = j -1;
        
        // test2 = new Checkbox();   
        // test2.setSize(breite/5, hoehe/10);
        // test2.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + 20 * j));
        // test2.setLabel(kategorie.get(j).name);
        // test2.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // test2.setVisible(true);
        // test2.setEnabled(true);
            
        // hauptfenster.add(test2);
        
        // j = j -1;
        
        // test3 = new Checkbox();   
        // test3.setSize(breite/5, hoehe/10);
        // test3.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + 20 * j));
        // test3.setLabel(kategorie.get(j).name);
        // test3.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // test3.setVisible(true);
        // test3.setEnabled(true);
            
        // hauptfenster.add(test3);
        
        // j = j -1;
        
        // test4 = new Checkbox();   
        // test4.setSize(breite/5, hoehe/10);
        // test4.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + 20 * j));
        // test4.setLabel(kategorie.get(j).name);
        // test4.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // test4.setVisible(true);
        // test4.setEnabled(true);
            
        // hauptfenster.add(test4);
        
        // j = j -1;
        
        // test5 = new Checkbox();   
        // test5.setSize(breite/5, hoehe/10);
        // test5.setLocation((int) (0.6 * breite), (int) (0.6 * hoehe + 20 * j));
        // test5.setLabel(kategorie.get(j).name);
        // test5.setFont(new Font("Antworten", Font.PLAIN, start.getSize().height/5));
        // test5.setVisible(true);
        // test5.setEnabled(true);
            
        // hauptfenster.add(test5);
        
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