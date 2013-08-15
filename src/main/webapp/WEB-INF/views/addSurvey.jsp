<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label>Survey Name: </label><input type="text" /><br/>
<label>Start Date:</label><input type="text"/><br/>
<label>End Date:</label><input type="text"/><br/>
<label>Questions:</label><input type="button" value="Add"/>
   <input type="button" value="Add question from xml"/>
   <br/>
<label>Send to these email:</label><input type="text"/><br/>
<input type="button" value="Add survey from xml" onclick="location.href='/surveyapp/surveyMngr/xml'"/> 
</body>
</html>