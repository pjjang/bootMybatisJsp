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
            <c:if test="${not empty sessionScope.loginMember}">
                <div class="row">
                    <div class="col text-right"><button type="button" class="btn btn-sm btn-danger" onclick="goOrder('${loginMember.customerId}')">주문하기</button></div>
                </div>
            </c:if>
            <h2>장바구니 목록</h2>
            <table class="table table-bordered table-hover">
                <thead>
                <tr class="text-center">
                    <th>제품명</th>
                    <th>단가</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="list" items="${cartList}">
                    <tr>
                        <td>${list.productName}<input type="hidden" name="orderNumber" value="${list.orderNumber}"></td>
                        <td class="text-right formattedAmount" id="price${list.productNumber}">${list.price}</td>
                        <td>
                            <input type="number" id="quantity${list.productNumber}" name="quantity" min="1" max="999" class="form-control" value="${list.quantity}"
                                   oninput="validateInput(event);" onchange="modifyQuantity('${loginMember.customerId}', ${list.productNumber});">
                        </td>
                        <th class="text-right formattedAmount" id="buyPrice${list.productNumber}">${list.price * list.quantity}</th>
                        <td class="text-center">
                            <button type="submit" class="btn btn-sm btn-primary" onclick="cartCancel(${list.orderNumber}, '${loginMember.customerId}')">
                                <i class="bi bi-trash"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                        <tr>
                            <td colspan="3">총 구매 금액</td>
                            <td colspan="2" id="totalPrice"></td>
                        </tr>
                </tbody>
            </table>
            <div class="row">
                <div class="col text-right"><button type="button" onclick="location.href='/shopping'" class="btn btn-sm btn-primary">쇼핑 계속하기</button></div>
            </div>
        </div>
        <div class="card-footer text-center">Mini ShoppingMall</div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function validateInput(event) {
        var input = event.target;
        // 최대 3자리 숫자만 허용
        if (input.value.length > 3) {
            input.value = input.value.slice(0, 3);
        }
    }

    function cartCancel(orderNumber, customerId) {

        if(${empty loginMember}) {
            alert("로그인을 하세요.");
            document.querySelector("#customerId").focus();
            return false;
        }

        let params = {
            customerId : customerId,
            orderNumber : orderNumber
        };


        $.ajax({
            url: '/shopping/cartCancel',
            method: 'POST',
            data: params,
            success: function(result) {
                if(result > 0) {
                    alert("해당 상품이 장바구니에서 삭제되었습니다.");
                    location.href="/shopping/cartList?customerId="+customerId;
                }
            },
            error: function(result) {
                if(result == 0) {
                    alert("장바구니 담기에 실패하였습니다 관리자에 문의 주세요.")
                }
            }
        });
    }

    function calculateTotalPrice() {
        let totalPrice = 0;
        document.querySelectorAll("tbody tr").forEach(function(row) {
            let priceCell = row.querySelector("td:nth-child(2)");
            let quantityCell = row.querySelector("input[name='quantity']");

            if (priceCell && quantityCell) {
                let price = parseFloat(priceCell.textContent.replace(/[^0-9.]/g, ''));
                let quantity = parseInt(quantityCell.value);
                if (!isNaN(price) && !isNaN(quantity)) {
                    totalPrice += price * quantity;
                }
            }
        });

        let totalPriceCell = document.getElementById("totalPrice");

        if (totalPriceCell) {
            totalPriceCell.textContent = totalPrice.toLocaleString('ko-KR') + '원';
        }
    }

    function modifyQuantity(customerId, productNumber) {

        let quantity = $("#quantity" + productNumber).val();


        let params = {
          customerId : customerId,
          productNumber : productNumber,
          quantity : quantity
        };

        calculateTotalPrice();

        //update 적용
        $.ajax({
            url: "/shopping/quantityUpdate",
            method: "POST",
            data: params,
            success: function(result) {
                if(result > 0) {
                    location.href="/shopping/cartList?customerId=" + customerId;
                }
            },
            error:function() {
                if(result == 0) {
                    alert("수량 변경에 실패하였습니다.");
                }
            }
        });
    }

    function goOrder(customerId) {
        // 모든 orderNumber 값을 수집
        let orderNumbers = [];
        document.querySelectorAll("input[name='orderNumber']").forEach(function(input) {
            orderNumbers.push(input.value);
        });

        let params = {
            customerId: customerId,
            orderNumbers: orderNumbers,
            completeNumber: orderNumbers[0]
        };

        $.ajax({
            url: "/shopping/orderComplete",
            method: "POST",
            data: params,
            traditional: true, // 배열을 전송할 때 사용
            success: function(result) {
                console.log(result);
                if (result.sessionExpired) {
                    alert("세션이 만료되었습니다. 로그인 페이지로 이동합니다.");
                    location.href = "/member/login?sessionExpired=true";
                } else if (result.result > 0) {
                    alert("주문이 완료되었습니다.");
                    location.href = "/shopping";
                } else {
                    alert("주문이 실패하였습니다.");
                }
            },
            error: function(xhr, status, error) {
                if (xhr.status === 401) {
                    alert("세션이 만료되었습니다. 로그인 페이지로 이동합니다.");
                    location.href = "/member/login?sessionExpired=true";
                } else {
                    console.error("AJAX Error: ", status, error);
                    alert("서버 요청 중 오류가 발생하였습니다.");
                }
            }
        });
    }

    //단순 자바스크립트만으로 수량 변경이 이루어질경우
    function updateFormattedAmount() {
        document.querySelectorAll('.formattedAmount').forEach(function(cell) {
            let amount = parseFloat(cell.textContent.replace(/[^\d.-]/g, ''));
            if (!isNaN(amount)) {
                cell.textContent = amount.toLocaleString('ko-KR') + '원';
            }
        });
    }

    //단순 자바스크립트만으로 수량 변경이 이루어질경우
     document.addEventListener("DOMContentLoaded", function() {
         calculateTotalPrice(); // 페이지 로드 시 총 금액 계산
         updateFormattedAmount();
     });
</script>
</body>
</html>

