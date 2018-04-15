<html>
<head>
    <link rel="stylesheet" href="../../../resources/static/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/listusers">Users</a>
                </li>
            </ul>
            <nav class="my-2 my-md-0 mr-md-3">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/user/register">Register</a>
                    </li>
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name == null}">
                            <li class="nav-item active">
                                <a class="nav-link" href="/user/login">Login</a>
                            </li>
                        </c:when>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item active">
                                <form id="logoutForm" method="POST" action="/logout">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                </form>
                                <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
                            </li>
                        </c:when>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </nav>
</header>
<main role="main" style="margin: 0px">
    <div style="margin-top:100px;" class="mainContainer">