<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Log</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editLog" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Log</h4>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>LogID</label>
                                    <input value="${detailLog.logId}" name="logId" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>AccountID</label>
                                    <input value="${detailLog.accountId}" name="accountId" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>ProductID</label>
                                    <input value="${detailLog.productId}" name="productId" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Amount</label>
                                    <input value="${detailLog.amount}" name="amount" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input value="${detailLog.address}" name="address" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Number</label>
                                    <input value="${detailLog.number}" name="number" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Date</label>
                                    <input value="${detailLog.date}" name="date" type="date" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>