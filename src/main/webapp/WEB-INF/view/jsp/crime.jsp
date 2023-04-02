<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div id="main_container">

    <div id="header">
        <div id="logo"><a href="index.html"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>
        <div class="on_air"><img src="images/onair.gif" alt="" title="" border="0" /></div>
    </div>

    <div id="menu">
        <ul>
            <li><a class="current" href="index.html" title="">home</a></li>
            <li><a href="#" title="">listen live</a></li>
            <li><a href="#" title="">latest events</a></li>
            <li><a href="#" title="">shows</a></li>
            <li><a href="#" title="">news</a></li>
            <li><a href="#" title="">gallery</a></li>
            <li><a href="#" title="">downloads</a></li>
            <li><a href="#" title="">contact us</a></li>
        </ul>
    </div>


    <div>
        <table>
            <tr>
                <td>Police registration</td>
                <td>Criminal Case</td>
                <td>Crime date</td>
                <td>Criminal code article</td>
                <td>Description</td>

                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach var="crime" items="${crimes}">
                <tr>
                    <td>${crime.policeRegNumber}</td>
                    <td>${crime.caseInvestigationNumber}</td>
                    <td>${crime.crimeDate}</td>
                    <td>${crime.criminalCodeArticleNumber}</td>
                    <td>${crime.description}</td>

<%--                    <FORM NAME="form1" ACTION="basic.jsp" METHOD="POST">--%>
<%--                        <INPUT TYPE="SUBMIT" VALUE="Click Me!">--%>
<%--                    </FORM>--%>

                    <td>
<%--                    <form name="edit-btn" action="/api/crime/${crime.id}" >--%>
<%--                        <input type="submit" value="Delete">--%>
<%--                    </form>--%>
<%--                        <a href="/api/crime/" methods="delete" >--%>

                    <form action="/api/crime/${user.id}" method="post">
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="_method" value="delete">
                        <button type="submit">Delete</button>
                    </form>
                    </td>

<%--                    <td><button>Edit</button></td>--%>
<%--                    <td><button>Delete</button></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>


some text here
</body>
</html>
