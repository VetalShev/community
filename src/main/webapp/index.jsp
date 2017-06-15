<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Recently added posts:</h1>

    <ul>
        <c:forEach items="${articles}" var="article">
            <li>
                <div>
                    <a href="/users/${article.author.id}">${article.author.name}</a>
                </div>
                <div>${article.title}</div>
                <div>${article.text}</div>
                <a href="/articles/${article.id}">Read more</div>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
