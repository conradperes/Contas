
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="net.querino.gae.compras.Conta"%>
<%@ page import="net.querino.gae.compras.Dao "%>
<html>
<head>
<title>Contas</title>
</head>
<body>
	<h1>Relação de contas</h1>
	<%
		List<Conta> contas = new ArrayList<Conta>();
		SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
		Dao dao = new Dao();
		NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		contas = dao.listarContas();
	%>
	<table border="1">
		<tr>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Data de Vencimento</th>
			<th>Linha Digitável do Código de Barras</th>
			<th>Dar baixa</th>
		</tr>
		<%
			for (Conta conta : contas) {
		%>
		<tr>
			<td><%=conta.getDescricao()%></td>
			<td><%=formatadorMoeda.format(conta.getValor())%></td>
			<td><%=formatadorData.format(conta.getVencimento())%></td>
			<td><a href="/excluir?id=<%=conta.getId()%>">Dar baixa</a>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		Total de contas:
		<%=contas.size()%></p>
	<h2>Cadastrar nova conta</h2>
	<form action="/nova" method="post">
		<table border="1">
			<tr>
				<td><label for="descricao">Descrição</label></td>
				<td><input type="text" name="descricao" id="descricao"
					size="50" /></td>
			</tr>
			<tr>
				<td valign="valor"><label for="valor">Valor</label></td>
				<td><input type="text" name="valor" id="valor" size="10" /></td>
			</tr>
			<tr>
				<td valign="top"><label for="vencimento">Data de
						Vencimento (dia/mes/ano)</label></td>
				<td><input type="text" name="vencimento" id="vencimento"
					size="10" maxlength="10" /></td>
			</tr>
			<tr>
				<td><label for="linhaDigitavel">Linha Digitável do
						Código de Barras</label></td>
				<td><input type="text" name="linhaDigitavel"
					id="linhaDigitavel" size="70"></td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="submit"
					value="Incluir" /></td>
			</tr>
		</table>
	</form>
</body>
</html>