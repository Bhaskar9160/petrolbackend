<!DOCTYPE HTML>
<html>
	<head>
		<title>UpdateProfile</title>
	</head>
	<body>
		<form action="editprofile" method="post">
			<table>
				<tr>
					<th>adminId</th>
					<td>
						<input type="number" name="adminId" readonly="readonly" value="${AUTH_ADMIN.adminId}">
					</td>
				</tr>
				<tr>
					<th>firstName</th>
					<td>
						<input type="text" name="firstName" value="${AUTH_ADMIN.firstName}">
					</td>
				</tr>
				<tr>
					<th>lastName</th>
					<td>
						<input type="text" name="lastName" value="${AUTH_ADMIN.lastName}">
					</td>
				</tr>
				<tr>
					<th>emailId</th>
					<td>
						<input type="email" name="emailId" readonly="readonly" value="${AUTH_ADMIN.emailId}">
					</td>
				</tr>
				<tr>
					<th>password</th>
					<td>
							<input type="password" name="password" readonly="readonly" value="${AUTH_ADMIN.password}">
					</td>
				</tr>
				<tr>
					<th>mobileNumber</th>
					<td>
						<input type="tel" name="mobileNumber" value="${AUTH_ADMIN.mobileNumber}">
					</td>
				</tr>
				<tr>
					<th>status</th>
					<td>
						<input type="text" name="status" value="${AUTH_ADMIN.status}">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="update">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>