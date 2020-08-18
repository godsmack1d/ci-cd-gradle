<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<div>
    <div>
        <h2>Hello, <%= request.getParameter("name") %>! </h2>
    </div>

    <div>
        Make you order
    </div>

    <form name="order" method="POST" action="price">
        <input type="hidden" name="name" value=<%= request.getParameter("name") %>>
        <select name="items-selector" multiple>
            <c:forEach items="${items}" var="item">
                <tr>
                    <option>${item}</option>
                </tr>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>