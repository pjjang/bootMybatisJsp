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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h2>MVC기반 온라인 쇼핑 카트 구현하기</h2>
    <div class="card">
        <div class="card-header">
            <%@ include file="../login.jsp" %>
        </div>
        <div class="card-body">
            <c:if test="${!empty loginMember}">
                <div class="row">
                    <div class="col text-right"><button type="button" class="btn btn-sm btn-danger" onclick="goOrder('${loginMember.customerId}')">주문하기</button></div>
                </div>
            </c:if>
            <h2>상품 목록</h2>
            <table class="table table-bordered table-hover">
                <thead>
                <tr class="text-center">
                    <th>제품명</th>
                    <th>수량</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>주문취소</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="list" items="${cartList}">
                    <tr>
                        <td>${list.productName}</td>
                        <td class="text-right">${list.inventory}</td>
                        <td class="text-right">${list.price}</td>
                        <td>${list.amount}</td>
                        <td class="text-center"><button type="submit" class="btn btn-sm btn-primary" onclick="orderCancel(${list.orderNumber}, '${loginMember.customerId}')"><i class="bi bi-cart"></i></button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-center">Mini ShoppingMall</div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function orderCancel(productNumber, customerId) {

        if(${empty loginMember}) {
            alert("로그인을 하세요.");
            document.querySelector("#customerId").focus();
            return false;
        }

        let params = {
            customerId : customerId,
            productNumber : productNumber
        };


        $.ajax({
            url: '/shopping/cartAdd',
            method: 'POST',
            data: params,
            success: function(result) {
                console.log(result);
                if(result > 0) {
                    alert("상품이 장바구니에 담겼습니다.");
                }
            },
            error: function(result) {
                if(result == 0) {
                    alert("장바구니 담기에 실패하였습니다 관리자에 문의 주세요.")
                }
            }
        });
    }

    function goCartList(customerId) {

        let params = {
            customerId : customerId,
        };

        $.ajax({
            url: '/shopping/cartList',
            data: params,
            method: 'GET',
            success: function(result) {
                location.href="/shopping/cartList";
                alert("장바구니 목록");
            },
            error: function() {
                alert("장바구니 목록을 불러오는 도중 오류가 발생했습니다.");
            }
        });
    }
</script>
</body>
</html>

