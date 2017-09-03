/******************************************************************************
*Function Name:fnValidatecustid
*Description:Validates Customer ID
*Arguments:custid
*Returns:true if valid else returns false
******************************************************************************/
function fnvalidatecustid(custid)
{
	/*Checks if custid field is blank*/
	if(custid.length==0)
	{	
		alert("Customer Id field should not be empty");
		return false;
	}
	/*Checks if custid field is a number*/
	else if(isNaN(custid))
	{
		alert("Customer Id should be a number");
		return false;
	}
	if(custid.indexOf(".")>=0)
	{
		alert("Customer Id cannot be float.");
		return false;
	}
	if(custid.indexOf("+")>=0)
	{
		alert("Customer Id should be a number");
		return false;
	}
	if(custid.indexOf("-")>=0)
	{
		alert("Customer Id should be a number");
		return false;
	}
	else	
	{
		counter=0;
		for(i=0;i<custid.length;i++)
		{
			if(custid.charAt(i)==" ")
			{
				counter++;
			}
		}
		if(counter==custid.length)
		{
			alert("Customer Id cannot be only spaces");
			return false;
		}
		else
		{
			return true;
		}
	}
}

/******************************************************************************
*Function Name:fnvalidatedate
*Description:Validates Date
*Arguments:orderdate
*Returns:true if valid else returns false
******************************************************************************/
function fnvalidatedate(orderdate)
{
	/*Checks if date field is blank*/
	if(orderdate.length==0)
	{
		alert("Date field should not be empty");
		return false;
	}
	else
	{	
		/*Checks if length is less than 11*/
		if(orderdate.length<11)
		{
			alert("Date not valid");
			return false;
		}
		counter=0;
		
		/*Checks for spaces*/
		for(i=0;i<orderdate.length;i++)
		{
			if(orderdate.charAt(i)==" ")
			{
				counter++;
			}
		}
		if(counter==orderdate.length)
		{
			alert("Invalid date.Spaces not allowed");
			return false;
		}
		
		/*Checks if date is in DD-MON-YYYY format*/
		else if(orderdate.indexOf("-")!=2)
		{
			alert("Invalid date. Date not in given format");
			return false;
		}
		else if(orderdate.lastIndexOf("-")!=6)
		{
			alert("Invalid date. Date not in given format");
			return false;
		}
		else
		{
			
			/*Splits date into date, mon & year*/
			
			date=orderdate.substring(0,2);
			mon=orderdate.substring(3,6);
			year=orderdate.substring(7,11);
			date=parseInt(date);
			year=parseInt(year);
			
			/*Checks if year is valid*/
			
			if(year<0 && year>9999)
			{
				alert("Invalid year");
				return false;
			}
			
			/*Checks if date is valid*/
			else if(date<1 || date>31)
			{
				alert("Invalid date"+date);
				return false;
			}
			
			/*Checks if date is valid for given month*/
			
			else if(mon.toUpperCase()=="JAN" || mon.toUpperCase()=="MAR" || mon.toUpperCase()=="MAY" || mon.toUpperCase()=="JUL" || mon.toUpperCase()=="AUG" || mon.toUpperCase()=="OCT" || mon.toUpperCase()=="DEC")
			{
					if(date>31)
					{
						alert("Invalid date for month "+mon.toUpperCase());
						return false;
					}
					else
					{
						return true;
					}
			}
			else if(mon.toUpperCase()=="APR" || mon.toUpperCase()=="JUN" || mon.toUpperCase()=="SEP" || mon.toUpperCase()=="NOV")
			{
				if(date>30)
				{
					alert("Invalid date for month "+mon.toUpperCase());
					return false;
				}
				else
				{
					return true;
				}
			}
			else if(mon.toUpperCase()=="FEB")
			{
				if(year%4==0 || (year%100==0) && (year%400)==0)
				{
					if(date>29)
					{
						alert("Invalid date for month "+mon.toUpperCase()+". Leap Year");
						return false;
					}
					else
					{
						return true;
					}
				}
				else
				{
					if(date>28)
					{
						alert("Invalid date for month "+mon.toUpperCase());
						return false;
					}
					else
					{
						return true;
					}
				}
			}
			else
			{
				alert("Invalid Date");
				return false;
			}
		}
	}
}

