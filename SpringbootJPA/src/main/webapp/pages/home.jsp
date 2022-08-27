<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
----------------------------------------------------------------------
<form action="addAlien">
<h2>Aadd Alian</h2>
<table>
<tr>
<th>ID</th>
<th><input type="text" name="id"></th>
</tr>
<tr>
<th>Name</th>
<th> <input type="text" name="aname"></th>
</tr>
<tr></tr>
<th>Language</th>
<th><input type="text" name="lang"></th>
<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>
-------------------------------------------------------------------------
<h4>Alient Name:: ${obj.aname} </h4>
<h4>Alient Name:: ${obj.id} </h4>
<h4>Alient Name:: ${obj.lang} </h4>

----------------------------------------------------------------------------
<form action="getAlien">
<table>
<tr>><H1>Serch Alien </H1></tr>
<tr>
<th>ID</th>
<th><input type="text" name="id"></th>
</tr>

<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>
-----------------------------------------------------------------------------------
<tr><H1>Delete Alien </H1></tr>
<form action="deleteAlien1">
<table>
<tr>
<th>ID</th>
<th><input type="text" name="id"></th>
</tr>

<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>
----------------------------------------------------------------------------------
<form action="updateAlien">
<h2>Aadd Alian</h2>
<table>
<tr>
<th>ID</th>
<th><input type="text" name="id"></th>
</tr>
<tr>
<th>Name</th>
<th> <input type="text" name="aname"></th>
</tr>
<tr></tr>
<th>Language</th>
<th><input type="text" name="lang"></th>
<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>
-------------------------------------------------------------------------------------------
<form action="getByNameAlien">
<table>
<tr>><H1>Find By Name </H1></tr>
<tr>
<th>ID</th>
<th><input type="text" name="name"></th>
</tr>

<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>

-----
<h4>Alient List:: ${List} </h4>
------------------------

<form action="getByIdGaterThan">
<table>
<tr>><H1>Find gater than a perticular id</H1></tr>
<tr>
<th>ID</th>
<th><input type="text" name="id"></th>
</tr>

<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>

-----
<h4>Alient List:: ${getByIdGaterThanList} </h4>
------
<form action="getSortedResult">
<table>
<tr>><H1>Find sorted list</H1></tr>
<tr>
<th>ID</th>
<th><input type="text" name="lang"></th>
</tr>

<tr>
<th><input type="submit"></th>
</tr>
</table>
</form>

-----
<h4>Alient List:: ${getOrderbySOrtedList} </h4>
------
</body>
</html>