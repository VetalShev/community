<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<c:set var="title" value="List of articles:" />

<template:master metaTitle="${title}">
    <h1>${title}</h1>

    <ul>
        <c:forEach items="${articles}" var="article">
            <c:url var="currentAuthorUrl" value="/users/${article.author.id}" />
            <c:url var="currentArticleUrl" value="/articles/${article.id}" />
            <li>
                <div>
                    <a href="${currentAuthorUrl}">${article.author.name}</a>
                </div>
                <div>${article.title}</div>
                <div>${article.text}</div>
                <a href="${currentArticleUrl}">Read more</a>
                <hr/>
            </li>
        </c:forEach>
    </ul>
</template:master>