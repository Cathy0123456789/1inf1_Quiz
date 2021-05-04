class FRAGE
{
    String frage;

    // Speicherung der 4 Antworten in einem Array
    String[] antworten;

    // Platz der richtigen Antwort im Array
    int richtigeAntwort;

    int schweregrad;

    FRAGE(String frage, String antwort1, String antwort2, String antwort3, String antwort4, int AntwortRichtig, int schweregrad)
    {
        this.frage = frage;
        antworten = new String [4];
        antworten [0] = antwort1;
        antworten [1] = antwort2;
        antworten [2] = antwort3;
        antworten [3] = antwort4;
        this.richtigeAntwort = richtigeAntwort;
        this.schweregrad = schweregrad;
    }

    /*
     * Ueberpruefung, ob eingegebene Antwort der richtigen Loesung entspricht
     */

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

    /*
     * Ausgabe der Frage sowie der 4 Antwortmoeglichkeiten auf der Konsole
     */

    void FrageStellen()
    {
        System.out.println(frage);
        for (String i : antworten)
        {
            System.out.println(i);
        }
    }
}