<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>MVC기반 온라인 쇼핑 카트 구현하기</h2>
    <div class="card">
        <div class="card-header">
            <%@ include file="../login.jsp" %>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col text-right"><button class="btn btn-sm btn-danger">장바구니 목록</button></div>
            </div>
            <h2>상품 목록</h2>
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>상품명</th>
                        <th>재고량</th>
                        <th>가격</th>
                        <th>제조회사</th>
                        <th class="text-center">구매</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="list" items="${productList}">
                    <tr>
                        <td>${list.productNumber}</td>
                        <td>${list.productName}</td>
                        <td>${list.inventory}</td>
                        <td>${list.price}</td>
                        <td>${list.manufacturer}</td>
                        <td class="text-center"><button type="submit"  class="btn btn-sm btn-primary">장바구니 담기</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-center">😂촤하!</div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

