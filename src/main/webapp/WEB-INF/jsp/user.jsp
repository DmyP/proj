<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<section>
    <h2><a href="index.jsp">Home</a></h2>
    <h2>${param.action == 'create' ? 'Create user' : 'Edit user'}</h2>
    <hr>
    <jsp:useBean id="user" type="com.ep.proj.model.User" scope="request"/>

    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input value="${user.name}" name="name"></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input value="${user.password}" name="password"></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input value="${user.email}" name="email"></dd>
        </dl>
        <dl>
            <dt>Role:</dt>
            <dd><select name="role">
                <c:forEach items="${roles}" var="role">
                    <option value="${role}" ${role == user.role ? 'selected' : ''}>${role}</option>

                </c:forEach>
            </select></dd>
        </dl>
        <dl>
            <dt>Position:</dt>
            <dd>
                <select name="position">
                    <c:forEach items="${positions}" var="position">
                        <option value="${position}" ${position == user.position ? 'selected' : ''}>${position}</option>
                    </c:forEach>
                </select>
            </dd>
        </dl>
        <dl>
            <dt>Enabled:</dt>
            <dd><input type="checkbox" name="enabled" <% if (user.isEnabled()) { %> checked <% } %> /></dd>
        </dl>
        <dl>
            <dt>Date busy to:</dt>
            <dd><input type="date" value="${user.busyUntil}" name="date"></dd>
        </dl>

        <button>Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
