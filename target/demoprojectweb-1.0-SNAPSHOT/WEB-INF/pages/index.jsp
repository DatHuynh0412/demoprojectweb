<%-- 
    Document   : index
    Created on : Mar 20, 2022, 10:06:22 PM
    Author     : huynh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="<c:url value="/" />">Travel</a>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">News <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search..." aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    <a class="btn btn-outline-success my-2 my-sm-0">Register</a> 
                    <a class="btn btn-outline-success my-2 my-sm-0" href="<c:url value="/login" />">Login</a>
                </form>
            </div>
        </nav>

        <!-- Body -->
        <div class="container">
            <h1 class="text-center text-info">TOUR LIST</h1>
            <div class="row">
                <c:forEach items="${Tour}" var = "tour">
                <div class="col-md-4 col-sm-12">
                    <div class="card">
                        <img class="card-img-top" src="${tour.image}" alt="Card image" width="250" height="300">
                        <div class="card-body">
                            <h4 class="card-title">${tour.name}</h4>
                            <p class="card-text">${tour.price}$</p>
                            <a href="#" class="btn btn-primary">See Detail</a>
                            <a href="#" class="btn btn-danger">Booking Tour</a>
                            <a href="<c:url value = "/${tour.id}/edit"/>" class="btn btn-danger">Edit</a>
                            <a href="<c:url value = "/${tour.id}/delete"/>" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                    <br>        
                </div>
                </c:forEach>
            </div>
        </div>



    </body>
</html>
