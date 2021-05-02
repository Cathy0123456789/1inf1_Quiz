class FRAGE
{
    String frage;
    String[] antworten;
    int richtigeAntwort;
    int schweregrad;

    FRAGE()
    {

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
}