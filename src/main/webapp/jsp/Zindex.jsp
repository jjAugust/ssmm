<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- END OF DON'T TOUCH -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" />
<!-- Website Title -->

<!-- END OF Website Title -->

<!--  Website description - Change the 'content' section to whatever you want -->
<meta name="description" content="Replace this text with a summary of your website. i.e. John Smith - chinese teacher and Photographer - Welcome to my portfolio website! Here you will find all of my latest work. Enjoy!">
<!-- END OF Website description -->

<!-- DON'T TOUCH THIS SECTION -->
<link rel="stylesheet" type="text/css" href="css/zyqindex/style.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/jquery.carouFredSel-5.5.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script> 
<script type="text/javascript" src="js/scripts.js"></script> 
<script type="text/javascript" src="js/angular.js"></script> 
<script type="text/javascript">

function getQueryString(name) { 
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
var r = window.location.search.substr(1).match(reg); 
if (r != null) return unescape(r[2]); return null; 
} 

</script>
<script>
(function() {
var jp = getQueryString("id");
var id = '<%=session.getAttribute("id")%>';
     var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("/dataController/getinfo.do?id="+id)
    .success(function(response) {$scope.names = response.data;});
});
})();

</script>
</head>
<!-- END OF DON'T TOUCH -->
<title ></title>
<body ng-app="myApp" ng-controller="customersCtrl">
<div class="wrapper">
    <div id="top">
        <div id="logo">
            <img id="logoimage" src="images/logo.png" alt="logo">   <!-- Logo image -->
            <h1 id="logotitle">{{names.sTitle}}</h1>    <!-- Logo text -->
        </div><!--/logo-->
    
        <nav>   <!-- Navigation Start -->
            <ul>
                <li><a href="#top">HOME</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#work">Work</a></li>
                <li><a href="#footer">Contact</a></li>
            </ul>      
        </nav>  <!-- Navigation End -->
    </div><!--/top-->
    
    
    <hr/><!-- Horizontal Line -->
    
    
    <header>    <!-- Header Title Start -->
        <h1><img  src="images/logo.png" alt="logo">&nbsp;&nbsp; {{names.title}}&nbsp;&nbsp;<img src="images/logo.png" alt="logo"></h1>
        <h2>&ndash; {{names.career}} &ndash;</h2>
    </header>   <!-- Header Title End -->
    <section id="slideshow">    <!-- Slideshow Start -->
        <div class="html_carousel">
            <div id="slider">
            
                <div class="slide">
                    <img src="images/slideshow/sliderimage1.jpg" width="3000" height="783" alt="image 1"/><!-- Replace these images with your own but make sure they are 3000px wide and 783px high or the same ration -->
                </div><!--/slide-->
                
                <div class="slide">
                    <img src="images/slideshow/sliderimage2.jpg" width="3000" height="783" alt="image 2"/><!-- Replace these images with your own but make sure they are 3000px wide and 783px high or the same ration -->
                </div><!--/slide-->
                
                <div class="slide">
                    <img src="images/slideshow/sliderimage3.jpg" width="3000" height="783" alt="image 3"/><!-- Replace these images with your own but make sure they are 3000px wide and 783px high or the same ration -->
                </div><!--/slide-->
                
            </div><!--/slider-->
            <div class="clearfix"></div>
        </div><!--/html_carousel-->
    </section>  <!-- Slideshow End -->
    
    
    <aside id="about" class=" left"> <!-- Text Section Start -->
        <h3>about me</h3><!-- Replace all text with what you want -->
        <p>{{names.abme}}</p>
    </aside>
    <aside class="right">
        <h3>my work</h3>
        <p>{{names.mywk}}</p>
    </aside>
    <div class="clearfix"></div> <!-- Text Section End -->
    
    
    <section id="work"> <!-- Work Links Section Start -->
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item.png" alt="image 1"></a><!-- Image must be 400px by 300px -->
            <h3>Skies Of Spain</h3><!--Title-->
            <p>photography</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/zyq.jsp"><img src="images/work/thumbs/item2.png" alt="image 2"></a><!-- Image must be 400px by 300px -->
            <h3>Beautiful Bahrain</h3><!--Title-->
            <p>photography</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item3.png" alt="image 3"></a><!-- Image must be 400px by 300px -->
            <h3>Wild Stripes</h3><!--Title-->
            <p>photo manipulation</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item4.png" alt="image 4"></a><!-- Image must be 400px by 300px -->
            <h3>Lazy Days</h3><!--Title-->
            <p>photo manipulation</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item5.png" alt="image 5"></a><!-- Image must be 400px by 300px -->
            <h3>Trapped</h3><!--Title-->
            <p>photography</p><!--Category-->
        </div><!--/item-->
        
            <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item6.png" alt="image 6"></a><!-- Image must be 400px by 300px -->
            <h3>Quad-Core</h3><!--Title-->
            <p>photography</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item7.png" alt="image 7"></a><!-- Image must be 400px by 300px -->
            <h3>Retro Blast</h3><!--Title-->
            <p>illustration</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item8.png" alt="image 8"></a><!-- Image must be 400px by 300px -->
            <h3>Gates Of The Sun</h3><!--Title-->
            <p>photography</p><!--Category-->
        </div><!--/item-->
        
        <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item9.png" alt="image 9"></a><!-- Image must be 400px by 300px -->
            <h3>Winter Touch</h3><!--Title-->
            <p>photography</p><!--Category-->
        </div><!--/item-->
        
         <div class="item">
            <a href="jsp/work-template.jsp"><img src="images/work/thumbs/item10.png" alt="image 10"></a><!-- Image must be 400px by 300px -->
            <h3>Burn</h3><!--Title-->
            <p>photo manipulation</p><!--Category-->
        </div><!--/item-->
        
        <div class="clearfix"></div>
    </section> <!-- Work Links Section End -->
    
    
    <section id="bottom"> <!-- Last Words Section Start -->
        <h3>Thanks for looking at my  website!</h3>
    </section><!-- Last Words Section End-->
