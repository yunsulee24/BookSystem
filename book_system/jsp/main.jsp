<%@page import="book_system.Account_book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, book_system.Account_book"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参考書管理システム</title>
<!-- CSSの利用 -->
<link rel = "stylesheet" href = "<%=request.getContextPath()%>/jsp/book.css" type = "text/css">

</head>

<body class="base">
	
	<!-- サブミットボタン（登録ボタン）のactionで"SelectServlet_book.servlet"を起動する。 -->
	<form action="<%=request.getContextPath()%>/SelectServlet_book" method="post">
		<!-- 表の作成 -->
		<table border = "1" align = "center">
			<caption align = "top"><h1>参考書情報検索</h1></caption>
				<tr>
					<td class="aaaaa">参考書タイトル</td>
					<!-- テキストボックスの作成 -->
					<td class="bbbbb">
						<input type = "Text" value ="" name = "booktitletext" size = "54" maxlength = "50">
					</td>
				</tr>

				<tr>
					<td class="aaaaa">参考書種類</td>
					<!-- プルダウンリストの作成 -->
					<td class="bbbbb" >
						<select name = "pulldownlist">
						<option selected></option>
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
		</table>
<br>
		<div>
			<input type="submit" value = "検索" style="position: absolute; left: 500px" >
			<!-- クリックで"register.jsp"を呼ぶボタン -->
			<input type="button" value = "登録" onclick="location.href='/book_system/jsp/register.jsp'" style="position: absolute; right: 500px ">
		</div>
<br>
	 </form>

<!-- ************************************************************************** -->

<!-- "list"の値がnullではないなら -->
<%
	if (request.getAttribute("list") != null ){
%>
		<!-- 表の作成 -->
		<TABLE calsss="book" align="center" BORDER="1">
		<caption align = "top"><h3>検索結果</h3></caption>

		<TR>
		<TH class="ccccc">参考書タイトル</TH>
		<TH class="ccccc">参考書種類</TH>
		<TH class="ccccc">その他</TH>
		<TH class="ccccc">更新</TH>
		<TH class="ccccc">削除</TH>
		<TH class="ccccc">番号</TH>


<!-- サーブレットから受け取った"List"を"list"に -->
<%
		List<Account_book> list = (List<Account_book>)request.getAttribute("list");
		for(int i=0; i<list.size(); i++){
			Account_book account = list.get(i);

%>
				<tr>
					<!-- 表に該当するデータを入れる -->
					<td class="bbbbb"><%=account.getBook_title()%></td>
					<td class="bbbbb"><%=account.getBook_type()%></td>
					<td class="bbbbb"><%=account.getAther()%></td>
					<td class="bbbbb">
						<!-- 更新ボタンの作成、"update.jsp"に画面遷移する、hiddenで値を渡す。-->
						<form action="http://localhost:8080/book_system/jsp/update.jsp" method="post">
							<input type="hidden" name="hid_title" value="<%=account.getBook_title()%>">
							<input type="hidden" name="hid_type"  value="<%=account.getBook_type()%>">
							<input type="hidden" name="hid_ather" value="<%=account.getAther()%>">
							<input type="hidden" name="hid_no"    value="<%=account.getNo()%>">
							<input type="submit" value = "更新">
						</form>
					</td>
					<td class="bbbbb">
						 <!-- 削除ボタンの作成、"DeleteServlet.servlet"を起動する、hiddenで値を渡す。-->
						 <form action="http://localhost:8080/book_system/DeleteServlet" method="post">
							 <input type="hidden" name="hid_no"    value="<%=account.getNo()%>">
							 <input type="submit" value = "削除">
						 </form>
 					</td>
	 				<td class="bbbbb"><%=account.getNo()%></td>
				</tr>
<%
		}

	}

%>

	</table>


</body>

</html>