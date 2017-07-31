<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <h2>User list</h2>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>password</th>
            <th>email</th>
            <th>role</th>
            <th>position</th>
            <th>enabled</th>
            <th>busyUntil</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" type="com.ep.proj.model.User"/>
                <tr class="${user.enabled ? 'enabled' : 'disabled'}">
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                    <td><a href="mailto:${user.email}">${user.email}</a></td>
                    <td>${user.role}</td>
                    <td>${user.position}</td>
                    <td>${user.enabled}</td>
                    <td>${user.busyUntil}</td>
                </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>