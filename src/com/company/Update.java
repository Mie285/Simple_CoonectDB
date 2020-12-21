package com.company;

import javax.naming.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
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
    public void update(int PlaylistId, String Name) {
        //ใส่ column จะ update ข้อมูลเข้าไป
        String sql = "UPDATE playlists SET Name = ?  WHERE PlaylistId = ? ";  //playlistId เป็น PK
        //ให้ PK เป็นตัวกำหนดว่าจะ update ข้อมูลตรงไหน

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, Name);
            pstmt.setInt(2, PlaylistId);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {

        Update app = new Update();
        app.update(1, "Dddddddddd"); //ส่วนที่ update ข้อมูล
    }
}
