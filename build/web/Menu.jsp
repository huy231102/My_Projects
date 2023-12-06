<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">haudaybatsen</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${acc.isAdmin==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="managerAccount">Manager Account</a>
                    </li>
                </c:if>
                <c:if test="${acc.isSell==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="managerLog">Log</a>
                    </li>
                </c:if>
                <c:if test="${acc!=null}">
                    <h3 style="color: white">Hello ${acc.user}</h3>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="changePass">Change Password</a>
                    </li>
                </c:if>
                <c:if test="${acc==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="showCart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">${size}</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <img class="banner" src="img\Banner_2.jpg" alt="Banner">
        <br/>
        <br/>
        <br/>
        <h1 class="jumbotron-heading">Tổng kho dây bát sen</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm dây,bát nhập trực tiếp từ Trung Quốc</p>
    </div>
</section>
