<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        #cadfunc{
            width: 460px;
            background-color: #17171f;
            height: 400px;
            border-radius: 10px;
            border: solid 2px #ff8800;
            padding: 30px;
            margin: auto;
            position: absolute;

            top: 50%;

            left: 50%;

            transform: translate(-50%, -50%);
        }
        h2 {
            color: #ff8800;
            margin: auto;
            text-align: center;
            font-size: 30px;
            margin-top: 15px;
            margin-bottom: 15px;
        }
        .btn {
            background-color: #ff8800;
            /* Laranja para os botões */
            color: #fff;
            /* Texto branco para os botões */
            border: none;
            padding: 10px 20px;
            border-radius: 10px;
            /* Borda arredondada */
            text-transform: uppercase;
            cursor: pointer;
        }
        .cad {
            margin-top: 10px;
            float: right;
            font-size: 12px;
            color: #ff8800;
        }

        .cad:hover {
            color: #b14801;
        }

        .btn:hover {
            background-color: #ff6600;
            /* Laranja um pouco mais escuro ao passar o mouse nos botões */
            color: #fff;
            /* Mantenha o texto branco ao passar o mouse nos botões */
        }
        body{
            background-color: #1a1a1a;
            /* Fundo escuro */
            color: #fff;
            /* Texto branco */
            width: 400px;
            font-family: Helvetica, Arial, sans-serif;
        }
    </style>
</head>
<body>

<div id="cadfunc">
<h2>LOGIN</h2>

<form action="login" method="post">
    <label>
        <b>Login</b>
    </label>
    <input type="hidden" id="iduser" name="iduser">
    <input type="text" placeholder="nome" class="form-control" name="nome" required>
    </br>

    <label>
        <b>Senha</b>
    </label>
    <input type="password" placeholder="senha" class="form-control" name="senha" required>
    </br>
    <input type="submit" value="LOGIN" name="login" class="btn">
    <a href="cadastrar.jsp" class="cad">Não possui uma conta? Cadastre-se</a>
</form>

<c:if test="${not empty erro}">
    <h2>${erro} </h2>
</c:if>

</div>
</body>
</html>
