<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Processes list</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<section>
    <h3><a href="index.jsp">Home</a></h3>
    <h2>Process list</h2>
    <a href="processes?action=create">Add Process</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Process id</th>
            <th>Process name</th>
            <th>Positions needed</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <c:forEach items="${processes}" var="process">
            <jsp:useBean id="process" type="com.ep.proj.model.Process"/>
                    <td>${process.id}</td>
                    <td>${process.name}</td>
                    <td>
                        <jsp:useBean id="positions" type="com.ep.proj.model.Position[]" scope="request"/>
                        <c:forEach items="${positions}" var="position">
                            <input type="checkbox" name="positions" value="${position}"  ${process.findPosition(position) ? 'checked' : ''}>${position}
                        </c:forEach>
                    </td>
                    <td><a href="processes?action=update&id=${process.id}">Update</a></td>
                    <td><a href="processes?action=delete&id=${process.id}">Delete</a></td>
                </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>