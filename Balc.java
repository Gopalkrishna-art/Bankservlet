import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Balc extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
HttpSession s=rq.getSession();
String acno=s.getAttribute("acno").toString();
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="kamal",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
String k="select bal from bank where acno='"+acno+"'";
ResultSet rk=c.createStatement().executeQuery(k);
PrintWriter v=rs.getWriter();
while(rk.next())
v.print("<html><body>");
v.print("rk.getInt(1)");
v.print("<br><a href='eve.html'>back</a>");
v.print("</body></html>");
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}

