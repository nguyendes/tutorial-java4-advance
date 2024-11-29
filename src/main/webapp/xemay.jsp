<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Tucuteprovjp
  Date: 11/28/2024
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Ten</td>
            <td>Gia</td>
            <td>Loai</td>
            <td>Hanh dong</td>
        </tr>
        </thead>
        <c:forEach var="xemay" items="${xeMays}">
            <tr>
                <td>${xemay.id}</td>
                <td>${xemay.tenXe}</td>
                <td><fmt:formatNumber value="${xemay.giaBan}" type="currency"/></td>
                <td>${xemay.loaiXe.tenLoaiXe}</td>
                <td><a href="/xoa?id=${xemay.id}" onclick="return confirm('b co mun xoa k')">Xoa</a></td>
                <td></td>
            </tr>
        </c:forEach>
    </table>

    <form action="/them" method="post">
        <input type="text" name="tenXe">Ten xe <br>
        <input type="text" name="giaBan">Gia <br>
        <select name="lxm" id="">gi
            <c:forEach items="${loaiXe}" var="loaixe">
                <option value="${loaixe.id}">${loaixe.tenLoaiXe}</option>
            </c:forEach>
        </select>
        <button type="submit">ok</button>
    </form>
</body>
</html>
