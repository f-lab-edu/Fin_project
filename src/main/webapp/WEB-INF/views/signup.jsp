<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
</head>
<body>
<h1>회원 가입</h1>
<form action="/signup" method="post">
    <label for="id">id:</label>
    <input type="text" id="id" name="id" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="회원 가입">
</form>
</body>
</html>