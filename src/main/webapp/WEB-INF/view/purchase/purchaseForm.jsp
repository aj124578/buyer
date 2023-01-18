<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
    <style>
    .purchase_button{
        padding-top: 5px;
    }

    .purchase_confirmation_button{
        display: flex;
    }
    </style>
        <h1>상품 구매 페이지</h1>
        <hr />

        <div class="purchase_confirmation_button">
        <form action="" method="post">
            <input type="number" name="purchase">
        </form>
        <button type="submit">구매 확정</button>
        </div>

        <div class="purchase_button">
        <form action="/product/${product.id}/purchaseForm" method="get">
            <button type="submit">구매</button>
        </form>
        </div>
        <%@ include file="../layout/footer.jsp" %>    
 