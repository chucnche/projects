/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.KindOfRoom;

/**
 *
 * @author dell
 */
public class KindorDAO extends DBContext {

    public ArrayList<KindOfRoom> getKindors() {
        ArrayList<KindOfRoom> kindors = new ArrayList<>();
        String sql = "SELECT * FROM [KindOfRoom]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String kid = rs.getString("kid");
                String kind = rs.getString("kind");

                KindOfRoom kor = new KindOfRoom(kid, kind);
                kindors.add(kor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kindors;
    }
    public KindOfRoom getKindByKid(String kid) {
        String sql = "SELECT * FROM [KindOfRoom] WHERE [kid] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, kid);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String kid1 = rs.getString("kid");
                String kind = rs.getString("kind");
                KindOfRoom kindor = new KindOfRoom(kid1, kind);
                return kindor;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
