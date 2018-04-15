<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>


<div class="container">
    <a class="btn btn-primary" role="button" href="/car/add">
        Add Car
    </a>
    <c:forEach items="${user_cars}" var="car">
        <div class="row">
            <div class="col-md-1">${car.id}</div>
            <div class="col-md-2">${car.registrationNumber}</div>
            <div class="col-md-2">${car.make}, ${car.model}</div>
            <div class="col-md-5">${car.description}</div>
            <div class="col-md-2"></div>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jsp" %>