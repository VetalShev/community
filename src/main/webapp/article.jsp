<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>${article.title}</h1>

    <div>
        <a href="/users/${article.author.id}">${article.author.name}</a>
        <span>${article.date}</span>
    </div>

    <div>${article.text}</div>

    <div>Comments:</div>

    <ul>
        <c:forEach items="${article.comments}" var="comment">
            <li>
                <div>
                    <a href="/users/${article.author.id}">${article.author.name}</a>
                </div>
                <div>${comment.date}</div>
                <div>${comment.text}</div>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
