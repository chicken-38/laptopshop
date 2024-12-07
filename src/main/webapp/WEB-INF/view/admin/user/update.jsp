<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>
                    <c:if test="${not empty message}">
                        ${message}
                    </c:if>
                    <c:if test="${empty message}">
                        Update Users
                    </c:if>
                </title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link rel="stylesheet" href="/css/demo.css">
            </head>

            <body>
                <div class="container mt-5">
                    <c:if test="${not empty message}">
                        <div class="modal fade" id="notFoundModal" tabindex="-1" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5">Notification:</h1>
                                    </div>
                                    <div class="modal-body">
                                        <strong>${message}</strong>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary"
                                            data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update a user</h3>
                            <hr>
                            <form:form action="/admin/user/update" method="post" modelAttribute="user">
                                <div class="mb-3" style="display: none">
                                    <label class="form-label">ID</label>
                                    <form:input type="text" class="form-control" path="id" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <form:input type="email" class="form-control" path="email" disabled="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <form:input type="text" class="form-control" path="phone" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Full Name</label>
                                    <form:input type="text" class="form-control" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address</label>
                                    <form:input type="text" class="form-control" path="address" />
                                </div>
                                <button type="submit" class="btn btn-warning">Update</button>
                                <button type="" class="btn btn-success"
                                    onclick="window.location.href='/admin/user'">Cancel</button>
                            </form:form>
                        </div>
                    </div>
                </div>
                <script>
                    var message = '${ message }';
                    console.log(message);
                    if (message.trim() !== "") {
                        console.log(message);
                        document.addEventListener('DOMContentLoaded', (event) => { var myModal = new bootstrap.Modal(document.getElementById('notFoundModal')); myModal.show(); });
                    }
                </script>
            </body>

            </html>