/******************************************************************************
*Function Name:fnvalidatename
*Description:Validates Name
*Arguments:name
*Returns:true if valid else returns false
******************************************************************************/
function fnvalidatename(name)
{
	/*Checks if name field is empty*/ 
	if(name.length==0)
	{
		alert("Name field should not be empty");
		return false;
	}
	else
	{	
		/*Checks for spaces*/
		counter=0;
		for(i=0;i<name.length;i++)
		{
			if(name.charAt(i)==" ")
			{
				counter++;
			}
		}
		if(counter==name.length)
		{
			alert("Invalid name.Only spaces not allowed");
			return false;
		}
		else
		{
			/*Checks if it contains alphabets only*/
			counter=0;
			for(i=0;i<name.length;i++)
			{
				if(name.charAt(i)==" " || (name.charCodeAt(i)>=65 && name.charCodeAt(i)<=90) || (name.charCodeAt(i)>=97 && name.charCodeAt(i)<=122))
				{
					counter++;
				}
				else
				{
					counter--;
				}

			}
			if(counter==name.length)
			{
				return true;
			}
			else
			{
				alert("Invalid name.Only alphabets allowed");
				return false;
			}
		}
	}
}


/******************************************************************************
*Function Name:fnvalidateaddr
*Description:Validates Address
*Arguments:addr
*Returns:true if valid else returns false
******************************************************************************/


function fnvalidateaddr(addr)
{
	/*Checks if address field is empty*/
	if(addr.length==0)
	{
		alert("Address field should not be empty");
		return false;
	}
	else
	{
		/*Checks if address has more than 50 characters*/
		if(addr.length>50)
		{
			alert("Address field should not greater than 50 characters");
			return false;
		}
		else
		{
			/*Checks if address has only spaces*/
			counter=0;
			for(i=0;i<addr.length;i++)
			{
				if(addr.charAt(i)==" ")
				{
					counter++;
				}
			}
			if(counter==addr.length)
			{
				alert("Invalid address.Only spaces not allowed");
				return false;
			}
			else
			{
				return true;
			}
		}
	}
}

/******************************************************************************
*Function Name:fninvoice
*Description: Validates Invoice Entry and if valid displays invoice report
*Arguments:None
*Returns:None
******************************************************************************/


function fninvoice()
{


	/*Calls fnvalidatecustid*/
	custflag=fnvalidatecustid(document.forminvoice.textcust.value);
	if(custflag==false)
	{
		document.forminvoice.textcust.select();
		document.forminvoice.textcust.focus();
	}
	else
	{
		/*Calls fncheckmonth*/
		monthflag=fncheckmonth(document.forminvoice.textmon.value);
		if(monthflag==false)
		{
			document.forminvoice.textmon.select();
			document.forminvoice.textmon.focus();
		}
		else
		{
			/*Display invoice report*/	
			//location.replace("invoicereport.html");
		}
	}
	
}

/******************************************************************************
*Function Name:fncheckmonth
*Description:Validates Month
*Arguments:mon
*Returns:true if valid else returns false
******************************************************************************/

function fncheckmonth(mon)
{
		
	/*Checks if month field is empty*/
	if(mon.length==0)
	{

		alert("Invoice month should not be empty!..");
		return false;
	}
	
	/*Check if month is a number*/
	if(!isNaN(mon))
	{
		/*Checks if it is a valid month*/ 
		imon=parseInt(mon);
		if((imon>12)||(imon<1))
		{
			alert("Please enter valid month!..");
			return false;
		}
	}
	else
	{
		alert("Invoice month should be a number!..");
		return false;
	}
	
	

}


/******************************************************************************
*Function Name:fnvalidate
*Description:Validates orderid form and displays order report
*Arguments:None
*Returns: None
******************************************************************************/
	
