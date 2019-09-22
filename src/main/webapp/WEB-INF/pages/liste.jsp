<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Liste contacts</title>
  </head>
  <body>
    <h2>Liste contacts</h2>
    <%
      Integer inumber = (Integer) request.getSession().getAttribute("number");
      int number = 100;
      if (inumber != null) {
        number = inumber.intValue();
      }
    %>
    <ul>
      <c:forEach items="${contacts}" var="contact" end="<%= number-1  %>">
        <li>${contact.nom} : ${contact.telephone}</li>
      </c:forEach>
      <c:forEach items="${contacts}" var="contact" begin="<%= number %>" end="<%= number %>">
        <li><em>${contact.nom} : ${contact.telephone}</em></li>
      </c:forEach>
      <c:forEach items="${contacts}" var="contact" begin="<%= number+1 %>" >
        <li>${contact.nom} : ${contact.telephone}</li>
      </c:forEach>
    </ul>
  </body>
</html>
