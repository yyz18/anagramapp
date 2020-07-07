<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Anagram Finder</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<br><br>
					
		<table class="table table-striped">
				
			<thead>
				<tr>
					<th>The anagrams of ${word} </th>
				</tr>
			</thead>
				
			<tbody>
				<c:forEach items="${result}" var="item">
					<tr>
						<td>${item}</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>
</body>
</html>