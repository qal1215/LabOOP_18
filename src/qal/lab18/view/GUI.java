package qal.lab18.view;

import qal.lab18.controller.CDCollection;
import utils.Tools;

/**
 *
 * @author qal
 */
public class GUI implements IGUI{

    CDCollection cdCollection;

    public GUI(CDCollection collection) {
        this.cdCollection = collection;
    }

    private void showMenu() {
        System.out.println("====================================================================");
        System.out.println("Welcome to CD House Program - @2022 by <SE162024 - Le Quyet Anh>");
        System.out.println("1. Add CD to the catalog");
        System.out.println("2. Search CD by CD title");
        System.out.println("3. Display the catalog");
        System.out.println("4. Update CD");
        System.out.println("5. Save account to file");
        System.out.println("6. Print list CDs from file");
        System.out.println("Others - Quit");
    }

    @Override
    public void processCommand() {
        int command;
        do {
            showMenu();
            String choice = Tools.getString("Enter your choice: ", true);
            if (choice.isEmpty() || choice.matches("1-6")) {
                break;
            } else {
                command = Integer.parseInt(choice);
            }
            
            switch (command) {
                case 1:
                    if (cdCollection.add()) {
                        System.out.println("Add successfully.");
                    } else {
                        System.out.println("Oop... Somthing wrong :(");
                    }
                    break;
                case 2:
                    cdCollection.search();
                    break;
                case 3:
                    cdCollection.showCollection(cdCollection);
                    break;
                case 4:
                    cdCollection.updateCD();
                    System.out.println("Do you want go to main menu?");
                    String confirm = Tools.getString("Enter to continue or N to exit: ", true);
                    if (confirm.equalsIgnoreCase("n")) {
                        return;
                    }
                    break;
                case 5:
                    cdCollection.saveToFile();
                    break;
                case 6:
                    cdCollection.printToFile();
                    break;
                default:
                    System.out.println("Good bye!");
                    break;
            }

        } while (true);
    }

}
