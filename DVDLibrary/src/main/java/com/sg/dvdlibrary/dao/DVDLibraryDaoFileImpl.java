/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Joy Gilbuena
 * @email princesajoy23@gmail.com
 * 
 * 
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao  { //implements the interface

        private Map<String, DVDLibrary> dvds = new HashMap<>(); 

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    /**
     *
     * @param title
     * @param dvd
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public DVDLibrary addDVD(String title, DVDLibrary dvd)
            throws DVDLibraryDaoException {
        DVDLibrary newDVD = dvds.put(title, dvd);
        try {
            writeDVD();
        } catch (DVDLibraryDaoException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return newDVD;
    }

    @Override
    public List<DVDLibrary> getAllDVDs()
            throws DVDLibraryDaoException {
        loadDVD();
        return new ArrayList<DVDLibrary>(dvds.values());
    }

    @Override
    public DVDLibrary removeDVD(String title) throws DVDLibraryDaoException {
        DVDLibrary removedDVD = dvds.remove(title);
        try {
            writeDVD();
        } catch (DVDLibraryDaoException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return removedDVD;
    }

    @Override
    public DVDLibrary getDVD(String title) {
        return dvds.get(title);
    }

    /**
     *
     * @param title
     * @param dvd
     * @return
     */
    @Override
    public DVDLibrary editDVD(String title, DVDLibrary dvd) {
        dvds.put(title, dvd);
        return dvd;
    }

    private void loadDVD() throws DVDLibraryDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load library data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            DVDLibrary currentDVD = new DVDLibrary(currentTokens[0]);

            currentDVD.setGenre(currentTokens[1]);
            currentDVD.setYear(currentTokens[2]);
            currentDVD.setStudio(currentTokens[3]);
            currentDVD.setDirectorsName(currentTokens[4]);
            currentDVD.setUserRating(currentTokens[5]);
            currentDVD.setMpaaRating(currentTokens[6]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }

    private void writeDVD() throws DVDLibraryDaoException, IOException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        List<DVDLibrary> dvdList = this.getAllDVDs();
        for (DVDLibrary currentDVD : dvdList) {

            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getGenre() + DELIMITER
                    + currentDVD.getYear() + DELIMITER 
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getDirectorsName() + DELIMITER
                    + currentDVD.getUserRating() + DELIMITER
                    + currentDVD.getMpaaRating());

            out.flush();
        }

        out.close();
    }

    //@Override
    //public DVDLibrary addDVD(String title, DVDLibrary dvd) throws DVDLibraryDaoException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    //public DVDLibrary editDVD(String title, DVDLibrary dvd) throws DVDLibraryDaoException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
//}
