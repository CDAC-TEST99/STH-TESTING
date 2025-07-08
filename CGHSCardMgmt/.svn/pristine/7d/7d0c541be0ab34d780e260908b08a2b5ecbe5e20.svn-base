<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<center>
<br>
<table border="2" cellspacing="0" style="border-collapse: collapse" bordercolor="#ffffff" id="AutoNumber1" height="104" width="520" >
<tr>
<td class="headrow" colspan="2"  align="center" bgcolor="#004C00" width="417">
<font size="2.5" color="white"><b>ENTER BANK DETAILS<b></font>

</td>
</tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"><font size="3">Beneficiary Id </font>
</td>
<td class="rowcolor" width="328" height="24">
<input type="text" name="ben_id"  onKeyPress="if(! isNS4){if((event.keyCode < 48)||(event.keyCode>57))event.returnValue=false;}else{if( (event.which < 8)||(event.which > 8) && (event.which < 48)||(event.which >57)) return false;}" size="20" value=''></input>
</td>
</tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"> <font size="3">Bank</font></td>
<td class="rowcolor" width="328" height="24">
<select name="bname" id="bankId" onChange="hideShow()">
           <option value>--select--</option>
			<option  value="121_BHARAT KOSH">BHARAT KOSH</option>
         
</select>
</td>
</tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"> <font size="3">Demand Draft / Bharat Kosh Reference No. </font></td>
<td class="rowcolor" width="328" height="24">
<p>
<input type="text" name="ddn" id="ddn_Id" onKeyPress="if(! isNS4){if((event.keyCode < 48)||(event.keyCode>57))event.returnValue=false;}else{if( (event.which < 8)||(event.which > 8) && (event.which < 48)||(event.which >57)) return false;}" size="20">
</p>
</td>
</tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"><font size="3">Demand Draft / Bharat Kosh Reference Date</font></td>
<td class="rowcolor" width="328" height="24">
<p> 
<input type="text" name="ddate" id="ddate" placeholder="click here" size="20" readonly="true">
<!--<img name="" src="../images/CALENDAR.GIF" width="32" height="19" alt="click to get Calendar"  style="cursor:hand;" onClick="JACS.show(document.getElementById('ddate'),event);" >-->
</p></td></tr><tr>
<td class="rowcolor" width="392" height="24">
<p align="left"><font size="3">Amount</font></td>
<td class="rowcolor" width="328" height="24">
<p> 
<input type="text" name="amt" id="amnt" onKeyPress="if(! isNS4){if((event.keyCode < 48)||(event.keyCode>57))event.returnValue=false;}else{if( (event.which < 8)||(event.which > 8) && (event.which < 48)||(event.which >57)) return false;}" size="20"></p>
</td></tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"> <font size="3">Valid From</font>
</td>
<td class="rowcolor" width="328" height="24">
<input type="text" name="pdatefrom" id="pdatefrom"  placeholder="click here" size="20" readonly="true" >
<!--<img name="" src="../images/CALENDAR.GIF" width="32" height="19" alt="click to get Calendar"  style="cursor:hand;" onClick="JACS.show(document.getElementById('pdatefrom'),event);" >-->
</td>
</tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"> <font size="3">Valid To </font>
</td>
<td class="rowcolor" width="328" height="24">
<input type="text" name="pdateto" id="pdateto" size="20"  placeholder="click here" readonly="true">
<!--<img name="" src="../images/CALENDAR.GIF" width="32" height="19" alt="click to get Calendar"  style="cursor:hand;" onClick="JACS.show(document.getElementById('pdateto'),event);" >-->
</td>
</tr>
<tr>
<td class="rowcolor" width="392" height="24">
<p align="left"><font size="3">MICR No. </font></td>
<td class="rowcolor" width="328" height="24">
<p> 
<input type="text" name="micr" id="micrId" size="20"></p></td></tr>


<tr>
<td class="rowcolor" width="417" height="28" colspan="2" align="center">
<!--<input type=button name="bank"  value="Save" onClick="openChild('bank_frame.html','win2');">&nbsp;&nbsp;-->
<input type=button name="back" value="Back" onClick="move()">&nbsp;&nbsp;
<input type=button name="bank" id="bank_btn_Id" value="Save" onClick="javascript:chk(this.form, this.id);">&nbsp;&nbsp;
<input type=button name="bank_update"  id="bank_updateId" style="display:none;" value="Update" onClick="javascript:chk(this.form, this.id);">&nbsp;&nbsp;
<input type=reset name="reset" id="resetId" value="Reset">
</td>

</tr>

</table>
</div>
</body>
</html>