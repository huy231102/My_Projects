<%-- 
    Document   : Searched
    Created on : Oct 11, 2023, 11:12:14 PM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Searched:</h1>
            <tr>
                <td>LogID&nbsp;</td>
                <td>AccountID&nbsp;</td>
                <td>ProductID&nbsp;</td>
                <td>Amount&nbsp;</td>
                <td>Address&nbsp;</td>
                <td>&emsp;Phone&emsp;</td>
                <td>&emsp;&emsp;Date</td><br>
            </tr>
        <c:forEach items="${data}" var="p">
            <tr>
                <td>&emsp;${p.logId}</td>
                <td>&emsp;&emsp;&emsp;${p.accountId}</td>
                <td>&emsp;&emsp;&emsp;&emsp;${p.productId}</td>
                <td>&emsp;&emsp;&emsp;&emsp;${p.amount}</td>
                <td>&emsp;&emsp;${p.address}</td>
                <td>&emsp;&nbsp;${p.number}</td>
                <td>&emsp;${p.date}</td>
            </tr><br>
        </c:forEach>
    </body>
</html>
