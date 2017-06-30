<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<c:url var="authorUrl" value="/users/${article.author.id}" />

<template:master metaTitle="${article.title}">

    <h1>${article.title}</h1>

    <!--<table>
        <c:forEach var="httpheaders" items="${header}">
            <tr>
                <td><c:out value="${httpheaders.key}" /></td>
                <td><c:out value="${httpheaders.value}" /></td>
            </tr>
        </c:forEach>
    </table-->

    <div>
        <a href="${authorUrl}">${article.author.name}</a>
        <span>${article.date}</span>
    </div>

    <div>${article.text}</div>

    <hr/>
    <div>Comments:</div>

    <ul>
        <c:forEach items="${article.comments}" var="comment">
            <li>
                <div>
                    <a href="${authorUrl}">${article.author.name}</a>
                </div>
                <div>${comment.date}</div>
                <div>${comment.text}</div>
            </li>
        </c:forEach>
    </ul>

</template:master>