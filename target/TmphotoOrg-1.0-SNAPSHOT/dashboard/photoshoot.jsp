<%@ page import="ba.fotkaj.tmphotoorg.ejb.photoshoot.entity.Reservation" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>photoshoot</title>
</head>
<body>

<%

    List<Reservation> reservationList =(List<Reservation>) request.getAttribute("rezervacije");
%>

<h1> Ovdje su rezervisani termini </h1>

<ul>
<%

    for(Reservation reservation:reservationList){


%><li><%=reservation.getName()%></li>
    <%}%>
</ul>
</body>
</html>
