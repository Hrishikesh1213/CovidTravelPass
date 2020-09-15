<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter the details</title>
</head>
<body>
	<form action="TravelDetails" method="post">
		 Source : <select name="source">
					    <option value="ap">Andhra Pradesh</option>
					    <option value="an">Andaman and Nicobar Islands</option>
					    <option value="ar">ArunachalPradesh</option> 
				        <option value="as">Assam</option>
				        <option value="br">Bihar</option>
				        <option value="ch">Chandigarh</option>
				        <option value="ct">Chhattisgarh</option>
					    <option value="dd">Daman and Diu</option>
					    <option value="dl">Delhi</option>
					    <option value="dn">Dadra and Nagar Haveli</option>
				        <option value="ga">Goa</option>
				        <option value="gj">Gujarat</option>
					    <option value="hp">Himachal Pradesh</option>
					    <option value="hr">Haryana</option>
					    <option value="jh">Jharkhand</option>
					    <option value="jk">Jammu and Kashmir</option>
					    <option value="ka">Karnataka</option>
				        <option value="kl">Kerala</option>
				        <option value="la">Ladakh</option>
					    <option value="ld">Lakshadweep</option>
					    <option value="mh">Maharashtra</option>
					    <option value="ml">Meghalaya</option>
					    <option value="mn">Manipur</option>
					    <option value="mp">MadhyaPradesh</option>
					    <option value="mz">Mizoram</option>
					    <option value="nl">Nagaland</option>
					    <option value="or">Odisha</option> 
					    <option value="pb">Punjab</option>
					    <option value="py">Pondicherry</option>
					    <option value="rj">Rajasthan</option>
					    <option value="sk">Sikkim</option>
					    <option value="tg">Telangana</option>
					    <option value="tn">Tamilnadu</option>
					    <option value="tr">Tripura</option>
			            <option value="up">UttarPradesh</option>
					    <option value="ut">Uttarakhand</option>
					    <option value="wb">West Bengal</option>
			                           
			     </select>
					
		 Destination : <select name="destination">
							<option value="ap">Andhra Pradesh</option>
						    <option value="an">Andaman and Nicobar Islands</option>
						    <option value="ar">ArunachalPradesh</option> 
					        <option value="as">Assam</option>
					        <option value="br">Bihar</option>
					        <option value="ch">Chandigarh</option>
					        <option value="ct">Chhattisgarh</option>
						    <option value="dd">Daman and Diu</option>
						    <option value="dl">Delhi</option>
						    <option value="dn">Dadra and Nagar Haveli</option>
					        <option value="ga">Goa</option>
					        <option value="gj">Gujarat</option>
						    <option value="hp">Himachal Pradesh</option>
						    <option value="hr">Haryana</option>
						    <option value="jh">Jharkhand</option>
						    <option value="jk">Jammu and Kashmir</option>
						    <option value="ka">Karnataka</option>
					        <option value="kl">Kerala</option>
					        <option value="la">Ladakh</option>
						    <option value="ld">Lakshadweep</option>
						    <option value="mh">Maharashtra</option>
						    <option value="ml">Meghalaya</option>
						    <option value="mn">Manipur</option>
						    <option value="mp">MadhyaPradesh</option>
						    <option value="mz">Mizoram</option>
						    <option value="nl">Nagaland</option>
						    <option value="or">Odisha</option> 
						    <option value="pb">Punjab</option>
						    <option value="py">Pondicherry</option>
						    <option value="rj">Rajasthan</option>
						    <option value="sk">Sikkim</option>
						    <option value="tg">Telangana</option>
						    <option value="tn">Tamilnadu</option>
						    <option value="tr">Tripura</option>
				            <option value="up">UttarPradesh</option>
						    <option value="ut">Uttarakhand</option>
						    <option value="wb">West Bengal</option>
				                           
				     </select>

		<br><br>

		<input type="submit"  name="submit" value="Report" required>
	</form>
</body>
</html>
		 <!-- Enter the email to send the report :<input type="email" name="emailid" required> 
		 <input type="text" name="source">
		 <input type="text" name="destination" required>
		 -->