function fnvalidate()
{
	
	/*Calls fnvalidatecustid*/
	flag=fnvalidatecustid(document.order.txtcustid.value);
	if(flag==false)
	{
		document.order.txtcustid.focus();
		document.order.txtcustid.select()
		return false;
	}
	else
	{
		/*Calls fnvalidatedate*/
		flag=fnvalidatedate(document.order.txtorderdate.value);
		if(flag==false)
		{
			document.order.txtorderdate.focus();
			document.order.txtorderdate.select();
			return false;
		}
		else
		{
			/*Calls fnvalidatename*/
			flag=fnvalidatename(document.order.txtrecname.value);
			if(flag==false)
			{
				document.order.txtrecname.focus();
				document.order.txtrecname.select();
				return false;
			}
			else
			{
				/*Calls fnvalidateaddr*/
				flag=fnvalidateaddr(document.order.txtrecaddr.value);
				if(flag==false)
				{
					document.order.txtrecaddr.focus();
					document.order.txtrecaddr.select();
					return false;
				}
				else
				{
					/*Calls fnvalidateweight*/
					flag=fnvalidateweight(document.order.txtcweight.value);
					if(flag==false)
					{
						document.order.txtcweight.focus();
						document.order.txtcweight.select();
						return false;
					}
					else
					{
						/*Calls fnvalidatedesc*/
						flag=fnvalidatedesc(document.order.txtdesc.value);
						if(flag==false)
						{
							document.order.txtdesc.focus();
							document.order.txtdesc.select();
							return false;
						}
						else
						{
							/*Displays order report*/
							return true;
						}
					}
				}
			}
		}
	}
	
}


/******************************************************************************
*Function Name:fnvalidateweight
*Description:Validates Weight
*Arguments:weight
*Returns:true if valid else returns false
******************************************************************************/

function fnvalidateweight(weight)
{
	/*Checks if weight field is empty*/
	if(weight.length==0)
	{
		alert("Weight field should not be empty");
		return false;
	}
	else
	{	/*checking for only spaces*/
		counter=0;
		for(i=0;i<weight.length;i++)
		{
			if(weight.charAt(i)==" ")
			{
				counter++;
			}
		}
		if(counter==weight.length)
		{
			alert("Weight cannot be only spaces");
			return false;
		}
	}
	
	/*Checks if weight is a number*/
	if(isNaN(weight))
	{
		alert("Weight should be a number");
		return false;
	}
	else
	{	
		/*Checks for decimal point*/
		dotpos=weight.indexOf(".");
		dotpos1=weight.lastIndexOf(".");
		if(dotpos!=dotpos1)
		{
			alert("Invalid Weight.More than 1 decimal point");
			return false;
		}
		else
			{
			/*Checks if number of digits after decimal point is 3*/
			digitsafterpt=weight.length-dotpos-1;
			if(digitsafterpt>3)
			{
				alert("Invalid Weight.More than 3 digits after decimal pt not allowed");
				return false;
			}
			else
			{
				/*Checks if weight is in range 0.000 and 5.000*/
				float=parseFloat(weight);
				if(float<=0 || float>5)
				{
					alert("Invalid Weight.Range is 0.001 to 5.000");
					return false;
				}
				else
				{
					return true;
				}
			}
		}
	}
}



/******************************************************************************
*Function Name:fnvalidatedesc
*Description:Validates Description
*Arguments:desc
*Returns:true if valid else returns false
******************************************************************************/

function fnvalidatedesc(desc)
{
	/*Checks if description is empty*/ 
	if(desc.length==0)
	{
		return true;
	}
	
	/*Checks if description length is greater than 30 characters*/
	if(desc.length>30)
	{
		alert("Description should be less than 30 characters");
		return false;
	}
	else
	{
		/*Checks if description has only spaces*/
		counter=0;
		for(i=0;i<desc.length;i++)
		{
			if(desc.charAt(i)==" ")
			{
				counter++;
			}
		}
		if(counter==desc.length)
		{
			alert("Invalid description.Only Spaces not allowed");
			return false;
		}
		
	}
}

/******************************************************************************
*Function Name:fnValidateOrderID
*Description:Validates OrderID
*Arguments:orderID
*Returns:true if valid else returns false
******************************************************************************/

function fnValidateOrderID(orderID)
{
	/*Check if orderID is a number*/
	if(!(isFinite(orderID)))
	{
		return false;
	}
	return true;
}

/******************************************************************************
*Function Name:fnValidateRemarks
*Description:Validates Remarks
*Arguments:orderID
*Returns:true if valid else returns false
******************************************************************************/

function fnValidateRemarks(remarks)
{

	/*Checks if remarks is empty*/ 
	if(remarks.length==0)
	{
		return true;
	}
	
	/*Returns false if length is greater than 30*/
	if(remarks.length>30){
		return false;
	}
	
	return true;
}



/******************************************************************************
*Function Name:fnCheckCourierDelivery
*Description:Validates Courier Delivery Form and updates courier status
*Arguments:None
*Returns:None
******************************************************************************/

