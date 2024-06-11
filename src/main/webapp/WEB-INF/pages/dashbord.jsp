<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<jsp:useBean id="dao" class="br.csi.dao.FuncionarioDAO"/>
<jsp:useBean id="daoserv" class="br.csi.dao.ServicoDAO"/>
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
        #container {
            margin: auto;
            display: grid;
            place-items: center;
            width: 1000px;

        }
        form{
            width: 500px;
        }
        body{
            background-color: #1a1a1a;
            /* Fundo escuro */
            color: #fff;
            /* Texto branco */
            font-family: Helvetica, Arial, sans-serif;
        }
        h1 {
            color: #ff8800;
            margin: auto;
            text-align: center;
            font-size: 30px;
            margin-top: 15px;
            margin-bottom: 15px;
        }
        table {
            background-color: #333333;
            /* Fundo escuro para a tabela */
            color: #fff;
            /* Texto branco na tabela */
            border: 1px solid #ffffff;
            /* Borda mais escura */
            width: 700px;
            text-align: center;
        }

        table th {
            background-color: #444444;
            margin: 20px;
            /* Fundo mais escuro para os cabeçalhos da tabela */
            color: #bd7d34;
            border: 1px solid #ffffff;

            /* Texto branco para os cabeçalhos da tabela */
        }

        /* Estilize os links na tabela */
        .table a {
            color: #ff8800;

            /* Laranja para os links na tabela */
            text-decoration: none;
        }

        .table a:hover {
            color: #ff6600;
            /* Laranja mais escura ao passar o mouse nos links da tabela */

        }

        /* Estilize o texto nas células da tabela para torná-lo mais visível */
        table td {
            color: #ffffff;
            border: 1px solid #ffffff;

            /* Texto preto para células da tabela */
        }
        .form-label{
            width: 200px;
        }
        #btnalt {
            background-color: #00ff00;
            color: #313131;

        }

        #btnexc {
            background-color: #f04646;
            color: #ffffff;
            border: 2px solid #000000;
        }

        #btnalt:hover {
            background-color: #00cc00;
            color: #313131;
        }

        #btnexc:hover {
            background-color: #cc0000;
            color: #313131;
        }

    </style>
</head>
<body>
<div id="container">
    <c:if test="${not empty retorno}">
        <h2>${retorno} </h2>
    </c:if>

    <h1>CADASTRO DE FUNCIONÁRIOS</h1>

    <form action="funcionario" method="post">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" aria-describedby="emailHelp" name="nome" placeholder="nome" required>
        </div>
        <div class="mb-3">
            <label for="salario" class="form-label">Salário</label>
            <input type="number" class="form-control" id="salario" name="salario" required>
        </div>
        <input type="hidden" name="opcao" value="cadastrar">
        <button type="submit" class="btn btn-primary" value="cadastrar" name="CADASTRAR">Cadastrar</button>
    </form>


    <br/>
    <table>
        <th>Nome</th>
        <th>Salário</th>
        <th>Ações</th>
        <th></th>
        <c:forEach var="funcionario" items="${dao.funcionario}">
            <tr>
                <td>${funcionario.nome}</td>
                <td>${funcionario.salario}</td>
                <td>
                    <a class="btn btn-success" id="btnexc" href="funcionario?opcao=excluir&&idfunc=${funcionario.idFunc}">EXCLUIR</a>
                </td>
            </tr>
        </c:forEach>
    </table>


    <form action="servico" method="post">
        <c:choose><c:when test="${servico.idserv =! null}">
            <h1>Editar <Serviço></Serviço></h1>
            <input type="hidden" name="idserv" value="${servico.idserv}">
        </c:when>
            <c:otherwise>
                <h1>Cadastrar Serviços</h1>
                <input type="hidden" name="idserv" value="0">
            </c:otherwise>
        </c:choose>

        <div class="mb-3">
            <label for="nomeserv" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nomeserv" value="${servico.nome}"
                   aria-describedby="emailHelp" name="nomeserv" placeholder="nome do serviço" required>
        </div>
        <div class="mb-3">
            <label for="local" class="form-label">Endereço</label>
            <input type="text" class="form-control" id="local" name="local" value="${servico.local}" equired>
        </div>
       <!-- <div class="mb-3">
            <label for="data" class="form-label">Data:</label>
            <input type="date" class="form-control" id="data" name="data" required>
        </div>-->
        <div class="mb-3">
            <label for="valor" class="form-label">Preço</label>
            <input type="number" class="form-control" id="valor" name="valor" value="${servico.valor}" required>
        </div>
        <div class="mb-3">
            <label for="func" class="form-label">Funcionário</label>
            <input type="text" class="form-control" id="func" name="func" value="${servico.funcionario.nome}"
                   placeholder="funcionário responsável" required>
        </div>
        <input type="hidden" name="opcao" value="adicionar">
        <button type="submit" class="btn btn-primary" value="adicionar" name="ADICIONAR">Adicionar</button>
    </form>
    <br/>
    <table>
        <th>Nome do Serviço</th>
        <th>Local</th>
        <th>Valor</th>
        <th>Funcionario</th>
        <th>Ações</th>

        <c:forEach var="servico" items="${daoserv.servico}">
            <tr>
                <td>${servico.nome}</td>
                <td>${servico.local}</td>
                <td>${servico.valor}</td>
                <td>${servico.funcionario.nome}</td>
                <td>
                    <a class="btn btn-success" id="btnexc"
                       href="servico?opcao=excluir&&idserv=${servico.idServ}">EXCLUIR</a>
                    <a class="btn btn-success" id="btnexc"
                       href="servico?opcao=editar&&idserv=${servico.idServ}">Editar</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
