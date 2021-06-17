<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Book</title>
    </head>
    <body>
        <div class="card container">
            <c:url var="criarExame" value="/exame/criar"/>
            <form:form action="${criarExame}" method="post" modelAttribute="exame">
                <form:label path="paciente.nome">Paciente: </form:label> <form:input type="text" path="paciente.nome"/>
                <form:label path="nome">Exame: </form:label> <form:input type="text" path="nome"/>
                <form:label path="data">Data: </form:label> <form:input path="data"/>
                <form:label path="resultadoExame">Resultado Exame: </form:label> <form:input path="resultadoExame"/>
                <input type="submit" value="submit"/>
            </form:form>
        </div>
    </body>
</html>