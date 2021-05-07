class QUIZ
{
    // Speicherung aller Kategorien in einem Array -> WARUM?! (Liste waere besser?)
    KATEGORIE kategorie;
    
    // Fragenanzahl pro Quiz
    int fragenanzahl;
    
    QUIZ(int fragenanzahl)
    {
      fragenanzahl=this.fragenanzahl;
      kategorie= new KATEGORIE ("Allgemein");
    }
    
    void neueKategorie(String name)
    {
      KATEGORIE k = new KATEGORIE (name); 
      kategorie.NachfolgerSetzen(k);
    }
    
  
    void KategorienAusgeben()
    {
        kategorie.KategorienAusgeben();
    }
    }
