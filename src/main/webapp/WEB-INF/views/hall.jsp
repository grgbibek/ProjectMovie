<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grgbibek22
  Date: 12/19/2017
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie Theatre</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/hall/add"  method="POST" modelAttribute="hall">
        <%--<form:hidden path="Id"  />--%>
        <label for="hallName">Name of the Theatre :</label>
        <form:input path="hallName"
                    id="hallName" placeholder="Hall Name"/><br>
        <label for="numberOfScreen">Number of Screens :</label>
        <form:input path="numberOfScreen"
                    id="numberOfScreen" placeholder="Number of screen"/><br>
        <label for="location">Location :</label>
        <form:input path="location"
                    id="location" placeholder="Location"/><br>
        <input type="button" value="Add" />
    </form:form>
</body>
</html>
