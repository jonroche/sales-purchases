<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../menu/header.jsp" />
<jsp:include page="../menu/includescripts.jsp" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Your Business Solutions</title>
<meta name="keywords" content="Your Business Solutions" />
<meta name="description" content="Your Business Solutions" />
<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/style.css"/>' />

<script type='text/javascript' src='<c:url value="/resources/js/slide.js"/>'></script>

<script type="text/javascript">
	window.addEvents({
		'domready': function(){
			/* thumbnails example , div containers */
			new Slide({
						overallContainer: 'Slide_outer',
						elementScrolled: 'Slide_inner',
						thumbsContainer: 'Slide_items',		
						itemsVisible: 5,
						elemsSlide: 3,
						duration:300,
						itemsSelector: '.Slide_element',
						itemWidth: 158,
						showControls:1});
		},
		
	});

function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
</head>
<body>

<jsp:include page="../menu/menu.jsp" />

<div id="content">
<h1>Your Business Solutions</h1>
<br><br>
A Cloud IDE that facilitates developers to work online using web based tools.
WIDE is expected to become more relevant in the future of IDEs to facilitate the developers with the strength of Cloud Computing.[disputed â€“ discuss] Cloud computing is regarded to be more convenient than to download heavy tools on local machines for development purpose

<br><br>


    
    	<div id="Slide_outer">	
		<div id="Slide_inner">			
			<div id="Slide_items">
				<div class="Slide_element">

                    	<img src="<c:url value="/resources/themes/images/icons/sales.png" />" alt="Sales Management" /><br><br>
                   <strong>Sales Management</strong>
                </div>	
				<div class="Slide_element">
                    	<img src="<c:url value="/resources/themes/images/icons/purchases.png" />" alt="Purchases Management" /><br><br>
					<strong>Purchases Management</strong>
                </div>
				<div class="Slide_element">
                    	<img src="<c:url value="/resources/themes/images/icons/payments.png" />" alt="Payments Management" /><br><br>
					<strong>Payment Management</strong>
                </div>
				<div class="Slide_element">
                    	<img src="<c:url value="/resources/themes/images/icons/parties.png" />" alt="Customer, Staff and Vendor Management" /><br><br>
					<strong>Customer, Staff and Vendor Management</strong>
                </div>
				<div class="Slide_element">
                    	<img src="<c:url value="/resources/themes/images/icons/products.png" />" alt="Products Management" /><br><br>
					<strong>Product Management</strong>
                </div>
			</div>			
		</div>
	</div>
    <!-- end of product gallery -->
	
	<div class="cleaner_h30"></div>
	<div class="section_w850">
	
	<table style="border-spacing: 30px 0px;">
	<tr>
		<td><img src="<c:url value="/resources/themes/images/icons/about.png" />"/></td>
		<td style="padding-left:10px"><h2>About Your Business Solutions</h2>
			<p>XPages is a rapid web and mobile application development technology. It allows data from IBM Lotus Notes and Relational Databases to be displayed to browser clients on all platforms.
			The programming model is based on web development languages and standards including JavaScript, Ajax, Java, the Dojo Toolkit, Server-side JavaScript and JavaServer Faces. XPages uses IBM Lotus Domino, IBM's rapid application development platform, including functionality such as the document-oriented database.
		</p>
		</td>
	</tr>
	</table>	
    	
  </div>
    
    <div class="cleaner_h30"></div>
        
        <div class="section_w210 margin_r_15">
        	<div class="rounded_top"><span></span></div>
            
			<div class="sub_content">
                <img src="<c:url value="/resources/themes/images/icons/tutorials.png" />"/>
                <h2>Tutorials</h2>              
                <p>Learn the basics about YBS by running the hands-on tutorials.</p>
                <br>
                
                
                                
            </div>
            
           <div class="rounded_bottom"><span></span></div>       
      </div>
	  
	   <div class="section_w210 margin_r_15">
        	<div class="rounded_top"><span></span></div>
            
			<div class="sub_content">
                <img src="<c:url value="/resources/themes/images/icons/videos.png" />"/>
                <h2> Videos</h2>              
                <p>Learn the basics about YBS viewing videos found on the YBS YouTube channel.</p>
                
             
                
                                
            </div>
            
           <div class="rounded_bottom"><span></span></div>       
      </div>
	  
	   <div class="section_w210 margin_r_15">
        	<div class="rounded_top"><span></span></div>
            
			<div class="sub_content">
                <img src="<c:url value="/resources/themes/images/icons/cheatsheets.png" />"/>
                <h2>Quick Guides</h2>
            
                <p>View YBS quick reference guides to the YBS application.</p>
                <br>
                
                
                                
            </div>
            
           <div class="rounded_bottom"><span></span></div>       
      </div>
	  
	   <div class="section_w210 margin_r_15">
        	<div class="rounded_top"><span></span></div>
            
			<div class="sub_content">
                <img src="<c:url value="/resources/themes/images/icons/howto.png" />"/>
                <h2>How-to articles</h2>
              
                <p>Learn more advanced features from online how-to articles.</p>
                <br>
                
                
                                
            </div>
            
           <div class="rounded_bottom"><span></span></div>       
      </div>
    
    </div> <!-- end of a section_w940 --> 
    
    <div class="cleaner"></div>
    
</body>
</html>