
<%@page import="book_system.Account_book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, book_system.Account_book"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
request.setCharacterEncoding("UTF-8");
%>

<title>参考書更新画面</title>

<link rel = "stylesheet" href = "<%=request.getContextPath()%>/jsp/book.css" type = "text/css">

</head>

<body class="base">


<!-- 各データの値を変数に入れる。 -->
<%
List<Account_book> list = (List<Account_book>)request.getAttribute("list");
Account_book account = new Account_book();
String h_title = request.getParameter("hid_title");
String h_type = request.getParameter("hid_type");
String h_ather = request.getParameter("hid_ather");
String h_no = request.getParameter("hid_no");
%>


	<!-- actionで"UpdateServlet.servlet"の起動。 -->
	<form action="<%=request.getContextPath()%>/UpdateServlet" method="post">

		<!-- 表の作成 -->
		<table border = "1" align = "center">
			<caption align = "top"><h1>参考書更新内容</h1></caption>
				<tr>
					<td class = "aaaaa">参考書タイトル</td>
					<td class = "bbbbb">
						<!-- valueの初期値は"h_title" -->
						<input type = "Text" value =<%=h_title%> name = "update_title" size = "54" maxlength = "50">
					</td>
				</tr>

				<tr>
					<td class = "aaaaa">参考書種類</td>
					<td class = "bbbbb">
						<select name = "update_type">
						<!-- 初期値は"h_type" -->
						<option selected><%=h_type%></option>
						<option>Java</option>
						<option>C言語</option>
						<option>JSPサーブレット</option>
						<option>HTML</option>
						<option>VBA</option>
						<option>辞典</option>
						<option>Web</option>
						</select>
					</td>
				</tr>

				<tr>
					<td class = "aaaaa">その他</td>
					<td class = "bbbbb">
						<!-- 初期値は"h_ather" -->
						<input type = "Text" value =<%=h_ather%> name = "update_ather" size = "50" maxlength = "200">
					</td>
				</tr>


		</table>

		<div align="center">
			<br>
			<!-- "hidden"で"h_no"(更新したい行の番号)を送る -->
			<input type="hidden" name="no" value="<%=h_no%>">
			<input type="submit" value = "更新する">
			<input type="reset" value = "リセット">
			<!-- "main.jsp"に画面遷移する。 -->
			<input type="button" value = "戻る" onclick="location.href='/book_system/jsp/main.jsp'" >
		</div>

	 </form>


</body>
</html>