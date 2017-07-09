<%-- 
    Document   : StudentPage
    Created on : Jul 9, 2017, 3:19:15 PM
    Author     : Sanket
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Entry</title>
    </head>
    <body>
        
        <form method="post" action="NewStudentServlet">       
        
            
            <br>Name: <input type="text" name="name"><br>
          <br>  Phone Number: <input type="text" name="pnoneNo"><br>
            <br> Email: <input type="text" name="email"><br>
            <br> University: <input type="text" name="university"><br>
            <br> Room No: <input type="text" name="roomNo"><br>
            <br> Technology: <input type="text" name="tech"><br>
            <br> Status: <input type="text" name="status"><br>
            <br> Todays Date: <input type="date" name="date" id="date"><br>
            <br> <input type="submit" value="Save" name="saveButton" onclick="return callservlet();" >
        <br> <input type="submit" value="Cancel">
            
            
            
            
            
            
        </form>
        
        
         </body>
         <script type="text/javascript">
            function callservlet() 
            {
                var x = document.getElementById('date').value;
                document.getElementById("date").value = x;
                //document.forms.submit();
                //document.form1.hiddenValue.value = x; 
                
                //<input type="submit" value="Save" name="saveButton" onclick="return callservlet();" >
                
              //  document.forms[0].action = "NewStudentServlet";
            document.forms[0].submit();
            }
</html>