<%@page import="java.util.List"%>
<%@page import="br.com.fabricaweb.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
<script type="text/javascript">
function confirmaExclusao(id){
	if(window.confirm('Tem certeza que deseja excluir?')){
		location.href="usucontroller.do?acao=esc&id="+id;
		
	}	
}
function novo(){
	location.href="usucontroller.do?acao=cad";
}
</script>
</head>
<body>
<%@include file="menu.jsp" %>
	<table border="1" bgcolor="CCAAEE">
	<tr>
	<th>Id:</th><th>Nome:</th><th>Ação:</th>
	</tr>
	<% List<Usuario> lista = (List<Usuario>)request.getAttribute("lista"); 
	for(Usuario u:lista){
	%>
	<tr>
	<td><%=u.getId() %></td>
	<td><%=u.getNome() %></td>
	<td><a href="javascript:confirmaExclusao(<%=u.getId()%>)">Excluir</a>|<a href="usucontroller.do?acao=alt&id=<%=u.getId()%>">Alterar</a></td>
	</tr>
	<% 	
	}
	%>
	</table>
	<input type="button" value="Novo Cadastro" onclick="javascript:novo()">
</body>
</html>