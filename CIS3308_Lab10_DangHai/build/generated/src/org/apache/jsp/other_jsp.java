package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import view.*;
import dbUtils.DbConn;
import model.Spaceships.StringData;
import model.Spaceships.DbSpMods;

public final class other_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "toHead.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "headToContent.jsp", out, false);
      out.write("\n");
      out.write("<h1 style=\"text-align: center\">Spaceships List</h1>\n");
      out.write("<h2 style=\"text-align: center\"><a href=\"insertOther.jsp\">Add a Spaceship</a></h2>\n");
      out.write("\n");
      out.write("        ");

            StringData inputData = new StringData(); // all properties empty string, good for first rendering
            StringData errorMsgs = new StringData(); // all properties empty string, good for first rendering

            String deleteId = request.getParameter("deleteId");
            if(request.getParameter("deleteId") != null && request.getParameter("deleteId") != ""){
                inputData.spaceshipId = deleteId;
            }
            
            
            DbConn dbc = new DbConn();
            String msg = dbc.getErr(); // returns "" if connection is good, else error msg.
            
            if (msg.length() == 0) { // got open connection
                        errorMsgs.errorMsg = dbc.getErr();

                        if (errorMsgs.errorMsg.length() == 0) {
                            // DB connection is good
                            errorMsgs = DbSpMods.delete(inputData, dbc); // errorMsgs will hold all validation messags
                            if (errorMsgs.errorMsg.length() == 0) { // this is the form level error message
                                // replace empty string with successful message
                                errorMsgs.errorMsg = "Record successfully deleted !";
                            }
                        } // if db connection is good
                // returns a string that contains a HTML table with the db data in it
                // pass in the name of the CSS style that you want applied to the HTML 
                // table ("dependency injection") and pass in an open DbConn object.
                msg = spaceshipView.listWithDelete("resultSet", dbc);
            }
            // PREVENT DB CONNECTION LEAKS (every code path that opens a db connection 
            // also must close it).
            dbc.close();              
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
 out.print(msg);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "postContent.jsp", out, false);
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
