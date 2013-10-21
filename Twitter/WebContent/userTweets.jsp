
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
	import="model.Tweet"
	import="model.User"	
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>Twweetoeuf</title>
<link rel="stylesheet" href="css/reset.css"> 
<link rel="stylesheet" href="css/screenDesign.css"> 
<link href='http://fonts.googleapis.com/css?family=Bangers' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Cantora+One' rel='stylesheet' type='text/css'>
<link rel="stylesheet" media="screen and (max-width: 1400px)" href="css/screenDesign1200.css" type="text/css" />
</head>
<body>
	<section>
		<div id="user">
			<img src="img/cl-users-avatar.png" alt="" />	
				<%
					User user = (User)session.getAttribute("visited");
					out.print("<h2>"
							+ user
							+"</h2>");		
				%>	
				<!-- Si Logged and user not in followers: move code to controller -->
			   <c:if test="${! empty addFollowerOption}">
				   <a href="addFollower"><img class="optionFollow" src="img/cl-followme.jpg" alt="" /> </a>
				</c:if>

		</div>		
	<aside>
		<img src="img/cl-users.jpg" alt="" />
	<%
		TreeSet<User> ltUsers = (TreeSet<User>)request.getAttribute("users");
		out.print("<ul>");
		for(User t: ltUsers){
		out.print("<a href='tweetsfromuser?who="+t+"'><li>"
				+t.getFirstName() +" "+t.getLastName()
				+"</li></a>"
				);
			}
		out.print("</ul>");		
	%>	
	</aside>
	<%
		List<Tweet> ltweets = (List<Tweet>)request.getAttribute("tw");
		for(Tweet t: ltweets){
		out.print("<div>"
				+t.getText()
				+"<p>"+t.getUser()+" - "+t.getDatePublish()+"</p>"
				+"</div>"
				);
			}
	%>
	</section>
</body>
</html>