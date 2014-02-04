<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<jsp:include page="../menu/header.jsp" />
<jsp:include page="../menu/includescripts.jsp" />

<body>

	<hr class="soften">
	<div class="container">
		<div id="form"></div>
	</div>

</body>

<script>
Ext.onReady(function() 
{
    Ext.QuickTips.init();
	var companyDetailsForm = Ext.create('Ext.form.Panel',
	{
	    bodyStyle:'padding:5px', labelWidth : 80, monitorValid : true, fieldDefaults: { labelAlign: 'left', msgTarget: 'side', labelWidth: 100, labelStyle: 'font-weight:bold' },
	    defaults: { anchor: '100%' }, url : '<c:url value="/company/add" />', 
	    items : 
	    [
            {   title: 'Company Details', layout:'column', bodyStyle:'padding:10px', border:false,
                items:
				[ 
				    {   columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textfield',
				        items: 
						[
							{ fieldLabel: 'Company ID', name : 'companyId', anchor:'95%', allowBlank : false }, 
							{ fieldLabel:'Password', name:'password', inputType:'password', allowBlank:false }
						]
					},
					{   columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textfield',
						items: 
						[
							{ fieldLabel: 'Company Name', name : 'companyName', anchor:'95%', allowBlank : false },
							
						]
					} 
				]
			},
			{   title: 'Contact Details', layout:'column', bodyStyle:'padding:10px', border:false,
				items:
				[ 
				    {   columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textfield',
						items: 
						[
							{ fieldLabel: 'Phone', name : 'companyPhone', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Email', name : 'email', vtype:'email', anchor:'95%' }
						]
					},
					{  columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textfield',
						items: 
						[
							{ fieldLabel: 'Company Address', name : 'companyAddress', xtype: 'textareafield', anchor:'95%', allowBlank : false }
						]
					} 
				]
			},
			{   title: 'Subscription Details', layout:'column', bodyStyle:'padding:10px', border:false,
				items:
				[ 
				    {   columnWidth:.5, border:false, layout: 'anchor', defaultType: 'checkbox',
						items: 
						[
							{ fieldLabel: 'Sales', name : 'sales', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Purchases', name : 'purchases', anchor:'95%', allowBlank : false }
						]
					},
					{  columnWidth:.5, border:false, layout: 'anchor', defaultType: 'checkbox',
						items: 
						[
							{ fieldLabel: 'Orders', name : 'orders', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Third Parties', name : 'tps', anchor:'95%', allowBlank : false }
						]
					} 
				]
			},
			{   title: 'Payment Details', layout:'column', bodyStyle:'padding:10px', border:false,
				items:
				[ 
				    {   columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textfield',
						items: 
						[
							{ fieldLabel: 'Card Name', name : 'cardName', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Card Type', name : 'cardType', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Card Number', name : 'cardNumber', anchor:'95%', allowBlank : false }
						]
					},
					{  columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textfield',
						items: 
						[
							{ fieldLabel: 'Issuing Date', name : 'issuDate', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Expiry Date', name : 'expDate', anchor:'95%', allowBlank : false },
							{ fieldLabel: 'Security Code', name : 'securityCode', anchor:'95%', allowBlank : false }
						]
					} 
				]
			},
			{   title: 'Others', layout:'column', bodyStyle:'padding:10px', border:false,
				items:
				[ 
					{   columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textareafield',
						items: 
						[
							{ fieldLabel: 'Description', name : 'description', anchor:'95%', allowBlank : true }
						]
					},
					{
						columnWidth:.5, border:false, layout: 'anchor', defaultType: 'textareafield',
						items: 
						[
							{ fieldLabel: 'Notes', name : 'notes', anchor:'95%', allowBlank : true }
						]
					} 
				]
			}
		],
		buttons : 
		[
			{ text : 'Register', formBind : true, handler : function() { companyDetailsSubmit(); } }, 
			{ text : 'Cancel', handler: function() { window.location = "<c:url value="/login"/>" ;} } 
		]
	});
		
	var tabPanel = new Ext.FormPanel( 
	{   bodyStyle:'padding:5px', fieldDefaults: { labelAlign: 'left', msgTarget: 'side' }, defaults: { anchor: '100%' },
	    items:  [ companyDetailsForm ]
	});
		
    function companyDetailsSubmit()
	{
		companyDetailsForm.getForm().submit(
		{
			success : function(form, action) {
				window.location = "<c:url value="/register"/>" ;
			},
			failure : function(form, action) 
			{
				window.location = "<c:url value="/register/failure"/>" ;
			}
		});
	}
    
    tabPanel.render("form");
});
</script>

</html>