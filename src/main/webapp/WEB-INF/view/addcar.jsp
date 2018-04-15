<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>

<div class="container">
    <h2>Add car form</h2>
    <form:form modelAttribute="carForm" method="post" action="/car/add">
        <div class="row">
            <div class="col-md-4">Registration number:</div>
            <div class="col-md-4">
                <spring:bind path="registrationNumber">
                    <form:input type="text" path="registrationNumber" name="registrationNumber"></form:input>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">Make:</div>
            <div class="col-md-4">
                <spring:bind path="make">
                    <form:input type="text" path="make" name="make"></form:input>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">Model:</div>
            <div class="col-md-4">
                <spring:bind path="model">
                    <form:input type="text" path="model" name="model"></form:input>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">Description:</div>
            <div class="col-md-4">
                <spring:bind path="description">
                    <form:input type="textarea" path="description" name="description"></form:input>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <input class="button" type="submit">
            </div>
        </div>
    </form:form>
</div>

<%@include file="footer.jsp" %>