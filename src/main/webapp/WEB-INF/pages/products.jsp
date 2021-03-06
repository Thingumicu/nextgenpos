<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Products">
    <h1>Products</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Products"> 
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddProduct" role="button">Add product</a>
        <button class="btn btn-danger" type="submit">Delete Products </button>
 <div class="row">
            <div class="col-md">

            </div>
            <div class="col-md-2"> 
                <label > Name</label>
            </div>
            <div class="col-md-2">
                <label > Price</label>
            </div>
            <div class="col-md-2">
                <label > Quantity</label>
            </div>
            <div class="col-md-2">

            </div>
        <c:forEach var="product" items="${products}" varStatus="status">
            <div class="row">
                <div class="col-md"> 
                    <input type="checkbox" name="product_ids" value="${product.id}"/> 
                </div>
                <div class="col-md-2">
                    ${product.name}
                </div>
                <div class="col-md-2">
                    ${product.price}
                </div>
                <div class="col-md-2">
                    ${product.quantity}
                </div>

                <div class="col-md-2">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditProduct?id=${product.id}" role="button">Edit product</a> 
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate>