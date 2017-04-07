<html>
<body>
	<h3>Please check the information you have filled in the form</h3>		
		
			
	       		
		       		<p> Category : ${form.name} <br />
				  		Service Level : ${level.name} Service Level <br />
				    	customerEmail: ${formSubmission.customerEmail} <br />
				   		textTrademark: ${formSubmission.textTrademark}   <br />
				    </p>
				    selected terms:
			    <ul>
			    	<#list formSubmission.terms as term>
			    	<li> ${term.name}</li>
			    	</#list>
			    </ul> 	
		       	
		       	
		       
	       
	       	<form action="/confirmation" method="post">
	       	<button type="submit">Submit</button>
			</form>	       	
				       	
				       	
    	
				       	
	
</body>
</html>