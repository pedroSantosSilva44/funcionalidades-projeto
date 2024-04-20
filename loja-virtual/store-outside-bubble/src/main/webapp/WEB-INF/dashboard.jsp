<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>List Roupas</title>
</head>
<body>

    <h1>List Roupas</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.id}</td>
                <td>${car.name}</td>
                <td>

                    <form action="/delete-roupa" method="post">

                        <input type="hidden" id="id" name="id" value="${roupa.id}">
                        <button type="submit">Delete</button>

                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>