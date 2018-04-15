<%@include file="header.jsp" %>

<div style="margin-top:100px" class="row">
    <div class="col-md-8 black" >
        <form action="/user/login" class="form-signin" method="post">
            <div class="row">
                <div class="col-md-5">
                    Login:
                </div>
                <div class="col-md-5">
                    <input type="text" class="form-control" name="username"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5">
                    Password:
                </div>
                <div class="col-md-5">
                    <input type="password" class="form-control" name="password"/>
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="row">
                <div class="col-md-3">
                    <input class="form-control" type="submit"/>
                </div>
            </div>
        </form>
    </div>
</div>

<%@include file="footer.jsp" %>