import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Actac extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String us=rq.getParameter("acno");
int bal=Integer.parseInt(rq.getParameter("bal"));
HttpSession s=rq.getSession();
String acno=s.getAttribute("acno").toString();
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="kamal",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
String k="select acno,bal from bank where acno="+acno;
ResultSet rk=c.createStatement().executeQuery(k);
PrintWriter v=rs.getWriter();
String r="";
if(rk.next()){
if(rk.getInt(2)>bal){
r="update bank set bal=? where acno=?";
PreparedStatement p=c.prepareStatement(r);
p.setString(2,acno);
p.setInt(1,rk.getInt(2)-bal);
p.execute();
String i="select acno,bal from bank where acno="+us;
ResultSet rr=c.createStatement().executeQuery(i);
String l="";
if(rr.next()){
l="update bank set bal=? where acno=?";
PreparedStatement pk=c.prepareStatement(l);
pk.setString(2,us);
pk.setInt(1,rr.getInt(2)+bal);
pk.execute();
v.print("<html><body>");
v.print("Amount transwered");
v.print("<br><a href='eve.html'>back</a>");
v.print("</body></html>");
}
}
else
v.print("insufficient amount");
}
else{
v.print("amount not avaliable");
}
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}

