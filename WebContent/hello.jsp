<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
	<h1>Hello World!</h1>
	<script>
		/* create  */
		$(function(){
			
			$.ajax({
				url: "/site",
				type:"POST",
				dataType: "json",
				data: JSON.sringify(site),
				success: function(response){
					console.log("Create");
				}
			})
		})
	</script>
	/* delete */
	<script>
	$(function(){
		$.ajax({
			url: "/site",
			type:"DELETE",
			dataType: "json",
			data: JSON.sringify(site),
			success: function(response){
				console.log("Delete");
			}
		})
	})
	</script>
</body>
</html>