package qal.lab18.file;

import java.util.ArrayList;
import qal.lab18.dto.CD;

/**
 *
 * @author qal
 */
public interface IFileControl {

    public ArrayList<CD> readFromFile();

    public boolean saveToFile();
}
