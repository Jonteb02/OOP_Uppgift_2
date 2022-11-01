package Uppgift_02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;

public class FileOutput {

    public static void writeClientToFile(Client client, Path outFile) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(outFile.toString(), true))){
            writer.println(client.getName() + ", " + client.getSsn() + ", besökte gymmet " + LocalDate.now());
        }
        catch (IOException e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }
}