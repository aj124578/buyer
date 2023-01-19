<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <style>
            .purchase_button {
                padding-top: 5px;
            }
        </style>
        <div class="purchase_button">
        <form action="/product/${product.id}/purchase" method="post">
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
                <td>${product.name}</td>
                <td>${product.price}원</td>
                <td>${product.qty}개</td>
                <td>${product.createdAtToString}</td>
            </tr>
        </table>
                    <form action="/product/{id}/purchase" method="post">
                        <input type="number" name="qty" value="0" min="0" max="${product.qty}" step="1">
                        <button type="submit">구매</button>
                    </form>
         
            </form>
        </div>
        <%@ include file="../layout/footer.jsp" %>