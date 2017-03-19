<html>
<body>
	<h3>formSubmissions</h3>			
			<ul>
				        	
				        	
				       		<li>formSubmission  <br />
					       		id: ${formSubmission.id}	 <br />			       		
						       	formId: ${formSubmission.formId} <br />
							    serviceLevelId: ${formSubmission.serviceLevelId} <br />
							    customerEmail: ${formSubmission.customerEmail} <br />
							    textTrademark: ${formSubmission.textTrademark}   <br />
							    selected terms:
						    <ul>
						    	<#list formSubmission.terms as term>
						    	<li> ${term.name}</li>
						    	</#list>
						    </ul> 	
					       	</li>
					       	
					       
				       	</ul>
				       	
				       	
    	
				       	
	
</body>
</html>