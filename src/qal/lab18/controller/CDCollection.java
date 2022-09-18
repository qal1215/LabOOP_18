package qal.lab18.controller;

import qal.lab18.dto.CD;
import java.util.ArrayList;
import qal.lab18.file.FileControl;
import utils.Tools;

/**
 *
 * @author qal
 */
public class CDCollection extends ArrayList<CD> implements ICDCollection {

    private final FileControl file;

    public CDCollection() {
        this.file = new FileControl(this);
        ArrayList<CD> readFromFile = file.readFromFile();
        this.addAll(readFromFile);
    }

    public boolean add() {
        System.out.println("=====Add CD=====");
        CD cd = new CD();
        String IDtmp = Tools.getString("Enter CD's ID: ", false);

        if (isDuplicate(IDtmp)) {
            System.out.println("The ID is already!");
            return false;
        } else {
            cd.setID(IDtmp);
            cd.setTitle(Tools.getString("Enter Title: ", false));
            cd.setCdName(Tools.getCDName(false));
            cd.setCdType(Tools.getCDType(false));
            cd.setPublishYear(Tools.getYear());
            cd.setPrice(Tools.getInt("Enter the Unit Price", 0, 999999));
        }
        this.add(cd);
        return true;
    }

    private boolean isDuplicate(String id) {
        for (CD cd : this) {
            if (cd.getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void searchByTitle(String title) {
        boolean isExist = false;

        for (CD cd : this) {
            if (cd.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(cd);
                isExist = true;
            }
        }
        if (isExist == false) {
            System.out.println("Not found!");
        }
    }

    public void search() {
        System.out.println("=====Search CD=====");
        String titleToSearch = Tools.getString("Enter CD title to search: ", true);
        searchByTitle(titleToSearch);
    }

    public void showCollection(ArrayList<CD> cds) {
        System.out.println("=====List CDs=====");
        if (cds.isEmpty()) {
            System.out.println("Don't have any CD in catalog.");
        } else {
            System.out.printf("Have %d CD in list\n", cds.size());
            System.out.printf("%5s|%20s|%12s|%7s|%5s|%7s\n",
                    "ID", "Title", "Collection", "Type", "Year", "Price");
            System.out.println("--------------------------------------------------------------");
            for (CD cd : cds) {
                System.out.println(cd);
            }
        }
    }

    private void updateCDInfo() {
        System.out.println("=====Update CD Information=====");
        String idToUpdate = Tools.getString("Enter ID to update: ", false);
        CD cdToUpdate = searchById(idToUpdate);
        if (cdToUpdate == null) {
            System.out.println("ID don't exist!");
        } else {
            System.out.println(cdToUpdate);
            String temp = "";
            //Update CD Collection name
            temp = Tools.getCDName(true);
            if (!temp.isEmpty()) {
                cdToUpdate.setCdName(temp);
            }
            //CD type
            temp = Tools.getCDType(true);
            if (!temp.isEmpty()) {
                cdToUpdate.setCdType(temp);
            }
            //CD title
            temp = Tools.getString("Enter CD's Title: ", true);
            if (!temp.isEmpty()) {
                cdToUpdate.setTitle(temp);
            }
            temp = Tools.getString("Enter CD's Publish year: ", true);
            if (!temp.isEmpty()) {
                cdToUpdate.setPublishYear(Integer.parseInt(temp));
            }
            temp = Tools.getString("Enter CD's Price: ", true);
            if (!temp.isEmpty()) {
                cdToUpdate.setPrice(Integer.parseInt(temp));
            }
        }
        System.out.println("Update Successfully!");
    }

    private void deleteCD() {
        System.out.println("=====Delete CD=====");
        String tmp = Tools.getString("Enter you ID to delete: ", false);
        CD cdToDelete = searchById(tmp);
        if (cdToDelete == null) {
            System.out.println("CD isn't exist!");
        } else {
            String confirm = Tools.getString("Do you want to delete? <Y/n>", false);

            if (confirm.equalsIgnoreCase("y")) {
                this.remove(cdToDelete);
                System.out.println("Delete successfully.");
            } else {
                System.out.println("Delete don't successfully.");
            }
        }
    }

    public void updateCD() {
        System.out.println("===========================");
        System.out.println("1. Update CD");
        System.out.println("2. Delete CD");
        int choice = Tools.getInt("Enter your choice: ", 1, 2);
        switch (choice) {
            case 1:
                updateCDInfo();
                break;
            case 2:
                deleteCD();
                break;
        }
    }

    private CD searchById(String id) {
        for (CD cd : this) {
            if (cd.getID().equalsIgnoreCase(id)) {
                return cd;
            }
        }
        return null;
    }

    public void saveToFile() {
        if (file.saveToFile()) {
            System.out.println("Save successfully.");
        } else {
            System.out.println("Save fail!");
        }
    }

    public void printToFile() {
        ArrayList<CD> cds = file.readFromFile();
        showCollection(cds);
    }
}
