<%@ page language="java" contentType="text/html"   pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception</title>
	<link rel="stylesheet" href="./css/reset.css"> 
	<link rel="stylesheet" href="./css/screenDesign.css"> 
	<link href='http://fonts.googleapis.com/css?family=Bangers' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Cantora+One' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" media="screen and (max-width: 1400px)" href="./css/screenDesign1200.css" type="text/css" />
</head>
<body id="err404">
	<section>
		<h1 id="titreError">Exception</h1>
		<h2>${pageContext.exception.message} ${BadParam} </h2>.
		
		<img src="img/error.jpg" alt="" /> 
	</section>		
	<section id="gohome">
		<a href="Tweets"><img src="img/letsgo.jpg" alt="" /><h1>Home page</h1></a>
	</section>
</body>
</html>