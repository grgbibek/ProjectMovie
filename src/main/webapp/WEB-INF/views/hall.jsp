<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
</head>
<body ng-app="myModule">
    <div ng-controller="HallController">
        <form name="AddHallForm" ng-submit="AddHall();">

            <table>
                <tr>
                    <td>Hall Name :</td>
                    <td><input type="text" ng-model="hall.hallName" required /></td>
                </tr>

                <tr>
                    <td>Number Of Screens :</td>
                    <td><input type="text" ng-model="hall.numberOfScreen" required /></td>
                </tr>

                <tr>
                    <td>Location :</td>
                    <td><input type="text" ng-model="hall.location" required /></td>
                </tr>

                <tr>
                    <td><input type="submit" value="submit" ng-disabled="AddHallForm.$invalid"/></td>
                </tr>
            </table>
        </form>
    </div>


</body>

<script src="<c:url value="/resources/js/app.js" />"> </script>
</html>


