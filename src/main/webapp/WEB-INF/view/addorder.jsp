<%@include file="header.jsp" %>

<div class="container">
    <h2>Add service order for car </h2>
    <form:form modelAttribute="orderForm" method="post" action="/order/add">
        <div class="row">
            <div class="col-md-4">Description:</div>
            <div class="col-md-4">
                <spring:bind path="description">
                    <form:input type="textarea" path="description" name="description"></form:input>
                </spring:bind>
            </div>
        </div>
        <spring:bind path="car">
            <form:hidden path="car" name="car"></form:hidden>
        </spring:bind>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <input class="button" type="submit">
            </div>
        </div>
    </form:form>
</div>

<%@include file="footer.jsp" %>