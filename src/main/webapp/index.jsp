<%--
  Created by IntelliJ IDEA.
  User: czz
  Date: 2019/9/15
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>传统文件上传</h3>
    <form action="user/testFileUpload01" method="post" enctype="multipart/form-data" >
        浏览文件<input type="file" name="upload"/></br>
        <input type="submit" value="上传">
    </form>

    <h3>springmvc文件上传</h3>
    <form action="user/testFileUpload02" method="post" enctype="multipart/form-data" >
        浏览文件<input type="file" name="upload"/></br>
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器文件上传</h3>
    <form action="user/testFileUpload03" method="post" enctype="multipart/form-data" >
        浏览文件<input type="file" name="upload"/></br>
        <input type="submit" value="上传">
    </form>


</body>
</html>
