import java.awt.*;
import java.awt.event.*;

class GRAFIKOBERFLAECHE
{
    Frame mainFrame;
    Button Antwort1;
    Button Antwort2;
    Button Antwort3;
    Button Antwort4;
    Label x;
   
    GRAFIKOBERFLAECHE ()
    {
        mainFrame = new Frame();
        mainFrame.setSize(1000,500);
        mainFrame.setLocation(10,50);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        
        Antwort1 = new Button();
        Antwort1.setSize(120,50);
        Antwort1.setLocation(50,300);
        Antwort1.setVisible(true);
        Antwort1.setLabel("Antwort 1");
        Antwort1.setEnabled(true);
        
        Antwort2 = new Button();
        Antwort2.setSize(120,50);
        Antwort2.setLocation(250,300);
        Antwort2.setVisible(true);
        Antwort2.setLabel("Antwort 2");
        Antwort2.setEnabled(true);
        
        Antwort3 = new Button();
        Antwort3.setSize(120,50);
        Antwort3.setLocation(450,300);
        Antwort3.setVisible(true);
        Antwort3.setLabel("Antwort 3");
        Antwort3.setEnabled(true);
        
        Antwort4 = new Button();
        Antwort4.setSize(120,50);
        Antwort4.setLocation(650,300);
        Antwort4.setVisible(true);
        Antwort4.setLabel("Antwort 4");
        Antwort4.setEnabled(true);
        
        mainFrame.add(Antwort1);
        mainFrame.add(Antwort2);
        mainFrame.add(Antwort3);
        mainFrame.add(Antwort4);
    
        x = new Label();
        x.setSize(200,50);
        x.setLocation(325,150);
        x.setVisible(true);
        x.setText("Frage:");
        x.setEnabled(true);
        
        mainFrame.add(x);
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}








