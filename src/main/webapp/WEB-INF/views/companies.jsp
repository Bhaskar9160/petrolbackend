<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Companies</title>
	</head>
	<body>
<form action="companies" method="get">
	<table class="wrapper">
		<tr>
			<td width="45%"></td>
			
			<td align="right" width="100%">
	<table>
					<tr>
					<th colspan="3">
					My Companies List
					</th>
					</tr>
					<tr>
						<th>SNO</th>
						<th>CompanyName</th>
						<th>CompanyAddress</th>
						
						
					</tr>
					<c:forEach items="${companies}" var="cm" varStatus="cm" >
						<tr>
							<td>
								
							</td>
							<td>
								${cm.companyCame }
							
							</td>
							
							<td>
								${cm.companyAddress }
							
							</td>
						</tr>
					
					</c:forEach>
				</table>
</td>
</tr>
</table>
</form>
</body>
</html>