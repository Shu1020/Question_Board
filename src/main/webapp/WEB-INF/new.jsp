<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<form:form method="POST" action="/newQuestion" modelAttribute="question">
<p>
<form:label path="qtext">Question</form:label>
<form:errors path="qtext"/>
<form:textarea path="qtext"/>
</p>
<p>
<form:label path="frontEndTags">tags (separate by comma)</form:label>
<form:errors path="frontEndTags"/>
<form:textarea path="frontEndTags"/>
</p>
<button>Submit Question</button>

</form:form>
</body>
</html>