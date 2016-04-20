
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Email Search</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Email Search</a>
		</div>
	</div>
</nav>

<div class="container">
	<div class="row">
	<hr>
	<hr>
		<h2>Please enter the search query</h2>
		<form method="POST" action="search" commandName="searchQuery">
			<fieldset class="form-group">
				<label for="senderName">Sender Name</label> <input
					type="text" class="form-control" name="senderName" id="senderName"
					placeholder="Sender Name">
			</fieldset>
			<fieldset class="form-group">
				<label for="recepientName">Recepient Name</label> <input
					type="text" class="form-control" name="recepientName" id="recepientName"
					placeholder="Recepient Name">
			</fieldset>
			<fieldset class="form-group">
				<label for="datefrom">Date From:</label>
				<div class='input-group date' id='datefrom'>
                    <input type='text' name="datefrom" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
			</fieldset>
			<fieldset class="form-group">
				<label for="dateto">Date To:</label>
				<div class='input-group date' id='dateto'>
                    <input type='text' name="dateto" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
			</fieldset>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<script type="text/javascript">
            $(function () {
                $('#datefrom').datetimepicker({format: 'YYYY-MM-DD',widgetPositioning:{horizontal: 'right',vertical: 'bottom'}});
                $('#dateto').datetimepicker({format: 'YYYY-MM-DD',widgetPositioning:{horizontal: 'right',vertical: 'bottom'}});
            });
        </script>
	</div>


	<hr>
	<footer>
		<p>&copy; TextIQ 2016</p>
	</footer>
</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>



</body>
</html>