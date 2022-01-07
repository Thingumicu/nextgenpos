<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Products">
    <h1>Products</h1>
    <form method="POST" action="${pageContext.request.contextPath}/ProductToCart"> 

        <button class="btn btn-danger" type="submit">AddToCart</button>
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

            <c:forEach var="product" items="${products}" varStatus="status">


            </div>
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
                    <input type="text" class="form-control" id="q" name="q" placeholder="" value="0" required>
                </div>

            </div>
        </c:forEach>
    </form>
    cart :
   
   
   <c:forEach var="name" items="${invoices}" varStatus="status">
        ${name}  
        <br>
       
    </c:forEach>
        
     <c:forEach var="qq" items="${qt}" varStatus="status">
         ${qq}
         <br>
        
    </c:forEach>
     </form>
</t:pageTemplate>