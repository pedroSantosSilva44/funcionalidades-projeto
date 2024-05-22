<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Area do Administrador</title>

    <style>
        body { font-family: Arial, sans-serif; }
        header { text-align: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        div { margin-bottom: 20px; }
        form { margin: 0; }
    </style>

</head>
<body>
<header><h1>Area do Administrador</h1></header>

<h2>Produtos</h2>

<form action="/create-clothing" method="post" enctype="multipart/form-data">
    <div>
        <label for="name">Nome da roupa</label>
        <input type="text" name="name" id="name" required>
    </div>
    <div>
        <label for="image">Escolher arquivo</label>
        <input type="file" name="image" id="image" required>
    </div>
    <button type="submit">Enviar</button>
</form>

<br><br>

<div>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Imagem</th>
                <c:if test="${sessionScope.loggedUser != null}">
                    <th>Acoes</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="clothings" items="${clothings}">
                <tr>
                    <td>${clothing.id}</td>
                    <td>${clothing.name}</td>
                    <td><img src="${clothing.image}" alt="${clothing.name}" width="50"></td>
                    <c:if test="${sessionScope.loggedUser != null}">
                        <td>
                            <form action="/delete-clothing" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${clothing.id}">
                                <button type="submit">Excluir</button>
                            </form>
                            <span> | </span>
                            <a href="admin.jsp?id=${clothing.id}&name=${clothing.name}">Atualizar</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<br><br>

<c:if test="${sessionScope.loggedUser != null}">
    <a href="/logout">Logout</a>
</c:if>

</body>
</html>
