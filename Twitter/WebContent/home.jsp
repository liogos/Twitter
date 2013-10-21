
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
	import="model.Tweet"
	import="model.User"	
	import= "java.net.URLEncoder"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset=UTF-8">
<title>Twweetoeuf</title>
</head>
<body>
	<section>
	<aside>
				<c:choose>
					<c:when  test="${empty users }">
						<img src="img/cl-nofollowers.jpg" alt="" />	
						<p id="noFollowers">Pas d'amis</P>	
					 </c:when> 
					<c:otherwise>
						<img src="img/cl-users.jpg" alt="" />
						<ul>
							<c:forEach items="${users}" var="item">
								<a href="tweetsfromuser?who=${item}">
								<li>						
									<c:out value="${item[\"firstName\"]} ${item[\"lastName\"]} "/> 
								</li>
								</a>
							</c:forEach>
						</ul>
					</c:otherwise>					 
				</c:choose>		
	</aside>
				<c:if test="${!empty tw}">
					<c:forEach items="${tw}" var="item">
						<div>
							<c:out value="${item[\"text\"]}" />
							<p>
							<c:out value="${item[\"user\"]} - ${item[\"datePublish\"]}" />
							</p>
						</div>
					</c:forEach>
				</c:if>

	</section>
</body>
</html>