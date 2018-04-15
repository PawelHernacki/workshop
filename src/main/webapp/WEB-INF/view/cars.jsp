<%@include file="header.jsp" %>


<div class="container">
    <a class="btn btn-primary" role="button" href="/car/add">
        Add Car
    </a>
    <hr>
    <c:forEach items="${user_cars}" var="car">
        <div class="row">
            <div class="col-md-1">${car.id}</div>
            <div class="col-md-2">${car.registrationNumber}</div>
            <div class="col-md-2">${car.make}, ${car.model}</div>
            <div class="col-md-5">${car.description}</div>
            <div class="col-md-2"></div>
        </div>
        <hr>
    </c:forEach>
</div>

<%@include file="footer.jsp" %>