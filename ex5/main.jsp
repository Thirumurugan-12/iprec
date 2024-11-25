<%@page language="java" import="java.sql.*"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%
String SeatNum,Name;
String ans1, ans2,ans3,ans4,ans5;
int a1,a2,a3,a4,a5;
a1=a2=a3=a4=a5=0;
Connection connect=null;
Statement stmt=null;
ResultSet rs=null;
Class.forName("oracle.jdbc.driver.OracleDriver");
connect = DriverManager.getConnection("jdbc:oracle:thin:@172.16.34.183:1521:csedb","exam130","exam130");

SeatNum = request.getParameter("Seat_no");
Name = request.getParameter("Name");
ans1 =request.getParameter("group1");
if(ans1.equals("True"))
    a1=2;
else
    a1=0;
ans2 = request.getParameter("group2");
if(ans2.equals("True"))
    a2=0;  // Corrected answer grading logic based on provided HTML
else
    a2=2;
ans3 = request.getParameter("group3");
if(ans3.equals("True"))
    a3=0; // Corrected answer grading logic
else
    a3=2;
ans4 = request.getParameter("group4");
if(ans4.equals("True"))
    a4=2;
else
    a4=0;
ans5 = request.getParameter("group5");
if(ans5.equals("True"))
    a5=0; // Corrected answer grading logic
else
    a5=2;
int Total=a1+a2+a3+a4+a5;
stmt = connect.createStatement();
String query = "INSERT INTO Studentable (Seat_no,Name,Marks) VALUES ('" + SeatNum + "','" + Name + "'," + Total + ")"; // Fixed SQL syntax
stmt.executeUpdate(query); // Use executeUpdate for INSERT statements
out.println("inserted");
stmt.close();
connect.close();
%>