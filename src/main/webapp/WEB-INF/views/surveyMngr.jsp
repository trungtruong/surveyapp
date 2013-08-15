<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Manager</title>
</head>
<body>
   <table>
      <c:forEach items="${surveylist}" var="survey">
         <tr>
            <td>${survey.surveyId}</td>
            <td>${survey.surveyName}</td>
            <td>${survey.startDate}</td>
            <td>${survey.endDate}</td>
         </tr>
    </c:forEach>
   </table>
</body>
</html>