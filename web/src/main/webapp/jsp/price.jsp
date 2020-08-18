<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Price</title>
</head>
<body>
<div>
    <h2>Dear <%= request.getParameter("name") %>! </h2>
    Your order:
    <ol>
        <c:forEach items="${selectedItems}" var="selectedItem">
            <li>${selectedItem}</li>
        </c:forEach>
    </ol>
    Total ${sum} $
</div>
</body>
</html>