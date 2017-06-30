<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<c:set var="title" value="Users list" />

<template:master metaTitle="${title}">
    <h1>title</h1>

    <ul>
        <c:forEach items="${users}" var="user">
            <c:url var="userUrl" value="/users/${user.id}" />
            <li>
                <a href="${userUrl}">${user.name}</a>
            </li>
        </c:forEach>
    </ul>
</template:master>