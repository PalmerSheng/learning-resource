/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.52
 * Generated at: 2018-05-29 03:20:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/F:/java文件/tomcat/tomcat8/apache-tomcat-8.0.52/webapps/WebChat-master/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1526397396813L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\n');
      out.write('\n');
String path = request.getContextPath();
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>WebChat | 登陆</title>\n");
      out.write("  <link href=\"");
      out.print(path);
      out.write("/static/source/css/login.css\" rel='stylesheet' type='text/css' />\n");
      out.write("  <script src=\"");
      out.print(path);
      out.write("/static/plugins/jquery/jquery-2.1.4.min.js\"></script>\n");
      out.write("  <script src=\"");
      out.print(path);
      out.write("/static/plugins/layer/layer.js\"></script>\n");
      out.write("  <style>\n");
      out.write("  #register {\n");
      out.write("    font-size: 30px;\n");
      out.write("    color: #fff;\n");
      out.write("    outline: none;\n");
      out.write("    border: none;\n");
      out.write("    background: #3ea751;\n");
      out.write("    width: 100%;\n");
      out.write("    padding: 18px 0;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("#register:hover{\n");
      out.write("background: #ff2775;\n");
      out.write("  \ttransition: 1s all;\n");
      out.write("\t-webkit-transition: 1s all;\n");
      out.write("\t-moz-transition: 1s all;\n");
      out.write("\t-o-transition: 1s all;\n");
      out.write("}\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h1>WebChat</h1>\n");
      out.write("<div class=\"login-form\">\n");
      out.write("  <div class=\"close\"> </div>\n");
      out.write("  <div class=\"head-info\">\n");
      out.write("    <label class=\"lbl-1\"></label>\n");
      out.write("    <label class=\"lbl-2\"></label>\n");
      out.write("    <label class=\"lbl-3\"></label>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"clear\"> </div>\n");
      out.write("  <div class=\"avtar\"><img src=\"");
      out.print(path);
      out.write("/static/source/img/avtar.png\" /></div>\n");
      out.write("  <form id=\"login-form\" action=\"");
      out.print(path);
      out.write("/user/login\" method=\"post\" onsubmit=\"return checkLoginForm()\">\n");
      out.write("    <div class=\"key\">\n");
      out.write("      <input type=\"text\" id=\"username\" name=\"userid\" placeholder=\"请输入账号\" >\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"key\">\n");
      out.write("      <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"请输入密码\">\n");
      out.write("    </div>\n");
      out.write("     <div class=\"signin\" style=\"height:100%;width:100%\">\n");
      out.write("     <a href=\"");
      out.print(path);
      out.write("/user/register\" id=\"submit\" ><div id=\"register\">Register</div></a>\n");
      out.write("     </div>\n");
      out.write("    <div class=\"signin\">\n");
      out.write("      <input type=\"submit\" id=\"submit\" value=\"Login\" >\n");
      out.write("    </div>\n");
      out.write("  </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("  $(function(){\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("    if(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"){\n");
      out.write("      $('#submit').attr('value',\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\").css('background','red');\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"){\n");
      out.write("      layer.msg('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("', {\n");
      out.write("        offset: 0,\n");
      out.write("      });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    $('.close').on('click', function(c){\n");
      out.write("      $('.login-form').fadeOut('slow', function(c){\n");
      out.write("        $('.login-form').remove();\n");
      out.write("      });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('#username,#password').change(function(){\n");
      out.write("      $('#submit').attr('value','Login').css('background','#3ea751');\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("\n");
      out.write("  /**\n");
      out.write("   * check the login form before user login.\n");
      out.write("   * @returns {boolean}\n");
      out.write("   */\n");
      out.write("  function checkLoginForm(){\n");
      out.write("    var username = $('#username').val();\n");
      out.write("    var password = $('#password').val();\n");
      out.write("    if(isNull(username) && isNull(password)){\n");
      out.write("      $('#submit').attr('value','请输入账号和密码!!!').css('background','red');\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    if(isNull(username)){\n");
      out.write("      $('#submit').attr('value','请输入账号!!!').css('background','red');\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    if(isNull(password)){\n");
      out.write("      $('#submit').attr('value','请输入密码!!!').css('background','red');\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    //if(username != 'Amaya' || password != '123456'){\n");
      out.write("    //\t$('#submit').attr('value','账号或密码错误!!!').css('background','red');\n");
      out.write("    //\treturn false;\n");
      out.write("    //}\n");
      out.write("    else{\n");
      out.write("      $('#submit').attr('value','Logining~');\n");
      out.write("      return true;\n");
      out.write("    }\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  /**\n");
      out.write("   * check the param if it's null or '' or undefined\n");
      out.write("   * @param input\n");
      out.write("   * @returns {boolean}\n");
      out.write("   */\n");
      out.write("  function isNull(input){\n");
      out.write("    if(input == null || input == '' || input == undefined){\n");
      out.write("      return true;\n");
      out.write("    }\n");
      out.write("    else{\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("  }\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/view/login.jsp(62,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty param.timeout}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("      layer.msg('连接超时,请重新登陆!', {\n");
          out.write("        offset: 0,\n");
          out.write("        shift: 6\n");
          out.write("      });\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
