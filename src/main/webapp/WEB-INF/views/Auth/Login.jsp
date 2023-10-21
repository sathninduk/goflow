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
    <title>GoFlow | Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
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

</head>
<body>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="con-mid" style="width: 100%; height: calc(100% - 60px)">
    <div class="con-mid">

        <h1 style="font-size: 24px; margin-bottom: 24px">Login</h1>

        <div class="toggle-body">
            <div class="btn_box login-selector">
                <button class="btn btn1">Rider Login</button>
                <button class="btn btn2">Driver Login</button>
                <div onclick="loginLink()" id="movingPart" class="moving-bg con-mid" style="left: 0;">
                    Rider Login
                </div>
            </div>
        </div>

    </div>
</div>


<!-- script -->
<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script>
    $('.btn_box .btn').mouseover(function () {
        if ($(this).hasClass("btn1")) {
            $('.btn_box .moving-bg').css("left", "0%");
            $('.btn_box .moving-bg').text('Rider Login');
        }
        if ($(this).hasClass("btn2")) {
            $('.btn_box .moving-bg').css("left", "50%");
            $('.btn_box .moving-bg').text('Driver Login');
        }
    });
</script>

<script>
    function loginLink() {
        if (document.getElementById("movingPart").innerText === "DRIVER LOGIN") {
            window.location.href = "./DriverLogin";
        } else {
            window.location.href = "./RiderLogin";
        }
    }
</script>

</body>
</html>
