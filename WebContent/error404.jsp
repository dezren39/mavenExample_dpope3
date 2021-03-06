<!doctype html>
<html>
<head>
<title>Java Web Programming: Error</title>
<meta name="description" content="This is a servlet example that demonstrates
	a 404 response page when a page is not found.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>404 Sorry :[</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">	
		<h3>File Not Found</h3>
		<p>These things happen.. <b>:(</b></p> 
		<p>To continue, click the Back button.</p>
	</div>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>