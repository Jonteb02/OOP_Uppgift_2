package Uppgift_02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {

    public static List<Client> readDataFromFileAddToList(Path inFile) {
        List<Client> allPeople = new ArrayList<>();
        String firstLine;
        String secondLine;
        String[] personDataPartsFirstLine;

        try(Scanner sc = new Scanner(inFile)){
            while (sc.hasNextLine()){
                firstLine = sc.nextLine();
                personDataPartsFirstLine = firstLine.split(",");
                secondLine = sc.nextLine();
                allPeople.add(new Client(
                        personDataPartsFirstLine[1].trim(),
                        personDataPartsFirstLine[0].trim(),
                        secondLine));
            }
        }
        catch (IOException e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
        return allPeople;
    }
}
