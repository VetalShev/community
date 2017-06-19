<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>List of articles:</h1>

    <ul>
        <c:forEach items="${articles}" var="article">
            <li>
                <div>
                    <a href="${context}/users/${article.author.id}">${article.author.name}</a>
                </div>
                <div>${article.title}</div>
                <div>${article.text}</div>
                <a href="${context}/articles/${article.id}">Read more</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
