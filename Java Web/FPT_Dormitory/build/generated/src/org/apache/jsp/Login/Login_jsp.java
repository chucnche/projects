package org.apache.jsp.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>KTXTHPTLHP</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("    ");

            String s= (String)request.getAttribute("check");
    
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body background=\"img/ktxb.jpg\">\n");
      out.write("      <section>\n");
      out.write("          <div class=\"container\">\n");
      out.write("              <div  class=\"row\">\n");
      out.write("                  <h1  style=\"color: #999999;font-size: 60px;margin-left: 30px;margin-top: 150px\">Kí Túc Xá Trường THPT Lê Hồng Phong</h1>\n");
      out.write("                  <button  style=\"background-color:#999999; border:none;border-radius: 4px; margin-left: 480px;margin-top: 50px;width: 250px;height: 80px;\" type=\"button\" class =\"btn btn-primary\" data-toggle=\"modal\" data-target=\".bs-example-modal-lg\">\n");
      out.write("                      <span style=\"color:wheat;font-size:40px;\">Login</span>\n");
      out.write("                  </button>\n");
      out.write("                  <div class=\"modal fade bs-example-modal-lg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myLargeModalLabel\">\n");
      out.write("                      <div class=\"modal-dialog modal-lg\" role=\"document\">\n");
      out.write("                          <div class=\"modal-content\">\n");
      out.write("                              <div class=\"modal-body\">\n");
      out.write("                                  <div class=\"row\">\n");
      out.write("                                      <div class=\"col-lg-5 col-md-5 block-image\">\n");
      out.write("                                          <img src=\"img/login.png\" class=\"img-responsive\"/>\n");
      out.write("                                      </div>\n");
      out.write("                                      <div style=\"margin-top: 50px\" class=\"col-lg-6 col-md-6 block-contact\">\n");
      out.write("                                          <h1 style=\"color: #999999;font-size: 50px;\">Login</h1>\n");
      out.write("                                          <form action=\"Login\" method=\"POST\">\n");
      out.write("                                              <div class=\"form-group\">\n");
      out.write("                                                  <input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"Username\" value=\"\" />\n");
      out.write("                                              </div>\n");
      out.write("                                              <div class=\"form-group\">\n");
      out.write("                                                  <input type=\"text\" name=\"password\" class=\"form-control\" placeholder=\"Password\" value=\"\" />\n");
      out.write("                                              </div>\n");
      out.write("                                              <div class=\"form-group\">\n");
      out.write("                                                 <span style=\"color: #999999;font-size:15px;\">Manager</span> <input  type=\"radio\" name=\"adstu\" value=\"0\" checked=\"checked\" />\n");
      out.write("                                                 <span style=\"margin-left: 20px;color: #999999;font-size:15px;\">Student</span> <input  type=\"radio\" name=\"adstu\" value=\"1\" />\n");
      out.write("                                              </div>\n");
      out.write("                                              <div class=\"form-group\">\n");
      out.write("                                                  <input type=\"checkbox\" name=\"remember\" value=\"remember\"/>\n");
      out.write("                                                  <span style=\"color: #999999;font-size:15px;\">Remember me!</span> \n");
      out.write("                                              </div>\n");
      out.write("                                              <button type=\"submit\" class=\"btn btn-success pull-left\">Login</button>\n");
      out.write("                                              ");
 if(s!=null){
      out.write("\n");
      out.write("                                                  <span style=\"color: #999999;font-size:15px;\">*incorrect user or password or type*</span> \n");
      out.write("                                              ");
}
      out.write("\n");
      out.write("                                          </form>\n");
      out.write("                                      </div>\n");
      out.write("                                  </div>\n");
      out.write("                              </div>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                  </div>\n");
      out.write("              </div>\n");
      out.write("          </div>\n");
      out.write("      </section>\n");
      out.write("    <script src=\"js/jquery-3.4.1.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
