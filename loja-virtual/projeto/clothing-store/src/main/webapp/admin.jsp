<!DOCTYPE html>
<html lang="en">
<body>
<header><h1>Area do administrador</h1>
    <!-- Navegação ou outros elementos do cabeçalho -->
</header>
<h2>  Roupas  </h2>

     <form action="/create-clothing" method="post">

           <label>Nome da roupa</label>
         <input type="text" name="clothing-name" id="clothing-name">
         <input type="hidden" id="id" name="id" value="${param.id}">
         <button type="submit">enviar</button>


     </form>
</body>
</html>