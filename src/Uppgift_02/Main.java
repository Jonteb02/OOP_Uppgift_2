package Uppgift_02;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
        Path inputFile = Paths.get("src/Uppgift_02/customers.txt");
        Path outputFile = Paths.get("src/Uppgift_02/ClientTracker.txt");

    public Main() {

        while(true) {
            String clientInfo = JOptionPane.showInputDialog("Skriv in namn eller personnummer på kunden");
            if(clientInfo == null)
                System.exit(0);

            List<Client> allClients = FileInput.readDataFromFileAddToList(inputFile);

            Client client = Iterator.iterateListToFindClient(clientInfo, allClients);
            boolean clientFound = false;
            if(client == null)
                JOptionPane.showMessageDialog(null, "Kunden finns inte i systemet!");
            else
                clientFound = true;

            if(clientFound) {
                boolean paidAYearAgo = DateComparator.lessThanOneYearAgo(client.getPaymentDate());

                if (paidAYearAgo) {
                    FileOutput.writeClientToFile(client, outputFile);
                    JOptionPane.showMessageDialog(null, client.getName() +
                            " har lagts till i filen för Pt-tränaren");
                }
                else
                    JOptionPane.showMessageDialog(null, client.getName() +
                            " har inte betalat årsavgiften än");
            }
        }
    }

        public static void main(String[] args) {
            new Main();
    }
}
