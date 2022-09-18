package qal.lab18.view;

import qal.lab18.controller.CDCollection;
import qal.lab18.controller.ICDCollection;

/**
 *
 * @author qal
 */
public class CDHouseProgram {

    public static void main(String[] args) {
        ICDCollection cdCollection = new CDCollection();
        IGUI gui = new GUI((CDCollection) cdCollection);
        gui.processCommand();
    }
}
