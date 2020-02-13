import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Lo extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String acno=rq.getParameter("acno");
HttpSession s=rq.getSession();
s.setAttribute("acno",acno);
String ps=rq.getParameter("pwd");
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String dbun="kamal",dbps="123";
Connection c=DriverManager.getConnection(url,dbun,dbps);
String q="select pwd from bank where acno='"+acno+"'";
ResultSet r=c.createStatement().executeQuery(q);
PrintWriter v=rs.getWriter();
String ps1=null;
if(r.next()){
ps1=r.getString(1);
if(ps.equals(ps1)){
v.print("<html><body>");
v.print("U have logedin successully");
v.print("<br><a href='eve.html'>Account details</a>");
v.print("</body></html>");
}
else {
v.print("<html><body>");
v.print("wrong password login failed");
v.print("<br><a href='lo.html'>Login account</a>");
v.print("</body></html>");
}
}
else{
v.print("account number doesn't not exist");
}
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}