function fnCheckCourierDelivery()
{
	/*Calls fnValidateOrderID*/
	orderidFlag=fnValidateOrderID(document.courierdelivery.selorderid.value);
	if(orderidFlag==false)
		{
			/*Display error message*/
			alert("OrderID field can not be empty");
			document.courierdelivery.txtdeliverydate.select();
			document.courierdelivery.txtdeliverydate.focus();
			return false;
	}
	
	/*Calls fnvalidatedate*/
	dateFlag=fnvalidatedate(document.courierdelivery.txtdeliverydate.value);
	if(dateFlag==false)
	{
		document.courierdelivery.txtdeliverydate.select();
		document.courierdelivery.txtdeliverydate.focus();
		return false;
	}
	
	/*Calls fnValidateRemarks*/
	remarksFlag=fnValidateRemarks(document.courierdelivery.txtaremarks.value);
	if(remarksFlag==false)
	{
		/*Display error message*/
		alert("Remarks can have a maximum of 30 characters");
		document.courierdelivery.txtaremarks.select();
		document.courierdelivery.txtaremarks.focus();
		return false;
	}
	
	/*Display home page after displaying success message*/
	//location.replace("home.html");
}


/******************************************************************************
*Function Name:fnValidateUserID
*Description:Validates UserId
*Arguments:userID
*Returns:true if valid else returns false
******************************************************************************/
function fnValidateUserID(userID)
{

	/*Checks if userid is empty*/ 
	if(userID.length==0)
	{
		alert("UserID field should not be empty");
		return false;
	}
	
	/*Returns false if userid has spaces only*/
	counter=0;
	for(i=0;i<userID.length;i++)
	{
		if(userID.charAt(i)==" ")
		{
			counter++;
		}
	}
	if(counter==userID.length)
	{
		alert("UserID cannot be only spaces");
		return false;
	}
	/*if((isFinite(userID))){

		alert("UserID cannot be only spaces");
		return false;

	}*/

	/*Returns false if length of userid is greater than 10*/
	if(userID.length>10)
	{
		alert("UserID can have maximum of 10 characters");
		return false;

	}
	else
	{
		return true;

	}
}

/******************************************************************************
*Function Name:fnValidatePassword
*Description:Validates password
*Arguments:password
*Returns:true if valid else returns false
******************************************************************************/
function fnValidatePassword(password)
{

	/*Checks if password is empty*/ 
	if(password.length==0)
	{
		alert("Password field should not be empty");
		return false;
	}
	/*Returns false if password has spaces only*/
	counter=0;
	for(i=0;i<password.length;i++)
	{
		if(password.charAt(i)==" ")
		{
			counter++;
		}
	}
	if(counter==password.length)
	{
		alert("Password cannot be only spaces");
		return false;
	}
	/*if(isFinite(password)){

		alert("Password cannot be only spaces");
		return false;

	}*/

	/*Returns false if length of password is greater than 10*/
	if(password.length>10)
	{
		alert("Password can have maximum of 10 characters");
		return false;

	}
	else
	{
		return true;
	}
}
/******************************************************************************
*Function Name:fnChecklogin
*Description:Validates login form and displays home page when valid
*Arguments:None
*Returns:None
******************************************************************************/

function fnChecklogin()
{
	/*Calls fnValidateUserID*/
	userIDFlag=fnValidateUserID(document.login.txtuserid.value);
	if(userIDFlag==false)
	{
		document.login.txtuserid.select();
		document.login.txtuserid.focus();
		return false;
	}
	/*Calls fnValidatePassword*/
	passwordFlag=fnValidatePassword(document.login.txtpassword.value);
	if(passwordFlag==false)
	{
		document.login.txtpassword.select();
		document.login.txtpassword.focus();
		return false;
	}
	
	/*Displays home page*/
	location.replace("home.html");

}


/******************************************************************************
*Function Name:fncustreg
*Description:Validates customer registration form and adds customer 
*Arguments:None
*Returns:None
******************************************************************************/


