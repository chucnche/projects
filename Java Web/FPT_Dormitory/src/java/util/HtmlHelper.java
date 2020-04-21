/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Chucnc
 */
public class HtmlHelper {

    public static String hyperlink(String label, String href) {
        return "<a class=\"page_hyperlink\" href=\"" + href + "\">" + label + "</a>";
    }

    public static String pager(int pageindex, int pagecount, int gap) {
        String result = "";

        for (int i = 0; i < pagecount; i++) {
            if (i + 1 == pageindex) {
                result += "<span class=\"page_pageindex\">" + pageindex + "</span>";
            } else {
                result += hyperlink("" + (i + 1), "ADstudent?page=" + (i + 1));
            }
        }
        return result;
    }

    public static String pagerBills(int pageindex, int pagecount, int gap) {
        String result = "";

        for (int i = 0; i < pagecount; i++) {
            if (i + 1 == pageindex) {
                result += "<span class=\"page_pageindex\">" + pageindex + "</span>";
            } else {
                result += hyperlink("" + (i + 1), "ADElectricityWater?page=" + (i + 1));
            }
        }
        return result;
    }

    public static String pagerHisBooks(int pageindex, int pagecount, int gap) {
        String result = "";

        for (int i = 0; i < pagecount; i++) {
            if (i + 1 == pageindex) {
                result += "<span class=\"page_pageindex\">" + pageindex + "</span>";
            } else {
                result += hyperlink("" + (i + 1), "ADHistoryBook?page=" + (i + 1));
            }
        }
        return result;
    }

    public static String pagerHisPays(int pageindex, int pagecount, int gap) {
        String result = "";

        for (int i = 0; i < pagecount; i++) {
            if (i + 1 == pageindex) {
                result += "<span class=\"page_pageindex\">" + pageindex + "</span>";
            } else {
                result += hyperlink("" + (i + 1), "ADHistoryPay?page=" + (i + 1));
            }
        }
        return result;
    }
        public static String pagerRooms(int pageindex, int pagecount, int gap) {
        String result = "";

        for (int i = 0; i < pagecount; i++) {
            if (i + 1 == pageindex) {
                result += "<span class=\"page_pageindex\">" + pageindex + "</span>";
            } else {
                result += hyperlink("" + (i + 1), "ADRoom?page=" + (i + 1));
            }
        }
        return result;
    }
                public static String pagerRequest(int pageindex, int pagecount, int gap) {
        String result = "";

        for (int i = 0; i < pagecount; i++) {
            if (i + 1 == pageindex) {
                result += "<span class=\"page_pageindex\">" + pageindex + "</span>";
            } else {
                result += hyperlink("" + (i + 1), "ADRequest?page=" + (i + 1));
            }
        }
        return result;
    }
}
