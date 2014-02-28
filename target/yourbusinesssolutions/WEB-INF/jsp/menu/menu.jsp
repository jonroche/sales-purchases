<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<script>

Ext.require([ '*' ]);

Ext.onReady(function() {
	Ext.QuickTips.init();
	
	var isSales = 'true';
	var isPurchases = 'true';
	var isPayments = 'true';
	var isParties = 'true';
	var isProducts = 'true';
	
	setSubscription();
	
	var partiesMenu = Ext.create('Ext.menu.Menu', 
	{
		id: 'partiesMenu',
		items: 
		[
			{ text: 'Customers', href: "<c:url value="/customer"/>" }, 
			{ text: 'Vendors', href: "<c:url value="/vendor"/>" }, 
			{ text: 'Staff', href: "<c:url value="/staff"/>" }
        ]
	});
	
	var productsMenu = Ext.create('Ext.menu.Menu', 
	{
		id: 'productsMenu',
		items: 
		[
			{ text: 'Products', href: "<c:url value="/product"/>" }, 
			{ text: 'Product Groups', href: "<c:url value="/productgroup"/>" }
		]
	});
	
	var purchasesMenu = Ext.create('Ext.menu.Menu', 
	{
		id: 'purchasesMenu',
		items: 
		[
			{ text: 'Purchase Summary', href: "<c:url value="/purchaseorder"/>" }, 
			{ text: 'Purchase Order List', href: "<c:url value="/purchaseorder/orderList"/>" },
			{ text: 'New Purchase Order', href: "<c:url value="/purchaseorder/add"/>" }
		]
	});

	var salesMenu = Ext.create('Ext.menu.Menu', 
	{
		id: 'salesMenu',
		items: 
		[
			{ text: 'Sales Summary', href: "<c:url value="/saleorder"/>" }, 
			{ text: 'Sale Order List', href: "<c:url value="/saleorder/orderList"/>" },
			{ text: 'New Sales Order', href: "<c:url value="/saleorder/add"/>" }
		]
	});
	
	var paymentsMenu = Ext.create('Ext.menu.Menu', 
	{
		id: 'paymentsMenu',
		items: 
		[
			{ text: 'Payments List', href: "<c:url value="/payments"/>" },
			{ text: 'New Payment', href: "<c:url value="/payments/add"/>" }
		]
	});
	
	function createMenuBar() {
		
		var tb = Ext.create('Ext.toolbar.Toolbar');
		tb.suspendLayout = true;
		tb.render('toolbar');

		tb.add({
			text : 'Home',
			handler: function() { window.location = "<c:url value="/home"/>" ;},
			group : 'theme'
		});
		
		if (isPurchases == 'true') {
	   		tb.add({
	   			text : 'Purchases',
	   			menu: purchasesMenu
	   		});
		}


		if (isSales == 'true') {
	   		tb.add({
				text : 'Sales',
				menu: salesMenu
			});
	   	}
		
		if (isPayments == 'true') { 
				tb.add({
				text : 'Payments',
				menu: paymentsMenu
			});
		}

		if (isParties == 'true') {
			tb.add({
				text : 'Parties',
	        	menu: partiesMenu
			});
		}

		if (isProducts == 'true') {
			tb.add({
				text : 'Products',
	        	menu: productsMenu
			});
		}
		
		if (isSales == 'true' || isPurchases == 'true') {
			tb.add({
				text : 'Overview',
				handler: function() { window.location = "<c:url value="/overview/overview"/>" ;},
				group : 'theme'
			});
		}
		

	/* 
		tb.add({
			text : 'Users',
			handler: function() { window.location = "<c:url value="/users"/>" ;},
			group : 'theme'
		});
	    
	    tb.add({
			text : 'Products',
			handler: function() { window.location = "<c:url value="/products"/>" ;},
			group : 'theme'
		});

	    tb.add({
			text : 'Orders',
			handler: function() { window.location = "<c:url value="/orders"/>" ;},
			group : 'theme'
		});
	    
	    tb.add({
			text : 'Payments',
			handler: function() { window.location = "<c:url value="/payments"/>" ;},
			group : 'theme'
		});
	 */
		tb.add({
			xtype: 'tbfill'
		});

	    tb.add({
			text : '<%=SecurityContextHolder.getContext().getAuthentication().getName()%>',
			handler: function() { window.location = "/" ;}
		});
	    
		
	    tb.add({
			text : 'Logout',
			handler: function() { window.location = "<c:url value="/logout"/>" ;}
		});

		tb.suspendLayout = false;
		tb.doLayout();
		
	}
	
	//function setSubscription() {
		//setSales();
		//Subscription();
	//}
	
	/*function setSales() {
		Ext.Ajax.request ({
		    url: 'http://localhost:8080/yourbusinesssolutions/company/isSales',
		    disableCaching: false ,
		    asynch: true,
		    success: function (res) {
		    	isSales = res.responseText;
		    	setPurchases();
		    },
		    failure: function () {
		        console.log ('error');
		        setPurchases();
		    }
		});
	}
		
	function setPurchases() {	
		Ext.Ajax.request ({
		    url: 'http://localhost:8080/yourbusinesssolutions/company/isPurchases',
		    disableCaching: false ,
		    asynch: true,
		    success: function (res) {
		    	isPurchases = res.responseText;	
		    	setPayments();
		    } ,
		    failure: function () {
		        console.log ('error');
		        setPayments();
		    }
		    
		});
	}
	
	function setPayments() {	
		Ext.Ajax.request ({
		    url: 'http://localhost:8080/yourbusinesssolutions/company/isPayments',
		    disableCaching: false ,
		    asynch: true,
		    success: function (res) {
		    	isPayments = res.responseText;	
		    	setParties();
		    } ,
		    failure: function () {
		        console.log ('error');
		        setParties();
		    }
		    
		});
	}
	
	function setParties() {	
		Ext.Ajax.request ({
		    url: 'http://localhost:8080/yourbusinesssolutions/company/isParties',
		    disableCaching: false ,
		    asynch: true,
		    success: function (res) {
		    	isParties = res.responseText;	
		    	setProducts();
		    } ,
		    failure: function () {
		        console.log ('error');
		        setProducts();
		    }
		    
		});
	}
	
	function setProducts() {	
		Ext.Ajax.request ({
		    url: 'http://localhost:8080/yourbusinesssolutions/company/isProducts',
		    disableCaching: false ,
		    asynch: true,
		    success: function (res) {
		    	isProducts = res.responseText;	
		    	createMenuBar();
		    } ,
		    failure: function () {
		        console.log ('error');
		        createMenuBar();
		    }
		    
		});
	}*/
	
	function setSubscription() {	
		Ext.Ajax.request ({
		    url: 'http://ybs.cfapps.io/company/getSubscription',
		    disableCaching: false ,
		    asynch: true,
		    success: function (res) {
		    	var map = JSON.parse(res.responseText);
		    	for (var key in map) {
		    		if (key == 'isSales') {
		    			isSales = map[key];
		    		} else if (key == 'isPurchases') {
		    			isPurchases = map[key];
		    		} else if (key == 'isPayments') {
		    			isPayments = map[key];
		    		} else if (key == 'isParties') {
		    			isParties = map[key];
		    		} else if (key == 'isProducts') {
		    			isProducts = map[key];
		    		} 
		    	}
		    	createMenuBar();
		    	//var obj = res.responseText;
		    	//for (var key in obj) {
		    	//    console.log(key + ': ' + obj[key]);
		    	//}
		        //Ext.each(res.responseText, function(op) {
		        //  isPurchases = true;
		        //});
		    	//Ext.util.HashMap map = res.responseText;
		    	//isPurchases = map.get("isPurchases");
		    	//isSales = map.get("isSales");

		    } ,
		    failure: function () {
		        console.log ('error');
		        createMenuBar();
		    }
		    
		});
	}

    
});


</script>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<div id="toolbar"></div>
		</div>
	</div>
</div>
