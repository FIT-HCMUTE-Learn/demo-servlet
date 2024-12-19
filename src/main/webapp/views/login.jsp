<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert} text-center col-md-6 offset-md-3" role="alert" style="width: 100%">
                        ${message}
                </div>
            </c:if>
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Welcome to website!</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    <div class="icon d-flex align-items-center justify-content-center">
                        <span class="fa fa-user-o"></span>
                    </div>
                    <h3 class="text-center mb-4">Sign In</h3>
                    <form action="login" class="login-form" id="formSubmit" method="post">
                        <div class="form-group">
                            <label for="username"></label><input type="text" class="form-control rounded-left" placeholder="Username" id="username" name="username" required="">
                        </div>
                        <div class="form-group d-flex">
                            <label for="password"></label><input type="password" class="form-control rounded-left" placeholder="Password" id="password" name="password" required="">
                        </div>
                        <input type="hidden" value="login" name="action" />
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary rounded submit px-3">Login</button>
                        </div>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                <label class="checkbox-wrap checkbox-primary">Remember Me
                                    <input type="checkbox" checked>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="w-50 text-md-right">
                                <a href="#">Forgot Password</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
