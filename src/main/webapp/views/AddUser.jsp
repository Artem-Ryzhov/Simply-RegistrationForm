<%--
  Created by IntelliJ IDEA.
  User: артем
  Date: 09.03.16
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form action="${pageContext.servletContext.contextPath}/useradd" method="post">
    <table class="out">
        <tr>
            <td bgcolor="teal" align="center">
                User Information
            </td>
        </tr>
        <tr>
            <td>
                <table class="inner">

                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>SerName:</td>
                        <td><input type="text" name="lastname"></td>
                    </tr>
                    <tr>
                        <td>email:</td>
                        <td><input type="text" name="email"></td>
                    </tr>
                       <tr>
                        <td>role:</td>
                        <td><input type="text" name="role"></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center">
                            <input id="button" type="submit" value="Add">
                        </td>
                    </tr>

                </table>
            </td>
        </tr>
    </table>
</form>

</body>
</html>