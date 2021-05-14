class PROGRAMM
{
    int punkte;
    int[] highscore;
    static QUIZ quiz;
    static HAUPTMENUEGRAFIK grafik1;
    static QUIZGRAFIK grafik2;


    public static void main(String args[])
    {
        // neues Quiz mit 5 Fragen
        quiz = new QUIZ(5);

        // Kategorien aus dem Ordner "Fragen" einlesen
        quiz.KategorienEinlesen();

        // in jeder Kategorie alle Fragen im jeweiligen Ordner einlesen
        for (KATEGORIE kat : quiz.kategorien)
        {
            kat.FragenEinlesen();
        }

        
        KATEGORIE k = quiz.kategorien.get(0);
        FRAGE f = k.Zufallsfrage();
        
        grafik1 = new HAUPTMENUEGRAFIK();
        grafik2 = new QUIZGRAFIK();
    }
}