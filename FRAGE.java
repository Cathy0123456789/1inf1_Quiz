class FRAGE
{
    String frage;
    String[] antworten;
    int richtigeAntwort;
    int schweregrad;

    FRAGE(String frage, String antwort1, String antwort2, String antwort3, String antwort4, int AntwortRichtig, int schweregrad)
    {
       frage = this.frage;
       antworten = new String [4];
       antworten [0] = antwort1;
       antworten [1] = antwort2;
       antworten [2] = antwort3;
       antworten [3] = antwort4;
       richtigeAntwort = this.richtigeAntwort;
       schweregrad = this.schweregrad;

    }

    boolean IstAntwortRichtig(int antwort)
    {
        if (antwort == richtigeAntwort)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    void FrageStellen()
    {
      System.out.println(frage);
      System.out.println(antworten [0]);
      System.out.println(antworten [1]);
      System.out.println(antworten [2]);
      System.out.println(antworten [3]);
    }
}