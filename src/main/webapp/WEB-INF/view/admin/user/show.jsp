<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User detail ${id}</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link rel="stylesheet" href="/css/demo.css">
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-12 mx-auto">
                            <h3>User Detail with id = ${id}</h3>
                            <hr>
                            <c:if test="${not empty message}">
                                <div>${message}</div>
                            </c:if>
                            <div class="card" style="width: 50%">
                                <div class="card-header">
                                    <b>User information</b>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><b>ID:</b> ${user.id}</li>
                                    <li class="list-group-item"><b>Email:</b> ${user.email}</li>
                                    <li class="list-group-item"><b>Full Name:</b> ${user.fullName}</li>
                                    <li class="list-group-item"><b>Address:</b> ${user.address}</li>
                                    <li class="list-group-item"><b>Phone Number:</b> ${user.phone}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </body>

            </html>