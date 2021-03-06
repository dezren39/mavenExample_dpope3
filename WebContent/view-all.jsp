<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Web Programming: Class List</title>
<meta name="description" content="This is a JSP example that demonstrates how to output every Person in our Excel Spreadsheet to a web page.">
<%@ include file="includes/styles.jsp"%>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Class List</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<!-- This is where we will output the class list -->
		<c:choose>
			<c:when test="${empty people}">
				<p>Sorry, the list of people is empty.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="person" items="${people}">
					<div class="span4">
						<h2>${person.firstName}</h2>
						<p>${person.firstName} ${person.lastName} is ${person.age} years old.
						${person.firstName}'s favorite color is ${person.favoriteColor}.</p>
					</div>				
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	<%@ include file="includes/footer.jsp" %>
	
</div>

<%@ include file="includes/scripts.jsp" %>
</body>
</html>