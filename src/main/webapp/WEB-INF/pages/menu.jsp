<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<div class="container">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark" >
        <a class="navbar-brand" href="${pageContext.request.contextPath}">POS System</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class="nav-item ${activePage eq 'Products' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Products">Products</a>
                </li>
                <li class="nav-item ${activePage eq 'Users' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users</a>
                </li>
                 <li class="nav-item ${activePage eq 'ProductToCart' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ProductToCart">Cart</a>
                </li>
                <li class="nav-item">
              <a class="nav-link active ${pageContext.request.requestURI eq '/NextgenPOS/about.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About</a>
          </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item ">

                    <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
