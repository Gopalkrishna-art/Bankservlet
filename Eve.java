import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Eve extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String opt=rq.getParameter("opt");
if(opt.equals("d"))
rs.sendRedirect("dep.html");
else if(opt.equals("w"))
rs.sendRedirect("with.html");
else if(opt.equals("a"))
rs.sendRedirect("actac.html");
else
rs.sendRedirect("Balc.java");
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}
