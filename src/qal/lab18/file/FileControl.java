package qal.lab18.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import qal.lab18.dto.CD;
import qal.lab18.controller.CDCollection;

/**
 *
 * @author qal
 */
public class FileControl implements IFileControl {

    CDCollection cds;

    public FileControl(CDCollection cds) {
        this.cds = cds;
    }

    private static final String FILE_PATH = "C:\\Users\\qal\\Desktop\\data\\CD.dat";

    @Override
    public ArrayList<CD> readFromFile() {
        ArrayList<CD> returnCDs = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream;
            FileInputStream file = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(file);
            boolean isContinue = true;
            while (isContinue) {
                CD cd = (CD) objectInputStream.readObject();
                if (cd != null) {
                    isContinue = returnCDs.add(cd);
                } else {
                    isContinue = false;
                }
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return returnCDs;
    }

    @Override
    public boolean saveToFile() {
        try {
            FileOutputStream file = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);

            for (Iterator<CD> it = cds.iterator(); it.hasNext();) {
                CD cd = it.next();
                objectOutputStream.writeObject(cd);
            }
            objectOutputStream.close();
            file.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
