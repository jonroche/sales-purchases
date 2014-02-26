<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../menu/header.jsp" />
<jsp:include page="../menu/includescripts.jsp" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Your Business Solutions</title>
<meta name="keywords" content="Your Business Solutions" />
<meta name="description" content="Your Business Solutions" />
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/css/style.css"/>' />

<script type='text/javascript'
	src='<c:url value="/resources/js/slide.js"/>'></script>

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
		<br>
		<br>
		<p align="justify">
			Based on the revolutionary new Service Oriented Software as a SOA
			(SOSaaSOA) architecture, Your Business Solutions is ready to meet all
			your company's business needs. Providing an a-la-carte menu of
			individual business processes, Your Business Solutions is tailored to
			meet the precise needs of your business. Choose from Customer, Product, 
			Payment, Sales and Purchase Management, and only pay for the services that
			you need. With more services coming in the near future, now is the time 
			to move to Your Business Solutions.
		</p>
		<br>
		<br>



		<div id="Slide_outer">
			<div id="Slide_inner">
				<div id="Slide_items">
					<div class="Slide_element">

						<img
							src="<c:url value="/resources/themes/images/icons/sales.png" />"
							alt="Sales Management" /><br>
						<br> <strong>Sales Management</strong>
					</div>
					<div class="Slide_element">
						<img
							src="<c:url value="/resources/themes/images/icons/purchases.png" />"
							alt="Purchases Management" /><br>
						<br> <strong>Purchases Management</strong>
					</div>
					<div class="Slide_element">
						<img
							src="<c:url value="/resources/themes/images/icons/payments.png" />"
							alt="Payments Management" /><br>
						<br> <strong>Payment Management</strong>
					</div>
					<div class="Slide_element">
						<img
							src="<c:url value="/resources/themes/images/icons/parties.png" />"
							alt="Customer, Staff and Vendor Management" /><br>
						<br> <strong>Customer, Staff and Vendor Management</strong>
					</div>
					<div class="Slide_element">
						<img
							src="<c:url value="/resources/themes/images/icons/products.png" />"
							alt="Products Management" /><br>
						<br> <strong>Product Management</strong>
					</div>
				</div>
			</div>
		</div>
		<!-- end of product gallery -->

		<div class="cleaner_h30"></div>
		<div class="section_w850">

			<table style="border-spacing: 30px 0px;">
				<tr>
					<td><img
						src="<c:url value="/resources/themes/images/icons/about.png" />" /></td>
					<td style="padding-left: 20px"><h2>About Your Business
							Solutions</h2>
						<p align="justify">
						Unlike many competitors' SaaS offerings which provide a "take it or
						leave it" approach to deploying their enterprise solutions in the 
						cloud, Your Business Solutions offers 
						business processes as individual services on a subscription basis, thus 
						greatly reducing the cost of moving to the cloud for small and medium
						sized enterprises. 
						</p></td>
				</tr>
			</table>

		</div>

		<div class="cleaner_h30"></div>

		<div class="section_w210 margin_r_15">
			<div class="rounded_top">
				<span></span>
			</div>

			<div class="sub_content">
				<img
					src="<c:url value="/resources/themes/images/icons/tutorials.png" />" />
				<h2>Tutorials</h2>
				<p align="justify">Learn the basics about YBS by running the hands-on tutorials.</p>
				<br>
			</div>

			<div class="rounded_bottom">
				<span></span>
			</div>
		</div>

		<div class="section_w210 margin_r_15">
			<div class="rounded_top">
				<span></span>
			</div>

			<div class="sub_content">
				<img
					src="<c:url value="/resources/themes/images/icons/videos.png" />" />
				<h2>Videos</h2>
				<p align="justify">Learn the basics about YBS viewing videos found on the YBS
					YouTube channel.</p>
			</div>

			<div class="rounded_bottom">
				<span></span>
			</div>
		</div>

		<div class="section_w210 margin_r_15">
			<div class="rounded_top">
				<span></span>
			</div>

			<div class="sub_content">
				<img
					src="<c:url value="/resources/themes/images/icons/cheatsheets.png" />" />
				<h2>Quick Guides</h2>

				<p align="justify">View YBS quick reference guides to the YBS application.</p>
				<br>
			</div>

			<div class="rounded_bottom">
				<span></span>
			</div>
		</div>

		<div class="section_w210 margin_r_15">
			<div class="rounded_top">
				<span></span>
			</div>

			<div class="sub_content">
				<img
					src="<c:url value="/resources/themes/images/icons/howto.png" />" />
				<h2>How-to articles</h2>

				<p align="justify">Learn more advanced features from online how-to articles.</p>
				<br>
			</div>

			<div class="rounded_bottom">
				<span></span>
			</div>
		</div>

	</div>
	<!-- end of a section_w940 -->

	<div class="cleaner"></div>

</body>
</html>