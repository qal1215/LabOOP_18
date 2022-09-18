package qal.lab18.controller;

import java.util.ArrayList;
import qal.lab18.dto.CD;

/**
 *
 * @author qal
 */
public interface ICDCollection {

    public boolean add();

    public void search();

    public void showCollection(ArrayList<CD> cds);

    public void updateCD();

    public void saveToFile();

    public void printToFile();
}
