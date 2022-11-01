package Uppgift_02;

import java.util.List;

public class Iterator {
    public static Client iterateListToFindClient (String userInput, List<Client> allClients) {

        for (Client p: allClients) {
            if (userInput.trim().equalsIgnoreCase(p.getName()) || userInput.trim().equalsIgnoreCase(p.getSsn()))
                return p;
        }
        return null;
    }
}
