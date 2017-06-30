<%@ tag isELIgnored="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fragment" tagdir="/WEB-INF/tags/fragment" %>

<%@ attribute name="metaTitle" required="false" type="java.lang.String"%>

<!DOCTYPE html>
<html>
    <head>
        <title>${metaTitle}</title>
    </head>
    <body>

        <fragment:header />

        <jsp:doBody/>

        <fragment:footer />

    </body>
</html>
