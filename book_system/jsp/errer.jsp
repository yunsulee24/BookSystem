<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>エラー</title>

<link rel = "stylesheet" href = "<%=request.getContextPath()%>/jsp/book.css" type = "text/css">

</head>

<body align="crnter">

	<div align="center">
		<font size="5" color="red"><h1>無効な入力です</h1></font>

		<form action="<%=request.getContextPath()%>/jsp/main.jsp" method="post">
			 <input type="submit" value = "戻る">
		</form>
	</div>

</body>
</html>