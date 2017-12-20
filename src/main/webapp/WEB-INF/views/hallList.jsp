<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hall Page</title>

    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
</head>
<body ng-app="myModule">
<div ng-controller="myController">

    <button name="submit" type="button"><a href="<c:url value="/hall/addHall"/>">Add hall</a></button>
    <br><br>
    <table>
        <thead>
        <tr>
            <td>Id</td>
            <td>Hall Name</td>
            <td>Number Of Screen</td>
            <td>Location</td>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="hall in hallList">
            <td>{{hall.Id}}</td>
            <td>{{hall.hallName}}</td>
            <td>{{hall.numberOfScreen}}</td>
            <td>{{hall.location}}</td>
        </tr>
        </tbody>
    </table>



</div>

</body>
<script src="<c:url value="/resources/js/app.js" />"> </script>
</html>
