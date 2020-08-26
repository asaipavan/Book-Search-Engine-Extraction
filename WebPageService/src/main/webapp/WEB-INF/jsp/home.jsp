<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
table {
	width: 100%;
}

table, th, td {
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
	align-items: flex-start;
	align-content: flex-start;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

table#t01 th {
	background-color: black;
	color: white;
}
</style>
</head>
<body>

	<h1 align="center"
		style="font-family: cursive; color: blue; align-content: center;">Cloud
		Assignment 3</h1>
	<table style="align-content: initial;align-items: initial; align-self: initial;">
		<tr>
			<td width="50%">
				<table>
					<tr>
						<td>
							<form method="get" action="search">
								<h2>
									Keyword: <input type="text" id="keyword" name="keyword"
										width="80%" height="100%"> <input type="submit"
										value="Search">
								</h2>
							</form>
						</td>
					</tr>
					<tr>
						<c:if test="${!detailsavailable}">
							<td>
								<h3 id="error" style="color: red;">${error}</h3>
							</td>
						</c:if>
						<c:if test="${detailsavailable}">
							<td>
								<h3 id="error" style="color: blue;">${desc}</h3>
							</td>
						</c:if>
					</tr>

				</table> <c:if test="${detailsavailable}">
					<div>
						<table id="t01">
							<tr>
								<th>Title and Author</th>
							</tr>
							<c:forEach var="window" items="${sessionScope.details}"
								varStatus="loopCounter">
								<tr>
									<td align="left" style="align-content: flex-start;">
										Title: ${window.title}<br> Author: ${window.author}
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:if>
			</td>
			<td style="vertical-align: top;">
			<c:if test="${detailsavailable}">
					<table>
						<tr>
							<td style="align-items: center;vertical-align: center">
								<form method="post" action="postnotes">
									<input type="hidden" name="keyword"
										value="${sessionScope.keyword }">
									<h2 align="left" style=" padding-bottom: 2px">
										Notes:
										<textarea id="notes" name="notes" style="width: 70%;height:100px; "></textarea>
										<input style="vertical-align: center" type="submit" value="Post Notes">
									</h2>
								</form>
							</td>
						</tr>
						<tr>
							<c:if test="${!notesdetailsavailable}">
								<td>

									<h3 id="error" style="color: red;">${noteserror}</h3>
								</td>
							</c:if>
							<c:if test="${notesdetailsavailable}">
								<td>
									<h3 id="error" style="color: blue;">${notesdesc}</h3>
								</td>
							</c:if>

						</tr>
					</table>
					<div>
						<form method="get" action="getnotes">
							<input type="hidden" name="keyword"
								value="${sessionScope.keyword }"> <input type="submit"
								value="Get Notes">
						</form>
					</div>
					<div id="error" style="color: blue;">
						<h3>${notesreturnmessage}</h3>
					</div>
					<c:if test="${notesdetailsavailable}">
						<div>
							<table id="t01">
								<tr>
									<th>Notes for Keyword: ${keyword}</th>
								</tr>
								<c:forEach var="window" items="${notesdetails.notes}"
									varStatus="loopCounter">
									<tr>
										<td align="left" style="align-content: flex-start;">
											${window}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</c:if>
				</c:if></td>
		</tr>
	</table>
</body>
</html>