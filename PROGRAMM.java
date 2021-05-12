class PROGRAMM
{
    int punkte;
    int[] highscore;
    static QUIZ quiz;
    static GRAFIKOBERFLAECHE grafik;

    public static void main(String args[])
    {
        // neues Quiz mit 5 Fragen
        quiz = new QUIZ(5);
        
        // Kategorien aus dem Ordner "Fragen" einlesen
        quiz.KategorienEinlesen();

        // in jeder Kategorie alle Fragen im jeweiligen Ordner einleen
        for (KATEGORIE kat : quiz.kategorien)
        {
            kat.FragenEinlesen();
        }
    }
}