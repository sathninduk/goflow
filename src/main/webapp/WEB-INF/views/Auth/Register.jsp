<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-16
  Time: 05:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Register | GoFlow</title>


    <style>
        .toggle-body {
            background-color: #cccccc;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 360px;
            height: 80px;
            border-radius: 300px;
        }

        .toggle-body .btn_box {
            position: relative;
        }

        .toggle-body .btn {
            display: table;
            float: left;
            border: none;
            background: #ccc;
            padding: 15px 35px;
            color: #000000;
            border-radius: 300px;

            text-transform: uppercase;
            letter-spacing: 2px;
            font-size: 10px;
        }

        .toggle-body .btn:hover {
            background-color: transparent;
            color: transparent;
        }

        .toggle-body .moving-bg {
            width: 50%;
            height: 45px;
            z-index: 999;
            position: absolute;
            background-color: #000000;
            color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            cursor: pointer;

            text-transform: uppercase;
            letter-spacing: 2px;
            font-size: 10px;
            border-radius: 300px;
        }
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">

    <style>
        .toggle-body .btn:hover {
            color: #000000;
        }
    </style>

</head>
<body>

<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="con-mid" style="width: 100%; height: calc(100% - 60px)">
    <div class="con-mid">

        <h1 style="font-size: 24px; margin-bottom: 24px">Register</h1>

        <div class="toggle-body" style="width: 410px">
            <div class="btn_box">
                <button class="btn btn1">Rider Register</button>
                <button class="btn btn2" onclick="window.location.href='./DriverRegister'">Driver Register</button>
                <div onclick="regLink()" id="movingPart" class="moving-bg con-mid" style="left: 0;">
                    Rider Register
                </div>
            </div>
        </div>

    </div>
</div>


<!-- script -->
<script>
    $('.btn_box .btn').mouseover(function () {
        if ($(this).hasClass("btn1")) {
            $('.btn_box .moving-bg').css("left", "0%");
            $('.btn_box .moving-bg').text('Rider Register');
        }
        if ($(this).hasClass("btn2")) {
            $('.btn_box .moving-bg').css("left", "50%");
            $('.btn_box .moving-bg').text('Driver Register');
        }
    });
</script>

<script>
    function regLink() {
        if (document.getElementById("movingPart").innerText === "DRIVER REGISTER") {
            window.location.href = "./DriverRegister";
        } else {
            window.location.href = "./RiderRegister";
        }
    }
</script>

</body>
</html>
