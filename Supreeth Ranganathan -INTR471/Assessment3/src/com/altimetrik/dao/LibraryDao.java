package com.altimetrik.dao;

import com.altimetrik.exceptions.NoAvailableBooksException;
import com.altimetrik.model.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDao {
    private String url = "jdbc:mysql://127.0.0.1:3306/assessment3";
    private String user = "root";
    private String pass = "suP@070501";
    public void addBook(Library library) {
        try {
            Connection con = DriverManager.getConnection(url,user, pass);
            Statement st = con.createStatement();
            PreparedStatement ps;
            String query="insert into `librarybooks`(bookID,bookName,genre,bookCost,availability) values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1,library.getBookID());
            ps.setString(2,library.getBookName());
            ps.setString(3,library.getGenre());
            ps.setInt(4,library.getBookCost());
            ps.setString(5,library.getAvailable());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Library library) {
        try{
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            PreparedStatement ps;
            String query = "update `librarybooks` set bookName = ?, genre = ?, bookCost =?, availability=? where bookID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,library.getBookName());
            ps.setString(2,library.getGenre());
            ps.setInt(3,library.getBookCost());
            ps.setString(4,library.getAvailable());
            ps.setInt(5,library.getBookID());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Library> showAvailable(){
        List<Library> libraryList = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select * from librarybooks where availability= ?");
            ps.setString(1,"Available");

            rs = ps.executeQuery();
            Library library1 = new Library();

            while(rs.next()){
                library1.setBookID(rs.getInt(1));
                library1.setBookName(rs.getString(2));
                library1.setGenre(rs.getString(3));
                library1.setBookCost(rs.getInt(4));
                library1.setAvailable(rs.getString(5));
                libraryList.add(library1);
            }
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return libraryList;
    }

    public void removeBook(int bookID) {
        try{
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps = con.prepareStatement("delete from librarybooks where bookID=?");
            ps.setInt(1,bookID);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
