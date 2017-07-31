<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<section>
    <h3><a href="index.jsp">Home</a></h3>
    <h2>Process list</h2>
    <a href="process?action=create">Add Process</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>process</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <c:forEach items="${processes}" var="process">
            <jsp:useBean id="process" type="com.ep.proj.model.Process"/>
                    <td>${process.id}</td>
                    <td>${process.name}</td>
                    <td>${process.positions}</td>
                    <td><a href="process?action=update&id=${user.id}&roles=">Update</a></td>
                    <td><a href="process?action=delete&id=${user.id}">Delete</a></td>
                </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>