<!DOCTYPE html>
<#import "/spring.ftl" as spring/>

<html>
<body>
	<h3>Please check the information you have filled in the form</h3>		
		
			<form action="/newformconfirmed" name="model" method="post">
	       		
	       		<p> New Form Name : ${form.name} <br /></p>
		  		IndustryFields :
		  		<ul>
			  		<#list form.industryFields as ifs>
			  			<li>${ifs.name} <input name ="value" type="number" min="100" max="999" id="${ifs.id}" placeholder="priority" /></li>
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
		       	
		       	
		       
	       
	       	
	       	<button type="submit">Submit</button>
			</form>	       	
				       	
				       	
    	
				       	
	
</body>
</html>