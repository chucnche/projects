/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;

/**
 *
 * @author sonnt
 */
public class HtmlHelper {
    public static String hyperlink(String label, String href,Date from,Date to,String kid)
    {   
        if((kid == null||kid == "" || kid.isEmpty())&& from!=null&&to!=null)
        return "<li class=\"page-item\"><a class=\"page_hyperlink page-link\"  href=\""+href+"&from="+from+"&to="+to+"\">" + label + "</a></li>";
        else if(from == null || to == null) return "<li class=\"page-item\"><a class=\"page_hyperlink page-link\" href=\""+href+"\">" + label + "</a></li>";
        else return "<li class=\"page-item\"><a class=\"page_hyperlink page-link\" href=\""+href+"&from="+from+"&to="+to+"&kid="+kid+"\">" + label + "</a></li>";
    }
    public static String hyperlinkbook(String label, String href,Date from,Date to,String kid,String fid)
    {   
        if((kid == null||kid == "" || kid.isEmpty())&& from!=null&&to!=null)
        return "<li class=\"page-item\"><a class=\"page_hyperlink page-link\"  href=\""+href+"&from="+from+"&to="+to+"&fid="+fid+"\">" + label + "</a></li>";
        else if(from == null || to == null) return "<li class=\"page-item\"><a class=\"page_hyperlink page-link\"  href=\""+href+"\">" + label + "</a></li>";
        else return "<li class=\"page-item\"><a class=\"page_hyperlink page-link\"  href=\""+href+"&from="+from+"&to="+to+"&kid="+kid+"&fid="+fid+"\">" + label + "</a></li>";
    }
    
    public static String pageravailable(int pageindex,int pagecount, int gap,Date from,Date to,String kid)
    {
        String result = "";
        if(pageindex > gap+1)
            result += hyperlink("First","available?page="+1,from,to,kid);
        
        for (int i = gap; i > 0; i--) {
            if(pageindex - gap >= 0 && pageindex - i!=0)
                result += hyperlink(""+(pageindex - i),"available?page="+(pageindex - i),from,to,kid);
        }
        
        result += "<li class=\"page-item\"><a class=\"page_hyperlink page-link\">"+pageindex+"</a></li>";
        
        for (int i = 1; i <= gap; i++) {
            if(pageindex + gap <= pagecount+1 && pageindex + i!=pagecount+1)
                result += hyperlink(""+(pageindex + i),"available?page="+(pageindex + i),from,to,kid);
        }
        if(pageindex + gap < pagecount)
            result += hyperlink("Last","available?page="+pagecount,from,to,kid);
        return result;
    }
    public static String pagerbook(int pageindex,int pagecount, int gap,Date from,Date to,String kid,String fid)
    {
        String result = "";
        if(pageindex > gap+1)
            result += hyperlinkbook("First","book?page="+1,from,to,kid,fid);
        
        for (int i = gap; i > 0; i--) {
            if(pageindex - gap >= 0 && pageindex - i!=0)
                result += hyperlinkbook(""+(pageindex - i),"book?page="+(pageindex - i),from,to,kid,fid);
        }
        
        result += "<li class=\"page-item\"><a class=\"page_hyperlink page-link\">"+pageindex+"</a></li>";
        
        for (int i = 1; i <= gap; i++) {
            if(pageindex + gap <= pagecount+1 && pageindex + i!=pagecount+1)
                result += hyperlinkbook(""+(pageindex + i),"book?page="+(pageindex + i),from,to,kid,fid);
        }
        
        if(pageindex + gap < pagecount)
            result += hyperlinkbook("Last","book?page="+pagecount,from,to,kid,fid);
        return result;
    }
}
