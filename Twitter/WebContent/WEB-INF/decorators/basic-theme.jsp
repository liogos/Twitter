<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
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
	<link rel="stylesheet" href="css/reset.css"> 
	<link rel="stylesheet" href="css/screenDesign.css"> 
	<link href='http://fonts.googleapis.com/css?family=Bangers' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Cantora+One' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" media="screen and (max-width: 1400px)" href="css/screenDesign1200.css" type="text/css" />
</head>
<body>
	<header>
		<a href="Tweets"><img src="img/cl01.png" alt="" /></a>
		<h1>Tweetoeuf</h1>
		<div id="Connexion">
		
		<jsp:include page="../../${loginAddress}" />

		</div>			
	</header>
	<decorator:body />
</body>
</html>