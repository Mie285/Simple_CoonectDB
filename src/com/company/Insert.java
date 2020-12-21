package com.company;


import javax.naming.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    private Connection connect() {  //connect database ทุกครั้งที่สร้าง class ใหม่
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/chinook.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void insert(Integer ArtistId, String Name) {
        String sql = "INSERT INTO artists(ArtistId,Name) VALUES(?,?)";
        //Insert ข้อมูลเข้าไปใน Column ที่มีอยู่แล้วใน Table

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ArtistId);
            pstmt.setString(2, Name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {

        Insert app = new Insert();  //ข้อมูลที่เราจะ Insert เข้าไป
        app.insert(2222, "Marvin");
        app.insert(880, "MMM");
    }

}