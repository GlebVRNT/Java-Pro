<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<p>Please, select your favorite language:</p>
<form action="/hello-servlet" method="POST">
    <label><input type="radio" name="language" value="Java">Java</label>
    <br/>
    <label><input type="radio" name="language" value="C#">C#</label>
    <br/>
    <label><input type="radio" name="language" value="C++">C++</label>
    <br>
    <button type="submit" name="action" value="submit">Submit</button>
</form>
<form action="hello-servlet" method="POST">
    <button type="submit" name="action" value="delete">Delete Statistics</button> <!-- New form for delete button -->
</form>

<h2>Statistics:</h2>
<p>Java: <%= application.getAttribute("Java") != null ? application.getAttribute("Java") : 0 %></p>
<p>C#: <%= application.getAttribute("C#") != null ? application.getAttribute("C#") : 0 %></p>
<p>C++: <%= application.getAttribute("C++") != null ? application.getAttribute("C++") : 0 %></p>
</body>
</html>