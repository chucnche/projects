/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chucnc
 */
public class DBContext {
          protected Connection connection;
    public DBContext() {
        try {
            String user = "chucnc";
            String pass = "12345";
            String url = "jdbc:sqlserver://DESKTOP-C82BSUN:1433;databaseName=KTX_THPT";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public long getDistance(String startDate) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long getDaysDiff = 0;
        //Date currentDate = new Date();
        //PLus 24h
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.HOUR, 24);

        java.util.Date date1 = null;
        java.util.Date date2 = null;

        try {
            // calculating the difference b/w startDate and endDate
            String endDate = simpleDateFormat.format(Calendar.getInstance().getTime());

            date1 = simpleDateFormat.parse(startDate);
            date2 = simpleDateFormat.parse(endDate);

            long getDiff = date2.getTime() - date1.getTime();

            // using TimeUnit class from java.util.concurrent package
            getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDaysDiff;
    }
}
