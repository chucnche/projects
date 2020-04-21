/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Chucnc
 */
public class NewClass {
    public static void main(String[] args) {
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateBook = simpleDateFormat.format(Calendar.getInstance().getTime());
    Calendar cal = Calendar.getInstance();
    System.out.println("Thời gian hiện tại là " + dateBook);
         
    // cộng thời gian
    // sử dụng phương thức add()
    cal.add(Calendar.MONTH, 4); // thêm 4 tháng
    String dateBoo = simpleDateFormat.format(cal.getTime());
    System.out.println("Thời gian hiện tại sau khi thay đổi là " + getDistance("2020-01-01"));

}
          public static long getDistance(String startDate) {
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
