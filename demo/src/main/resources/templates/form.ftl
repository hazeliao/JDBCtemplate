<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>

<head>
     
    <link rel="stylesheet" type="text/css" href="../css/universal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Nunito">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Montserrat">  
</head>

<body>
    <div>
        <a href="industrypage"><img id="logo" src="../images/nya.png"></a>
        <nav id="nav">
            <ul>
                <li id="industryPageNav" class="navLi active"><a>APPLY NOW</a></li>
                <li id="serviceNav" class="navLi"><a>Cost and Fees</a></li>
                <li id="resourcesNav" class="navLi"><a>Resources</a></li>
                <li id="aboutNav" class="navLi"><a>About</a></li>
                <li id="contactNav" class="navLi"><a>Contact</a></li>
            </ul>
        </nav>
    </div>
    <div>
    
           
        <div class="mainHeader">
            <div class="content-title">
            	<br>
                <span class="headerIcon"><span class="activeHeaderIcon" >①</span>②③</span>
                <h2><span id="headerSpan">Choose your destiny</span><br></h2>
                <h4><span id="headerSpan2">Your qalatic conquest beings here, become The Kitty of universe.</span></h4>
            </div>
        </div>         
        <h1>Complete application details</h1>
        
        <form id="formSubmission" action="/formSubmission" method="post" >
       	
        <h2>${form.name}</h2>  
              
        <input type="hidden" name="formId" id="formId" value="${form.id}" />
        
        
        <div>
            <h2>1. Trademark(s) details</h2>(See further instructions and comments, new window)
                	<p>If you want to file two trademarks, please note that the goods and services will be the same for both marks. If you want to file another trademark for other goods and services, please fill a separate form for the second trademark.</p>
                	    <div>    		
						    <br />
						    <input type="checkbox" name="checkbox-0" value="1234" />Word (e.g. name of the product)
						    <br />
						    <input type="checkbox" name="checkbox-1" value="235"/>Figurative (e.g. logo or icon, can contain words)
						    <br />
						    <input type="checkbox" name="checkbox-2" value="6" />Other (3d, sound, color, position, movement)
						    <br />
						    <label>Words in the trademark</label>	
						    <@spring.formInput "formSubmission.textTrademark"  />
						    <br />
						    <label>Other than word marks - upload file(PDF,JPG,PNG)</label>
						    <br />
						    <input type="file" name="file" id="tradeMarkeFile"/>
						    <br />
					    </div>               
                
                <h2>2. Goods and services</h2>
                	<p>The goods and services named in the application determine the extent of your rights. Select the goods and services for your trademark application below. Government fee is determined only by the number of classes (within a class you can choose as many items as you like). Once the application is submitted, it is not possible to add new goods and services. The government fee for the application includes one class. First additional class is 50 EUR and thereafter each class adds 150 EUR to government fees. The number of classes does not affect attorney fees (see below). If you want to protect your trademark for goods and services not found here, please select advanced or premium service level below.</p>                              
                	<div>	        
				        <h3>Primary:</h3>
				     		
					       	<#assign m1 = terms1Map>
					       	<#assign keys = m1?keys>

					       	<#list terms1Map?values as termMap1>
					       		<p>Class ${keys[termMap1?index]}</p>					       									
					       		<@spring.formCheckboxes "formSubmission.terms" termMap1 "<br/>"  />
					       	</#list>
					       	
					       					       	
				       	<h3>Secondary:</h3>
				       		<#assign m2 = terms2Map>
					       	<#assign keys = m2?keys>

					       	<#list terms2Map?values as termMap2>
					       		<p>Class ${keys[termMap2?index]}</p>					       									
					       		<@spring.formCheckboxes "formSubmission.terms" termMap2 "<br/>" />
					       	</#list>
					       	
					    <p>Did not find what you were looking for?</p>
					    <textarea></textarea>
					      
	               	</div>	  
	                         
                <h2>3. Service level (See further instructions and comments, new window)</h2>
                	<br />
                	<a href="https://www.reggster.com/service-levels.html">Compare plans (new window)</a>
                	<br />						
			        	<@spring.formRadioButtons "formSubmission.serviceLevelId" serviceLevelMap "<br>" />            		
				       
                <h2>4. Applicant details</h2>
                	<label>Applicant Email</label>
                	<@spring.formInput "formSubmission.customerEmail" />
				    <br />
                
                <h2>5. Final provisions</h2> 
                	               
                
                <button type="submit">Submit</button>               
			           
        </div>
        </form> 
        
        
    </div>

                	
   
   
</body>

</html>