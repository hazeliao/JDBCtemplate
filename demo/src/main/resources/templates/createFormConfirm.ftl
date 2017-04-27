<html>
<body>
	<h3>Please check the information you have filled in the form</h3>		
		
			
	       		
	       		<p> New Form Name : ${form.name} <br /></p>
		  		IndustryFields :
		  		<ul>
			  		<#list form.industryFields as ifs>
			  			<li>${ifs.name} </li>
			  		</#list>				    	
			    </ul>
			    selected primay terms:
			    <ul>
			    	<#list form.terms1 as term>
			    	<li> ${term.name}</li>
			    	</#list>
			    </ul> 
			    selected secondary terms:
			    <ul>
			    	<#list form.terms2 as term>
			    	<li> ${term.name}</li>
			    	</#list>
			    </ul> 
		       	
		       	
		       
	       
	       	<form action="/confirmation" method="post">
	       	<button type="submit">Submit</button>
			</form>	       	
				       	
				       	
    	
				       	
	
</body>
</html>