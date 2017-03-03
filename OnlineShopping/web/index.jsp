<%-- 
    Document   : index
    Created on : Mar 2, 2017, 11:55:43 AM
    Author     : BOSHA
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%! String username = null;%>

        <%
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("user")) {
                    username = cookies[i].getName();
                    break;
                }
            }

        %>
        <c:if test="${username !=null}">
            <%@include file="headeruser.html" %>
        </c:if>
        <c:if test="${username ==null}">
            <%@include file="headerVisitor.html" %>
        </c:if>
        <%@include  file="slider.jsp" %>
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <%@include file="sideBar.html" %>
                    <%@include file="bodyProduct.html" %>
                </div>
            </div>
        </div>
        <%@include file="footer.html" %>
        <%@include file="javascript.jsp" %>
    </body>
</html>
