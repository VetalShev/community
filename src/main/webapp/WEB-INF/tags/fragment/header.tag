<%@ tag isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="homeUrl" value="/" />
<c:url var="articlesUrl" value="/" />
<c:url var="usersUrl" value="/" />

<div class="header">
    <ul>
        <li>
            <a href="${homeUrl}">Home</a>
        </li>
        <li>
            <a href="${articlesUrl}">Articles</a>
        </li>
        <li>
            <a href="${usersUrl}">Users</a>
        </li>
    </ul>
</div>