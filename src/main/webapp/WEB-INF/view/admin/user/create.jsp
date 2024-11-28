<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Create User</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <link rel="stylesheet" href="/css/demo.css">
        </head>

        <body>
            <div class="container">
                <form action="user" method="post" modelAttribute="user">
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-3">
                            <h1>Create new user</h1>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" placeholder="name@example.com"
                                name="email">
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-3">
                            <label for="fullname" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="fullname" name="fullName">
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-3">
                            <label for="address" class="form-label">Address</label>
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-4">
                            <label for="phone" class="form-label">Phone</label>
                            <input type="text" class="form-control" id="phone" name="phone">
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-lg-6 mb-3">
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </div>

                </form>
            </div>
        </body>

        </html>