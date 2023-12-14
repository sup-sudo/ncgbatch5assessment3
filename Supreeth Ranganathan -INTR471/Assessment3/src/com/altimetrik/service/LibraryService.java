package com.altimetrik.service;

import com.altimetrik.dao.LibraryDao;
import com.altimetrik.exceptions.NoAvailableBooksException;
import com.altimetrik.model.Library;

import java.util.List;

public class LibraryService {
    public void addBook(Library library) {
        LibraryDao libraryDao = new LibraryDao();
        libraryDao.addBook(library);
    }

    public void update(Library library) {
        LibraryDao libraryDao = new LibraryDao();
        libraryDao.update(library);
    }

    public List<Library> showAvailable() throws NoAvailableBooksException {
        LibraryDao libraryDao = new LibraryDao();
        List<Library> list = libraryDao.showAvailable();
        if(list.isEmpty()){
            throw new NoAvailableBooksException("No available Books in the database");
        }
        return list;
    }

    public void removeBook(int bookID) {
        LibraryDao libraryDao = new LibraryDao();
        libraryDao.removeBook(bookID);
    }
}
