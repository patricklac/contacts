<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Contacts</title>
  </head>
  <body>
    <h2>Contacts</h2>
    <ul>
      <c:forEach items="${contacts}" var="contact">
        <li>${contact.nom} : ${contact.telephone}</li>
      </c:forEach>
    </ul>
  </body>
</html>
