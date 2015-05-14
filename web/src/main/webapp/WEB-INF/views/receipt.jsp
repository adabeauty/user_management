<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>List of Users</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="../lib/css/bootstrap.min.css" />
    </head>
    <body>
        <Receipt name="${receipt.name}" printDate="${receipt.printDate}" storeName="${receipt.storeName}">

            <ItemsInCart>
                <c:forEach var="cartItem" items="${receipt.itemsInCart}">
                    <Item>
                        <Name>${cartItem.name}</Name>
                        <Count>${cartItem.count}</Count>
                        <CountUnit>${cartItem.countUnit}</CountUnit>
                        <Price>${cartItem.price}</Price>
                        <CurrencyUnit>元</CurrencyUnit>
                        <SubTotal>${cacartItem.subtotal}</SubTotal>
                    </Item>
                </c:forEach>
            </ItemsInCart>
            <Presents>
                <c:forEach var="present" items="${receipt.presents}">
                    <Item>
                        <Name>${present.name}</Name>
                        <Count>${present.count}</Count>
                        <CountUnit>${present.countUnit}</CountUnit>
                    </Item>
                </c:forEach>
            </Presents>
            <Total>
                <Price>${receipt.total.total}</Price>
                <Saved>${receipt.total.saveMoney}</Saved>
                <CurrencyUnit>元</CurrencyUnit>
            </Total>
        </Receipt>
    </body>
</html>