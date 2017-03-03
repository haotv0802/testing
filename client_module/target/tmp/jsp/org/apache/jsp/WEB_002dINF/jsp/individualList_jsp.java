package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class individualList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("var contextPath = \"");
      out.print(request.getContextPath());
      out.write("\";\r\n");
      out.write("var app = angular.module(\"myApp\", []);\r\n");
      out.write("app.controller(\"indivCtrl\", function($scope) {\r\n");
      out.write("\t$scope.indivList = getIndivList();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function getIndivList() {\r\n");
      out.write("\tvar success;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type: \"GET\",\r\n");
      out.write("        url: contextPath + \"/indiv/getIndivList\",\r\n");
      out.write("        async: false,\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("           //alert(data);\r\n");
      out.write("       \t   success = data;\r\n");
      out.write("        }\r\n");
      out.write("\t});\r\n");
      out.write("\treturn success;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<div ng-app=\"myApp\" ng-controller=\"indivCtrl\">\r\n");
      out.write("\t\t\t<table style=\"width: 1024px;\" class=\"table table-striped table-hover\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" size=10px/>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr ng-repeat=\"indiv in indivList track by $index\">\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"\" style=\"text-decoration: underline;\">{{indiv.imxRef}}</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>{{indiv.caseRef}}</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>{{indiv.subRef}}</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>{{indiv.caseCategory}}</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>{{indiv.currency}}</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>{{indiv.client}}</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 130px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>{{indiv.debtor}}</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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
