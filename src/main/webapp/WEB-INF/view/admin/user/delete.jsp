<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard - Hỏi Dân IT</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Users</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item"><a href="/admin/user">Users</a></li>
                                    <li class="breadcrumb-item active">Delete</li>
                                </ol>
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
                                    <div class="col-6 mx-auto">
                                        <h3>Delete user with id = ${id}</h3>
                                        <hr>
                                        <c:if test="${not empty message}">
                                            <div>${message}</div>
                                        </c:if>
                                        <div class="alert alert-danger" role="alert">
                                            Are you sure to delete user with id = ${user.id}
                                        </div>
                                        <form:form action="/admin/user/delete" method="post" modelAttribute="user">
                                            <div class="mb-3 d-none">
                                                <label class="form-label">Id</label>
                                                <form:input type="text" class="form-control" path="id" />
                                            </div>
                                            <button type="submit" class="btn btn-danger">Delete</button>
                                            <button class="btn btn-primary" type="button"
                                                onclick="window.location.href='/admin/user'">Cancel</button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/script.js"></script>
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