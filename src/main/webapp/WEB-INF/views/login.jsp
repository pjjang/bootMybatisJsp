<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>

<div class="row">
        <c:choose>
            <c:when test="${!empty loginMember}">
                <div class="col-4">
                    <h4>Welcome, ${loginMember.customerName} 님</h4>
                </div>
                <div class="col-5">

                </div>
                <div class="col-3">
                    <form class="form-inline" action="/member/logout" method="post">
                        <label for="customerId">${loginMember.customerId}</label>
                        <button type="submit" class="btn btn-primary">로그아웃</button>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-4">
                    <h4>Welcome, Mini ShoppingMall</h4>
                </div>
                <div class="col-8">
                    <form class="form-inline" action="/member/login" method="post">
                        <label for="customerId">아이디:</label>
                        <input type="text" class="form-control" placeholder="이메일 아이디" id="customerId" name="customerId">
                        <label for="password">패스워드:</label>
                        <input type="password" class="form-control" placeholder="패쓰워드" id="password" name="password">
                        <button type="submit" class="btn btn-primary">로그인</button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>


</div>
