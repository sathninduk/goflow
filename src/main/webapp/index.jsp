<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="stylesheet" href="./public/css/styles_home.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body class="black-body" style="background-color: #000000; overflow: hidden;">
<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="bg-oval">
    <div class="bg-oval-1"></div>
    <div class="bg-oval-2"></div>
</div>

<div class="hero-section con-mid" style="width: 100%; height: calc(100vh - 60px); z-index: 2; position: absolute;">

    <div class="hero-div">
        <div style="display: inline-block">
            <img src="./public/images/GoFlow_White.png" alt="GoFlow Logo"
                 style="display: inline-block; width: 60px; margin-right: 15px;">
            <h1 class="hero-heading" style="color: #fff; font-size: 56px; display: inline-block">GoFlow</h1>
            <p class="hero-para">
                Optimize transport operations with a <br>comprehensive and efficient Management Platform.
            </p>
            <div class="hero-btn" style="margin-top: 50px;">
                <a href="./Login" class="btn btn-primary" style="margin-right: 15px">Login</a>
                <a href="./Register" class="btn btn-primary btn-2">Register</a>
            </div>
        </div>
        <div style="display: inline-block">
            <img src="./public/images/Hero-img.jpg" class="hero-img" alt="Hero Image">
        </div>
    </div>

</div>

</body>
</html>