function fncustreg()
{		
	/*Calls fnvalidatename*/
	Custnameflag=fnvalidatename(document.form1.txtname.value);
	if(Custnameflag==false)
	{
		document.form1.txtname.select();
		document.form1.txtname.focus();
		return false;
	}
			
	/* Calls fnvalidatedate*/
	dateFlag=fnvalidatedate(document.form1.txtdate.value);
	if(dateFlag==false)
	{
		document.form1.txtdate.select();
		document.form1.txtdate.focus();
		return false;
	}
			
	/*Calls fnvalidateaddr*/
	addrFlag=fnvalidateaddr(document.form1.txtaddr.value);
	if(addrFlag==false)
	{
		document.form1.txtaddr.select();
		document.form1.txtaddr.focus();
		return false;
	}
			
	/*Calls CityValidate */
	Cityflag=CityValidate();
	if(Cityflag==false)
	{
		document.form1.txtcity.select();
		document.form1.txtcity.focus();
		return false;
	}
			
	/*Calls PinValidate*/
	Pinflag=PinValidate();
	if(Pinflag==false)
	{
		document.form1.txtpin.select();
		document.form1.txtpin.focus();
		return false;
	}
			
	/*Calls TelephoneValidate*/
	TelephoneNoflag=TelephoneValidate();
	if(TelephoneNoflag==false)
	{
		document.form1.txttelno.select();
		document.form1.txttelno.focus();
		return false;
	}
			
	/*Calls fnEmailValidate*/
	emailFlag=fnEmailValidate(document.form1.txtmail.value);
	if(emailFlag==false)
	{
		alert("Enter valid email id");
		document.form1.txtmail.select();
		document.form1.txtmail.focus();
		return false;
	}
			
	/*Displays customer output*/
	//location.replace("customeroutput.html");
}
	
/******************************************************************************
*Function Name:CityValidate
*Description:Validates City 
*Arguments:None
*Returns:None
******************************************************************************/


	
function CityValidate()
{
	City=document.form1.txtcity.value;
	
	/*Check if city field is empty*/
        if(City.length==0)
        {
        	alert("City field can not be empty");
 	 	document.form1.txtcity.focus();
	 	document.form1.txtcity.select();
	 	return false;
	}
	
	/*Check if city has only characters*/
	
	counter=0;
	for(i=0;i<City.length;i++)
	{
		if(City.charAt(i)==" ")
		{
			counter++;
		}
	}
	if(counter==City.length)
	{
		alert("City cannot be only spaces");
		return false;
	}
	if((isFinite(City)))
	{
		alert("Enter only characters for city");
		document.form1.txtcity.focus();
	 	document.form1.txtcity.select();
	 	return false;
	}
	
}

/******************************************************************************
*Function Name:PinValidate
*Description:Validates Pin 
*Arguments:None
*Returns:None
******************************************************************************/
	
function PinValidate()
{
	Pin=document.form1.txtpin.value;
	
	/*Checks if pin field is empty*/
	if(Pin.length<=0)
	{
		alert("Pin field cannot be empty");
	 	document.form1.txtpin.focus();
	 	document.form1.txtpin.select();
	 	return false;
	}
	
	/*Checks if pin field contains only numbers*/
	if((isNaN(Pin)))
	{
		alert("Enter only numbers for Pin");
		document.form1.txtpin.focus();
	 	document.form1.txtpin.select();
	 	return false;
	}
	/*Checks if pin field contains maximum 6 digits*/
	if(Pin.length>6)
	{
		alert("Pin can have maximum 6 digits");
		document.form1.txtpin.focus();
		document.form1.txtpin.select();
		return false;
	}
	
	/* check for spaces*/
	counter=0;
	
	for(i=0;i<Pin.length;i++)
	{
	
		if(Pin.charCodeAt(i) == 32)
		{
	
			counter =counter+1;
		}
	
	}
	if(counter==Pin.length)
	{
		alert("Pin should not be only spaces");
		return false;
	}
	else
	{
		return true;
	}
	
}

/******************************************************************************
*Function Name:TelephoneValidate
*Description:Validates telephone no. 
*Arguments:None
*Returns:None
******************************************************************************/

