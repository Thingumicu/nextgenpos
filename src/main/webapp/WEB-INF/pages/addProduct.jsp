<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Add Product">
    <h1>Add Product</h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddProduct">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="name">name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Valid name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="price">Price</label>
                <input type="text" class="form-control" id="price" name="price" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Valid price is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="quantity">Quantity</label>
                <input type="text" class="form-control" id="quantity" name="quantity" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Quantity is required.
                </div>
            </div>
        </div>

        <hr class="mb-4">
        <button class="btn btn-primary btn-lg " type="submit">Save</button>
    </form>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</t:pageTemplate> 