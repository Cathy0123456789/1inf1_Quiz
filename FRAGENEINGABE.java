import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

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
            System.out.println("In welcher Kategorie?");
            for (int i = 1; i <= KategorienEinlesen().size(); i++)
            {
                System.out.println(i + " : " + KategorienEinlesen().get(i-1));
            }
            System.out.println("Bitte Nummer der Kategorie eingeben.");
            String kategorie = KategorienEinlesen().get(Integer.parseInt(scanner.nextLine())-1);
            DateiErstellen(kategorie, frage, antworten, richtigeAntwort, schweregrad);
        }

        System.out.println("\nNeue Frage hinzufügen? Ja / Nein");
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

    private static void DateiErstellen(String kategorie, String frage, String[] antworten, int richtigeAntwort, int schweregrad)
    {
        File kat = new File("Fragen\\" + kategorie);
        File f = new File(kat + "\\frage" + (kat.list().length + 1) + ".txt");

        try
        {
            f.createNewFile();

            PrintWriter writer = new PrintWriter(new FileWriter(f));

            writer.println(frage);
            for (String i : antworten)
            {
                writer.println(i);
            }
            writer.println(richtigeAntwort);
            writer.print(schweregrad);
            
            writer.close();
            
            System.out.println("Die Frage wurde erfolgreich abgespeichert.");
        }
        catch (IOException e)
        {
            System.out.println("Fehler aufgetreten.");
            e.printStackTrace();
        }
    }

    /**
     * Liest Ordner-Namen (= Kategorien) aus dem Ordner "Fragen" ein
     */

    private static ArrayList<String> KategorienEinlesen()
    {
        File[] directories = new File("Fragen").listFiles(File::isDirectory);

        ArrayList<String> kategorien = new ArrayList<String>();

        for (File i : directories)
        {
            String kat = i.toString();
            kategorien.add(kat.substring(7, kat.length()));
        }

        return kategorien;
    }
}