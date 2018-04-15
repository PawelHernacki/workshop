<%@include file="header.jsp" %>


<div class="container">
    <a class="btn btn-primary" role="button" href="/car/add">
        Add Car
    </a>
    <hr>
    <c:forEach items="${user_cars}" var="car">
        <div class="row row-line">
            <div class="col-md-1">${car.id}</div>
            <div class="col-md-2">${car.registrationNumber}</div>
            <div class="col-md-2">${car.make}, ${car.model}</div>
            <div class="col-md-5">${car.description}</div>
            <div class="col-md-2">
                <a class="icon-button" role="button" href="/order/add?carid=${car.id}">
                    <i class="fas fa-paper-plane fa-2x"></i>
                </a>
                <a class="icon-button" role="button" href="/car/remove?carid=${car.id}">
                    <i class="far fa-trash-alt fa-2x"></i>
                </a>
            </div>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jsp" %>