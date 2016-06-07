<%@page import="br.com.fabricaweb.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>
<% Usuario usu = (Usuario)request.getAttribute("usu"); %>
	<form action="usucontroller.do" method="post">
		<label>Id:</label>
		<input type="text" readonly="readonly" name="id" value="<%=usu.getId()%>"/>
		<label>Nome:</label>
		<input type="text" name="nome" value="<%=usu.getNome()%>"/>
		<label>Login:</label>
		<input type="text" name="login" value="<%=usu.getLogin()%>"/>
		<label>Senha</label>
		<input type="password" name="senha" value="<%=usu.getSenha()%>"/>
		<input type="submit" value="Salvar">
	</form>
</body>
</html>