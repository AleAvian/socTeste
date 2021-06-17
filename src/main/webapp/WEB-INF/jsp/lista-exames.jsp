<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lista Exames</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>


        <div class="container card">
            <c:if test="${!status}">
                <div class="alert alert-danger" role="alert">
                    Ocorreu algum erro ao inserir/editar exame!
                </div>
            </c:if>


            <table class="table" style="margin-top:10px">
                <thead>
                    <tr>
                        <th>Paciente</th>
                        <th>Exame</th>
                        <th>Data</th>
                        <th>ResultadoExame</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${exames}" var="exame">
                        <tr>
                            <td>${exame.paciente.nome}</td>
                            <td>${exame.nome}</td>
                            <td>${exame.data}</td>
                            <td>${exame.resultadoExame}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="http://localhost:8080/exame/criar" class="btn btn-primary"
                style="margin:10px">Novo exame</a>
        </div>
    </body>
</html>
