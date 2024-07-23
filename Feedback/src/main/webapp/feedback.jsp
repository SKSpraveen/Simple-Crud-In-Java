<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>

<%

  	String name =request.getParameter("name");

	String driverName ="com.mysql.jdbc.Driver";
	String connectionUrl="jdbc:mysql://localhost:3306/";
	String dbName="feedback";
	String userId="root";
	String password="sasindu";


	try{
		Class.forName(driverName);
		
	}catch (ClassNotFoundException e){
		e.printStackTrace();
	}
	Connection connection=null;
	Statement statement=null;
	ResultSet resultset=null;
%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="feedback.css">
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
</head>
<body>
    <div class="navbar">
          
    <ul>
        <li><a href="homepage.jsp">Home</a></li>
        <li><a href="aboutus.jsp">About Us</a></li>
        <li><a href="contactus.jsp">Contact Us</a></li>
	    <li><a href="vacancies.jsp">Vacancy</a></li>
       
    </ul>
    </div><br><br><br>
    
	<script>alert('Do you really want to give feedback?')</script>
    
	<div class="f">
	    <form action="addf"  method="post">
		<center><h1>Feedback</h1></center>
		<input type="text" placeholder="Name" name="name"><br><br><br>
		<input type="text"  placeholder="E-mail" name="email" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" required><br><br><br>
		<textarea rows=8 cols=37 name="comment" placeholder="Your comment" required></textarea><br><br><br>
		<center>
		
		<input type="submit" style="background:white;font-size:15px;font-weight:bold;height:4%;width:20%" value="Submit" name="submit">
		</center>
	</div>
	<center>
	<br><br><br>
	<h1 style="text-shadow: 1px 1px 3px black, 0 0 25px white, 0 0 5px red;">Customer reviews</h1><br>
	</center>
	
	
	<div style="width:90%;border-radius:10px;background:#00000088;padding:40px;margin: 20px auto 0;color:white">
         <%
			 try{
				 connection=DriverManager.getConnection(connectionUrl+dbName, userId, password);
				 statement=connection.createStatement();
				 String sql="Select * from feedback";
		
				 resultset=statement.executeQuery(sql);
				 
				 while(resultset.next()){
		  %>
		  
		  
		  <image style="margin-left:4%" src="images/pro.png" width="3%" height="3%">&nbsp;&nbsp;
		  <font size="4px"><b><%=resultset.getString("User_Name") %></b></font>
		  <i><h4 style="margin-left:4%">&emsp;&emsp;&emsp;&emsp;<%=resultset.getString("Comment") %></h4></i>
				
			
	      <%
				 }
					 connection.close();
				 }catch(Exception e){
					 e.printStackTrace();
				 }
	      %>
	
    </div>
	<br><br><br><br>
	

	
	<footer>
	<ul class="footerIcons">
		<li><a href="https://www.facebook.com/"><ion-icon name="logo-facebook"></ion-icon></li></a>
		<li><a href="https://www.instagram.com/"><ion-icon name="logo-instagram"></ion-icon></li></a>
		<li><a href="https://twitter.com/"><ion-icon name="logo-twitter"></ion-icon></li></a>
    </ul>	

	<ul class="footerMenu">
		<li class="footerNav"><a href="contactus.jsp">Contact us</a></li>
		<li class="footerNav"><a href="terms & conditions">Terms & conditions</a></li>
		<li class="footerNav"><a href="feedback.jsp">Feedback</a></li>
	</ul>
	</footer>
</body>
</html>