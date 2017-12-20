<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grgbibek22
  Date: 12/19/2017
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hall List</title>
</head>
<body>
<%--<form:form action="/add/hall">
    <input type="button" value="submit" />
</form:form>--%>

<button name="submit" type="button" ><a href="<c:url value="/hall/addHall"/>">Add hall</a></button>

</body>
</html>
