<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Process</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<section>
    <h2><a href="index.jsp">Home</a></h2>
    <h2>${param.action == 'create' ? 'Create process' : 'Edit process'}</h2>
    <hr>
    <jsp:useBean id="process" type="com.ep.proj.model.Process" scope="request"/>

    <form method="post" action="processes">
        <input type="hidden" name="id" value="${process.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input value="${process.name}" name="name"></dd>
        </dl>

        <dl>
            <dt>Positions:</dt>
            <dd>
                <jsp:useBean id="positions" type="com.ep.proj.model.Position[]" scope="request"/>
                        <c:forEach items="${positions}" var="position">
                           <input type="checkbox" name="positions" value="${position}"  ${process.findPosition(position) ? 'checked' : ''}>${position}
                        </c:forEach>
            </dd>
        </dl>
        <button>Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
