import java.awt.*;
import java.awt.event.*;

class QUIZGRAFIK
{
    Frame quizfenster;
    Button antwort1;
    Button antwort2;
    Button antwort3;
    Button antwort4;
    Label fragenAnzeige;
   
    QUIZGRAFIK ()
    {
        quizfenster = new Frame();
        quizfenster.setSize(1000,500);
        quizfenster.setLocation(10,50);
        quizfenster.setVisible(true);
        quizfenster.setLayout(null);
        
        antwort1 = new Button();
        antwort1.setSize(120,50);
        antwort1.setLocation(50,300);
        antwort1.setVisible(true);
        antwort1.setLabel("Antwort 1");
        antwort1.setEnabled(true);
        
        antwort2 = new Button();
        antwort2.setSize(120,50);
        antwort2.setLocation(250,300);
        antwort2.setVisible(true);
        antwort2.setLabel("Antwort 2");
        antwort2.setEnabled(true);
        
        antwort3 = new Button();
        antwort3.setSize(120,50);
        antwort3.setLocation(450,300);
        antwort3.setVisible(true);
        antwort3.setLabel("Antwort 3");
        antwort3.setEnabled(true);
        
        antwort4 = new Button();
        antwort4.setSize(120,50);
        antwort4.setLocation(650,300);
        antwort4.setVisible(true);
        antwort4.setLabel("Antwort 4");
        antwort4.setEnabled(true);
        
        quizfenster.add(antwort1);
        quizfenster.add(antwort2);
        quizfenster.add(antwort3);
        quizfenster.add(antwort4);
    
        fragenAnzeige = new Label();
        fragenAnzeige.setSize(200,50);
        fragenAnzeige.setLocation(325,150);
        fragenAnzeige.setVisible(true);
        fragenAnzeige.setText("Frage:");
        fragenAnzeige.setEnabled(true);
        
        quizfenster.add(fragenAnzeige);
    
    }
}








