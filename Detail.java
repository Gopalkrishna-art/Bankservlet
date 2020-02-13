import java.sql.*;
import p2.Acc;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Detail extends HttpServlet{
public void service(HttpServletRequest rq,HttpServletResponse rs)throws IOException,ServletException{
try{
String name=rq.getParameter("name");
String pwd=rq.getParameter("pwd");
int bal=0;
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String un="kamal",pw="123";
Connection c=DriverManager.getConnection(url,un,pw);
String k="select name from bank where name='"+name+"'";
ResultSet r=c.createStatement().executeQuery(k);
PrintWriter v=rs.getWriter();
if(r.next()){
v.print("<html><body>");
v.print("Account name already exist");
v.print("<br><a href='detail.html'>Create with new Account name</a>");
v.print("</body></html>");
}
else
{
Acc ss=new Acc();
String accnum=ss.show();
String q="insert into bank values(?,?,?,?)";
PreparedStatement ps=c.prepareStatement(q);
ps.setString(1,accnum);
ps.setString(2,name);
ps.setString(3,pwd);
ps.setInt(4,bal);
ps.execute();
v.print("<html><body>");
v.print("Bank account created successfully");
v.print("<br><a href='lo.html'>login to ur account</a><br>");
v.print("</body></html>");
}
}
catch(Exception e){
System.out.print(e.getMessage());
}
}
}
