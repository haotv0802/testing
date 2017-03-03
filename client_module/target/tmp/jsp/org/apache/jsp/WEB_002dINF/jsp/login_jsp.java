package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_ng$1controller_ng$1app_method_action;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_form_form_ng$1controller_ng$1app_method_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_form_form_ng$1controller_ng$1app_method_action.release();
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
      out.write("var app = angular.module(\"loginApp\", []);\r\n");
      out.write("app.controller(\"loginCtrl\", function($scope) {\r\n");
      out.write("\t//alert(contextPath);\r\n");
      out.write("\t$scope.login = function() {\r\n");
      out.write("\t\t//alert($scope.username + \", \" + $scope.password);\r\n");
      out.write("\t\tlogin($scope.username, $scope.password);\r\n");
      out.write("\t}\r\n");
      out.write("\t$scope.reset = function() {\r\n");
      out.write("    \t$scope.username = \"Ho Anh Hao\";\r\n");
      out.write("    \t$scope.password = \"\";\r\n");
      out.write("    }\r\n");
      out.write("    //$scope.reset();\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("function login(u, p) {\r\n");
      out.write("\tvar success;\r\n");
      out.write("\tvar loginInfo = {username : u, password : p };\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type: \"POST\",\r\n");
      out.write("        url: contextPath + \"/login\",\r\n");
      out.write("        dataType: \"json\",\r\n");
      out.write("        data: JSON.stringify(loginInfo),\r\n");
      out.write("        async: false,\r\n");
      out.write("        complete: function(xhr, statusText){\r\n");
      out.write("            //alert(xhr.status);\r\n");
      out.write("            //alert(statusText);\r\n");
      out.write("            //alert(xhr.getAllResponseHeaders());\r\n");
      out.write("            window.location = contextPath + \"/indiv/displayIndivList\";\r\n");
      out.write("        }\r\n");
      out.write("\t});\r\n");
      out.write("\treturn success;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<section id=\"content\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_form_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</section>\r\n");
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

  private boolean _jspx_meth_form_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_ng$1controller_ng$1app_method_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_form_0.setPageContext(_jspx_page_context);
    _jspx_th_form_form_0.setParent(null);
    _jspx_th_form_form_0.setAction("login");
    _jspx_th_form_form_0.setMethod("POST");
    _jspx_th_form_form_0.setDynamicAttribute(null, "ng-app", new String("loginApp"));
    _jspx_th_form_form_0.setDynamicAttribute(null, "ng-controller", new String("loginCtrl"));
    int[] _jspx_push_body_count_form_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_form_0 = _jspx_th_form_form_0.doStartTag();
      if (_jspx_eval_form_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<table>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td>Username:</td>\r\n");
          out.write("\t\t\t\t\t\t<td><input type='text' name=\"username\" ng-model=\"username\"/></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td>Password:</td>\r\n");
          out.write("\t\t\t\t\t\t<td><input type='password' name=\"password\" ng-model=\"password\"></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td colspan=\"2\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td colspan='2'><input name=\"submit\" type=\"button\" value=\"Login\" ng-click=\"login()\">&nbsp;<input name=\"reset\" value=\"Reset\" type=\"button\" ng-click=\"reset()\"></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t</table>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_form_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_form_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_form_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_form_0.doFinally();
      _jspx_tagPool_form_form_ng$1controller_ng$1app_method_action.reuse(_jspx_th_form_form_0);
    }
    return false;
  }
}
