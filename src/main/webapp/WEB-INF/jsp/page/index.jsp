<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="title" value="Recently added posts:" />

<template:master metaTitle="${title}">
    <h1>${title}</h1>

    <ul>
        <c:forEach items="${articles}" var="article">
            <li>
                <div>
                    <a href="${context}/users/${article.author.id}">${article.author.name}</a>
                </div>
                <div>${article.title}</div>
                <div>${article.text}</div>
                <a href="${context}/articles/${article.id}">Read more</a>
                <hr/>
            </li>
        </c:forEach>
    </ul>
</template:master>