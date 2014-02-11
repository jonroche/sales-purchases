<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<jsp:include page="../menu/header.jsp" />
<body bgcolor="#fff">
	<div align="center">

		<img id="logo"
			src="<c:url value="/resources/themes/images/logos/ybs4.png" />">

		<div class="container">
			<div id="login"></div>
		</div>

	</div>
</body>

<jsp:include page="../menu/includescripts.jsp" />

<!-- <style type="text/css">
      /* Override some defaults */
      html, body {
        background-color: #fff;
      }
      body {
        padding-top: 40px;
      }
      .container {
        width: 300px;
      }
 
      /* The white background content wrapper */
      .container > .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px;
        -webkit-border-radius: 10px 10px 10px 10px;
           -moz-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
      }
 
      .login-form {
        margin-left: 65px;
      }
 
    </style> -->

<script type='text/javascript'>
	Ext.onReady(function() {
		Ext.QuickTips.init();
		
		var login = new Ext.FormPanel(
				{
					title:'Please Login', url:'j_spring_security_check', labelWidth:80,  frame:true, defaultType:'textfield', width:300, height:150,
					monitorValid:true, bodyStyle:'padding:10px', 
					items:
					[
						{ 	fieldLabel:'Company Id', name:'j_username', id: 'companyId', allowBlank:false,
							listeners: {
						          afterrender: function(field) 
						          {
						            field.focus();
						          }
							}
						},
						{ 	fieldLabel:'Password', name:'j_password', inputType:'password', allowBlank:false }
					],
					buttons:
					[
						{ 	text : 'Login', formBind: true, handler: function() { loginSubmit(); } },
						{ 	text : 'Reset', formBind: true, handler: function() { reset(); } },
						//{ 	text : 'Register', formBind: false, href: "<c:url value="/register"/>" }
						{ 	text : 'Register', formBind: false, handler: function() { window.location = "<c:url value="/company/add"/>"; }}
						
					],
					listeners: 
					{
			            afterRender: function(thisForm, options)
			            {
			                this.keyNav = Ext.create('Ext.util.KeyNav', this.el, 
			                {
			                    enter: loginSubmit,
			                    scope: this
			                });
			            }
					}
				});

		

		function reset() {
			login.getForm().reset();
		}

		function loginSubmit() {
			login.getForm().submit({
				method : 'POST',
				success : function(form, action) {
					window.location = 'home';
				},
				failure : function(form, action) {
					Ext.Msg.alert('Login Failed!', 'Login Failed!');
					reset();
				}
			});
		}		
		
		var tabPanel = Ext.create('Ext.Panel', {
			width: 580, height: 300, layout: { type: 'vbox', align: 'center', pack: 'center' },
			defaults: { defaults: { width: 200, height: 300, bodyPadding: 10, autoScroll: true, margin: 10 }, margin: '0 0 10 0' },
			items: [login]
		});
			    

		tabPanel.render('login');

	});
</script>

</html>