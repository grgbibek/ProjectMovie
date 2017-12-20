<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <title>Hall Page</title>

    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
</head>
<body ng-app="myModule">
    <div ng-controller="myController">
        {{message}}
    </div>

</body>
<script src="<c:url value="/resources/js/app.js" />"> </script>
</html>



