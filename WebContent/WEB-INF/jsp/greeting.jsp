<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=Windows-31j">
  <title>Greeting Demo</title>
 
</head>
<body>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="appBody">
  <table>
    <tr>
      <th>time</th>
      <td><span id="time">a.m.</span></td>
    </tr>
    <tr>
      <th>greeting</th>
      <td><span id="greeting">Good morning</span></td>
      
    </tr>
  </table>
 
 <c:out value="${resDto.message}"/><br>
 <c:out value="${resDto.name}"/>
</div>
</body>
</html>