<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">NextGenPOS</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
              <a class="nav-link active ${pageContext.request.requestURI eq '/NextgenPOS/about.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About</a>
          </li>
          <li class="nav-item ${activePage eq 'Products' ? 'active' : ''}">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/Products">Products</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled">Disabled</a>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
          <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/Login">Login</a>
        </form>
      </div>
    </div>
  </nav>