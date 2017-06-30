<%@ page isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:master metaTitle="User: ${user.name}">
    <div>${user.id}</div>
    <div>${user.name}</div>
    <div>${user.email}</div>
</template:master>
