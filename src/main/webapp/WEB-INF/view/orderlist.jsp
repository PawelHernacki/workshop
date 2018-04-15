<%@include file="header.jsp" %>

<div class="container">
    <c:forEach items="${orders_list}" var="order">
        <div class="row row-line">
            <div class="col-md-2">
                    ${order.id}
            </div>
            <div class="col-md-2">
                    ${order.dateSubmitted}
            </div>
            <div class="col-md-4">
                    ${order.description}
            </div>
            <div class="col-md-1">
                    ${order.completed}
            </div>
            <div class="col-md-5">
                ${order.car.registrationNumber}
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="footer.jsp" %>