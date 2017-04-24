<!doctype html>
<html>
<head>
<title>Error Page</title>
</head>
<body>
		<h1>Error!</h1>
		<p>Unspecified Error</p>
		<p>To continue, click the Back button.</p>
		
		<h2>Error Details</h2>
		<p>Type: ${pageContext.exception["class"]}</p>
		<p>Message: ${pageContext.exception.message}</p> 
</body>
</html>