<%@include file="header.jsp" %>

<div class="container">
    <c:forEach items="${user_list}" var="user">
        <div class="row row-line">
            <div class="col-md-2">
                    ${user.identifier}
            </div>
            <div class="col-md-5">
                    ${user.username}
            </div>
            <div class="col-md-5">
                <div>
                    <c:forEach items="${user.setOfRoles}" var="role">
                        [${role.name}]
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="footer.jsp" %>