<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>

<div style="margin-top:100px" class="row">
    <div class="col-md-8">
        <form:form action="/user/register" modelAttribute="userForm" class="form-signin" method="post">
            <div class="row">
                <div class="col-md-5">
                    Login:
                </div>
                <div class="col-md-5">
                    <spring:bind path="username">
                        <form:input path="username" type="text" class="form-control" name="username"/>
                    </spring:bind>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5">
                    Password:
                </div>
                <div class="col-md-5">
                    <spring:bind path="password">
                        <form:input path="password" type="password" class="form-control" name="password"/>
                    </spring:bind>
                </div>
            </div>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
            <div class="row">
                <div class="col-md-3">
                    <input class="form-control" type="submit"/>
                </div>
            </div>
        </form:form>
    </div>
</div>

<%@include file="footer.jsp" %>