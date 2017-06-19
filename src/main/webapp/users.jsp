<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Users list</h1>

    <ul>
        <c:forEach items="${users}" var="user">
            <li>
                <a href="${context}/users/${user.id}">${user.name}</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
