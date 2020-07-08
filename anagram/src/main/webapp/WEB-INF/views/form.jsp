<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Anagram Finder</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="width: 500px;padding-top: 100px">
		<form method="post">
			Welcome to Anagram Finder app. Please enter a word 
			<div style="padding-top: 5px">	
				<input type="text" name="word" class="form-control" required="required" minlength="2" maxlength="8"/>
			</div>
			<div style="padding-top: 10px">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>		
		</form>
	</div>
</body>
</html>