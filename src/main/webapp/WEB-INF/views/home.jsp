<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="surveyapp/xml/add" 
      method="post" 
      modelAttribute="questions"
      enctype="multipart/form-data"> <!-- for input type file -->
   <div>Select a xml file to import a list of survey question</div><br/>
   <input type="file" name="fileXml" size="50"><br/>
   <input type="submit" value="Upload file"><br/>
</form>
</body>
</html>
