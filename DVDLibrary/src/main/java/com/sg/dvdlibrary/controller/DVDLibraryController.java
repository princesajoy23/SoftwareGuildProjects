/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVDLibrary;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Joy Gilbuena
 * @email princesajoy23@gmail.com
 * 
 * 
 */
public class DVDLibraryController { // orchestrator

    //composition
    //members
    DVDLibraryView view; //what the user see //has a member of type userIO
    DVDLibraryDao dao; // Data Access Object. it provides access to an underlying database

    

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao; //referencing to this dao
        this.view = view; // referencing to this view
    }

    private int getMenuSelection() { //set it to private so no other classes can accidentally modify the method
        return view.printMenuAndGetSelection();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0; // initialize the value to zero
        try {
            while (keepGoing) { //will run no matter what
                
                try {
                   menuSelection = getMenuSelection(); 
                } catch (NumberFormatException e) {
                    view.displayErrorMessage(e.getMessage());
                    continue;
                }
                

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:    // if they choose this, it will exit the loop
                        keepGoing = false;
                        break;
                    default:  // input validation
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVDLibrary> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVDLibrary newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVDLibrary dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVDLibrary previousDVD = dao.getDVD(title);
        DVDLibrary editedDVD = view.editDVD(previousDVD);
        dao.editDVD(editedDVD.getTitle(), editedDVD);
        view.displayEditSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}