</div>

<!-- TO MAKE THE PHP FORM WORK, ALL YOU NEED TO DO IS OPEN UP THE FILE CALLED 'submitemail.php' AND CHANGE WHERE IT SAYS 'your email goes here' -->

<!-- DON'T TOUCH THIS SECTION -->

<footer id="footer">
    <div class="wrapper">
        <section class="left">
        <h4>Contact</h4>
            <div id="formwrap">
                <form method="post" id="submitform" action="submitemail.php" >
                            <input type="text" class="formstyle" title="Name" name="name" />
                            <input type="text" class="formstyle" title="Email" name="email" />
                            <textarea name="message" title="Message"></textarea>
                            <input class="formstyletwo" type="submit" value="Send">  
                </form>
            </div>
            <div id="error"></div>
        </section>

<!-- DON'T TOUCH THIS SECTION END -->        
        
        <section class="right social"> <!-- Social Icons Start -->
        <a href="jsp/zyqindex.jsp?id=15"><img class="icon" src="images/icons/google.png" width="32" height="32" alt="google"></a><!-- Replace with any 32px x 32px icons -->
        <a href="jsp/zyqindex.jsp?id=15"><img class="icon" src="images/icons/youtube.png" width="32" height="32" alt="youtube"></a><!-- Replace with any 32px x 32px icons -->
        <a href="jsp/zyqindex.jsp?id=15"><img class="icon" src="images/icons/facebook.png" width="32" height="32" alt="facebook"></a><!-- Replace with any 32px x 32px icons -->
        <a href="jsp/zyqindex.jsp?id=15"><img class="icon" src="images/icons/twitter.png" width="32" height="32" alt="twitter"></a><!-- Replace with any 32px x 32px icons -->
        </section> <!-- Social Icons End -->
        <p>lets get social - </p>
        </section> <!-- Social Icons End -->
    </div>
    <div class="clearfix"></div>
</footer>

<!-- SLIDESHOW SCRIPT START -->
<script type="text/javascript">
$("#slider").carouFredSel({
    responsive  : true,
    scroll      : {
        fx          : "crossfade",
        easing      : "swing",
        duration    : 1000,
        
    },
    items       : {
        visible     : 1,
        height      : "27%"
    }
});
</script>
</body>
</html>

