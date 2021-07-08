import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

class FRAGENEINGABE
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Frage:");
        String frage = scanner.nextLine();

        String antworten[] = new String[4];

        for (int i = 1; i <= 4; i++)
        {
            System.out.println("Antwort " + i + ":");
            antworten[i-1] = scanner.nextLine();
        }
        
        System.out.println("Nummer der richtigen Antwort:");
        int richtigeAntwort = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Schweregrad der Frage:");
        int schweregrad = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Frage abspeichern? Ja / Nein");
        if (scanner.nextLine().equals("Ja"))
        {
            DateiSchreiben(frage, antworten, richtigeAntwort, schweregrad);
        }
        
        System.out.println("Neue Frage hinzufügen? Ja / Nein");
        String neueFrage = scanner.nextLine();
        if (neueFrage.equals("Ja"))
        {
            FRAGENEINGABE f = new FRAGENEINGABE();
            f.main(new String[1]);
        }
        else if (neueFrage.equals("Nein"))
        {
            System.exit(0);
        }
    }

    private static void DateiSchreiben(String frage, String[] antworten, int richtigeAntwort, int schweregrad)
    {
        // try
        // {
            // PrintWriter writer = new PrintWriter(new FileWriter(datei));

            // writer.println();

            // writer.close();
        // }
        // catch (IOException e)
        // {
            // System.out.println("Fehler aufgetreten.");
            // e.printStackTrace();
        // }
    }
}