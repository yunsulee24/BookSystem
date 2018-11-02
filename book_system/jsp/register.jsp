<%@page import="book_system.Account_book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, book_system.Account_book"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>参考書登録画面</title>

<link rel = "stylesheet" href = "<%=request.getContextPath()%>/jsp/book.css" type = "text/css">

</head>

<body calss="base">

	<!-- "RegisterServlet"を起動する。 -->
	<form action="http://localhost:8080/book_system/RegisterServlet" method="post">

		<!-- 表の作成 -->
		<table border = "1" align = "center">
			<caption align = "top"><h1>参考書情報登録</h1></caption>
				<tr>
					<td class="aaaaa">参考書タイトル</td>
					<td class = "bbbbb">
						<input type = "Text" value ="登録する参考書タイトルを入力してください。" name = "regiserbook_title" size = "54" maxlength = "50">
					</td>
				</tr>

				<tr>
					<td class="aaaaa">参考書種類</td>
					<td class = "bbbbb">
						<select name = "registerbook_type">
						<option selected>Java</option>
						<option>C言語</option>
						<option>JSPサーブレット</option>
						<option>HTML</option>
						<option>VBA</option>
						<option>辞典</option>
						<option>Web</option>
					</td>
				</tr>

				<tr>
					<td class="aaaaa">その他</td>
					<td class = "bbbbb">
						<input type = "Text" value ="その他" name = "registerbook_ather" size = "54" maxlength = "50">
						</td>
				</tr>


		</table>

		<div align="center">
			<br>
			<input type="submit" value = "登録する">
		 	<input type="reset" value = "リセット">
			<!-- "main.jsp"に画面遷移する。 -->
			<input type="button" value = "戻る" onclick="location.href='/book_system/jsp/main.jsp'" >
		</div>

	 </form>


</body>
</html>