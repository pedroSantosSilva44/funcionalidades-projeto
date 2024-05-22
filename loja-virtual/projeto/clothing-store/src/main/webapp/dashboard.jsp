<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Area do Administrador</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        header { text-align: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        div { margin-bottom: 20px; }
        form { display: inline; }
    </style>
</head>
<body>

<header>
    <h1>Area do Administrador</h1>
</header>

<div>
    <c:if test="${sessionScope.loggedUser != null}">
        <a href="/logout">Logout</a>
    </c:if>
</div>

<div>
    <h2>Produtos</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <c:if test="${sessionScope.loggedUser != null}">
                    <th>Acoes</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="clothings" items="${clothings}">
                <tr>
                    <td>${clothings.id}</td>
                    <td>${clothings.name}</td>
                    <c:if test="${sessionScope.loggedUser != null}">
                        <td>
                            <form action="/delete-clothing" method="post">
                                <input type="hidden" name="id" value="${clothings.id}">
                                <button type="submit">Excluir</button>
                            </form>
                            <span> | </span>
                            <a href="admin.jsp?id=${clothings.id}&name=${clothings.name}">Atualizar</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