function TelephoneValidate()
{
	TelephoneNo=document.form1.txttelno.value;
	
	/* check if telephone No field is empty*/
	if(TelephoneNo.length<=0)
	{
		alert("Telephone No field should not be empty");
 	 	document.form1.txttelno.focus();
 	 	document.form1.txttelno.select();
 	 	return false;
 	}
	
	
	tel="";
	for(i=0;i<TelephoneNo.length;i++)
	{
		if(TelephoneNo.charAt(i)!=" ")
		{
			tel=tel+TelephoneNo.charAt(i);
		}
	}
	tel=parseInt(tel);
	
	/* check if telephoneno field contains only numbers*/
	counter=0;
			for(i=0;i<TelephoneNo.length;i++)
			{
				if(TelephoneNo.charAt(i)==" " || (TelephoneNo.charCodeAt(i)>=48 && TelephoneNo.charCodeAt(i)<=57))
				{
					counter++;
				}
				else
				{
					counter--;
				}

			}
			if(counter==TelephoneNo.length)
			{
				return true;
			}
			else
			{
				alert("Invalid Phone no.Only numbers allowed");
				return false;
			}
	
	
	/* checks for spaces */
	for(i=0;i<TelephoneNo.length;i++)
	{
	
		if(TelephoneNo.charCodeAt(i) == 32 )
		{
	
			counter =counter+1;
			
		}
	
	}
	if(counter==TelephoneNo.length)
	{
		alert("Telephone no should not be only spaces");
		return false;
	}
	else
	{
		return true;
	}
	if((isNaN(tel)))
	{
		alert("Enter only numbers for Telephone");
		document.form1.txttelno.focus();
		document.form1.txttelno.select();
		return false;
	}
	
	
	
}

/******************************************************************************
*Function Name:fnEmailValidate
*Description:Validates email id 
*Arguments:None
*Returns:None
******************************************************************************/
	
function fnEmailValidate()
{
	email=document.form1.txtmail.value;
	
	/* check if email field is empty */
	if(email.length==0)
	{
		return true;
	
	}
	else
	{
		/* Finding position of @ and . characters */
		num_at=email.lastIndexOf("@");
		num_dot=email.indexOf(".");
	   	counter_at=0;
		counter_dot=0;
		for(i=0;i<email.length;i++)
  	 	{
			if(email.charAt(i)=="@")
			{	
				counter_at+=1;	
			}
			if(email.charAt(i)==".")
			{
	
				counter_dot+=1;				
			}
		}
		if(num_at+1==num_dot)
		{
			return false;
		}
		if(email.length==num_dot)
		{
			return false;
		}
		
		/* checking for positions of @ and . characters*/
		if(counter_at!=1 || counter_dot==0 || num_dot<num_at || num_at<=4 || num_dot<=5)
		{	
			return false;	
		}
	
	}
	
	return true;
}
/******************************************************************************
*Function Name:fnCheckDeliveryBoy()
*Description:Validates delivery boy information form 
*Arguments:None
*Returns:None
******************************************************************************/

function fnCheckDeliveryBoy()
{
	/*Calls fnValidateEmployeeID*/
	employeeIDFlag=fnValidateEmployeeId(document.deliveryboy.txtemployeeid.value);
	if(employeeIDFlag==false)
	{
		document.deliveryboy.txtemployeeid.select();
		document.deliveryboy.txtemployeeid.focus();
		return false;
	}
	
	return true;
	/*location.replace("delivery.jsp");*/

}

/******************************************************************************
*Function Name:fnValidateEmployeeId
*Description:Validates Employee ID
*Arguments:empid
*Returns:true if valid else returns false
******************************************************************************/
function fnValidateEmployeeId(empid){
	/*Checks if empid field is blank*/
	if(empid.length==0)
	{	
		alert("Employee ID field should not be empty");
		return false;
	}
	/*Checks if empid field is a number*/
	else if(isNaN(empid))
	{
		alert("Employee ID should be a number");
		return false;
	}
	if(empid.length>4)
	{
		alert("Employee ID can have 4 digits only");
		if(empid.indexOf(".")>=0)
		{
			alert("Employee ID cannot be float");
			return false;
		}
	}
	else	
	{
		counter=0;
		for(i=0;i<empid.length;i++)
		{
			if(empid.charAt(i)==" ")
			{
				counter++;
			}
		}
		if(counter==empid.length)
		{
			alert("Employee ID cannot be only spaces");
			return false;
		}
		else
		{
			return true;
		}
	}
}
/******************************************************************************
*Function Name:fndistribution()
*Description:Validates login form and displays home page when valid
*Arguments:None
*Returns:None
******************************************************************************/

function fndistribution()
{
	/* Calls fnvalidatedate*/
	dateFlag=fnvalidatedate(document.distribution.txtdate.value);
	if(dateFlag==false)
	{
		document.distribution.txtdate.select();
		document.distribution.txtdate.focus();
		return false;
	}
	else
	{
	return true;
	}

}


