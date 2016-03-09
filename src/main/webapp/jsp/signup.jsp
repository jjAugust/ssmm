<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html><html class=''>
<head><meta charset='UTF-8'>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath %>" />
    <script src="js/jquery.min.js"></script>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css'>
    <style class="cp-pen-styles">*
    {
        margin:0px;
        padding:0px;
    }

    body{
        background:#222526;
        position:relative;
        padding:100px;
        font-family:verdana;
        background: url('images/bg.jpg');
        background-size: cover;
        color: #999;
        color: rgba(255,255,255,0.6);
    } 



    #loginform
    {
        width:550px;
        height:auto;
        position:relative;
        margin:0 auto;
    }

    input
    {
        display:block;
        margin:0px auto 15px;
        border-radius:5px;
        background: #333333;
        width:85%;
        padding:12px 20px 12px 10px;
        border:none;
        color:#929999;                       
        box-shadow:inset 0px 1px 5px #272727;
        font-size:0.8em;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease; 
    }

    input:focus
    {
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;  
        box-shadow: 0px 0px 5px 1px #161718;
    }

    button
    {
        background: #ff5f32;
        border-radius:50%;
        border:10px solid #222526;
        font-size:0.9em;
        color:#fff;
        font-weight:bold;
        cursor:pointer;
        width:85px;
        height:85px;
        position:absolute;
        right: -42px;
        top: 54px;
        text-align:center;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    button:hover
    {
        background:#222526;
        border-color:#ff5f32;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    button i
    {
        font-size:20px;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    button:hover i
    {
        color:#ff5f32;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    *:focus{outline:none;}
    ::-webkit-input-placeholder {
        color:#929999;
    }

    :-moz-placeholder { /* Firefox 18- */
        color:#929999; 
    }

    ::-moz-placeholder {  /* Firefox 19+ */
        color:#929999;  
    }

    :-ms-input-placeholder {  
        color:#929999; 
    }

    h1
    {
        text-align:center;
        color:#fff;
        font-size:13px;
        padding:12px 0px;
    }

    #note
    {
        color:#88887a;
        font-size: 0.8em;
        text-align:left;
        padding-left:5px;
    }

    #facebook
    {
        text-align:center;
        float:left;
        background:#365195;
        padding:35px 10px 20px 10px;
        width:170px;
        height:135px; 
        border-radius:3px;
        cursor:pointer;
        box-shadow: 0px 0px 10px 2px #161718; 
        margin-right:10px;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    #facebook:hover
    {
        box-shadow: 0px 0px 0px 0px #161718;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    .fa-facebook
    {
        color:#fff;
        font-size:7em;
        display:block;
    }

    a
    {
        color:#88887a;
        text-decoration:none;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    a:hover
    {
        color:#fff;
        margin-left:5px;
        -webkit-transition:0.5s ease;
        -moz-transition:0.5s ease;
        -o-transition:0.5s ease;
        -ms-transition:0.5s ease;
        transition:0.5s ease;
    }

    #mainlogin
    {
        float:left;
        width:250px;
        height:430px;
        padding:10px 15px;
        position:relative;
        background:#555555;
        border-radius:3px;
    }

    #connect
    {
        font-weight: bold;
        color: #fff;
        font-size: 13px;
        text-align: left;
        font-family: verdana;
        padding-top:10px;
    }

    #or
    {
        position:absolute;
        left: -25px;
        top: 10px;
        background:#222222;
        text-shadow:0 2px 0px #121212;
        color:#999999;
        width:40px;
        height:40px;
        text-align:center;
        border-radius:50%;
        font-weight:bold;
        line-height:38px;
        font-size: 13px;
    }
</style></head><body>

<div id="mainlogin">
    <script type="text/javascript">
    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }
    //时间戳   
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 17);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
    </script>

    <script type="text/javascript">
    function add(){
    // document.ceshi.action="userController/addUser.do";
    // document.ceshi.submit();

    $.ajax({
        url: "userController/addUser.do", 
        data: {name:$("#name").val(), password: $("#password").val(),birthdate:$("#birthdate").val(),occupation:$("#occupation").val(),code:$("#index_code").val(),telcode:$("#telcode").val(),phone:$("#phone").val()},
        type: "GET",
        cache: false,
        dataType: "json",
        success: function (data) {  

            alert(data.message);
            if(data.message=="添加成功"){
                alert("1秒以后跳转登录页");
                setTimeout(function(){location.href="#"; },1000);
            } 
        }
    });
}

function sendtelcode(){

    var partten = /^1[3,5,8]\d{9}$/;
    var fl=false;
    if(partten.test($("#phone").val()))
    {
      $.ajax({
        url: "userController/sendSms.do", 
        data: {telcode:$("#phone").val()},
        type: "GET",
        cache: false,
        dataType: "json",
        success: function (data) {  
            alert("发送成功");
        }
    });
  }
  else
  {
    alert('请输入正确的手机号码');
 }
}


</script>
<form  action="" method="post">
    <!-- <form  name="ceshi" method="post"> -->

    <input type="text" id="name" name="name" placeholder="name" value="" required>
    <input type="text" id="phone" name="phone" placeholder="PhoneNumber" value="" required>
    <input type="password" id="password" name="password" placeholder="password" value="" required>
    <input type="date" id="birthdate" name="birthdate" placeholder="birthday" value="" required>
    <input type="text" id="occupation" name="occupation" placeholder="occupation" value="" required>
    <input type="text" id="telcode" name="telcode" placeholder="手机验证码" value="" required>
    <a onclick="sendtelcode();">点击发送验证码</a>
    <input id="index_code" name="code" type="text" placeholder="验证码" />
    <td> <img id="imgObj" alt="验证码" src="code.do" />
        <a  onclick="changeImg()">换一张</a></td></tr>
        <!-- <input style="display: none;"type="submit" id="sub" value="submit" />  -->
    </tr><br>
</form>
<button  onclick="add();"><i class="fa fa-arrow-right"></i></button>
<!-- <input type="button" value="ces" > -->
</div>
</div>
</body></html>