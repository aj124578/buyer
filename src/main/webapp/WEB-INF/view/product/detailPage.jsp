<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
    <style>
    .purchase_button{
        padding-top: 5px;
    }
    </style>
        <h1>상품 상세 페이지</h1>
        <hr />
        
        <table border="1">
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>가격</th>
                <th>재고</th>
                <th>등록일</th>
            </tr>
            
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.qty}</td>
                <td>${product.createdAt}</td>
            </tr>
        </table>
        
        <div class="purchase_button">
        <form action="/product/${product.id}/purchaseForm" method="get">
            <button type="submit">구매</button>
        </form>
        </div>
        <%@ include file="../layout/footer.jsp" %>