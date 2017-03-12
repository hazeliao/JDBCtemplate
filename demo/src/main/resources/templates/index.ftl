<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8" />    
</head>

<body>
    <!-- Start of first page -->
    <div id="main">       
            
        <h1>Complete application details</h1>
        
        <div>
            <ul>
                <li><b>Trademark(s) details</b>(See further instructions and comments, new window)
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
						    <input type="text" name="name" />
						    <br />
						    <label>Other than word marks - upload file(PDF,JPG,PNG)</label>
						    <br />
						    <input type="file" name="file" id="tradeMarkeFile"/>
						    <br />
					    </div>               
                </li>
                <li>Goods and services
                	<p>The goods and services named in the application determine the extent of your rights. Select the goods and services for your trademark application below. Government fee is determined only by the number of classes (within a class you can choose as many items as you like). Once the application is submitted, it is not possible to add new goods and services. The government fee for the application includes one class. First additional class is 50 EUR and thereafter each class adds 150 EUR to government fees. The number of classes does not affect attorney fees (see below). If you want to protect your trademark for goods and services not found here, please select advanced or premium service level below.</p>                              
                	<div>	        
				        <h3>Primary:</h3>
				       <ul>
				        	<#assign class = -1>
				        	<#list formTerm.termPrimary as term>
				        	<#if class!=term.termClass.termClassId>
				       		<li>Class ${term.termClass.termClassId}
				       		<#assign class = term.termClass.termClassId>
					       	</#if>
						       	<ul> 	        
						       		<li><input id=${term.id} type="checkbox" value=${term.id}/>${term.termName} </li>
						       	</ul> 
					       	</li>
					       	
					       	</#list> 
				       	</ul>
				       	
				       	<h3>Secondary:</h3>
				       	<ul>
				       		<#assign class = -1>
				       		<#list formTerm.termSecondary as term>
				       		<#if class!=term.termClass.termClassId>
				       		<li>Class ${term.termClass.termClassId}
				       		<#assign class = term.termClass.termClassId>
					       	</#if>
						       	<ul> 	        
						       		<li><input id=${term.id} type="checkbox" value=${term.id}/>${term.termName} </li>
						       	</ul> 
					       	</li>
					       	
					       	</#list> 
					    </ul>
					    <p>Did not find what you were looking for?</p>
					    <textarea></textarea>
					      
	               	</div>	  
	            </li>              
                <li>Service level (See further instructions and comments, new window)
                	<br />
                	<a href="https://www.reggster.com/service-levels.html">Compare plans (new window)</a>
                	<ul>
                		<#list serviceLevels as serviceLevel>
                			<li> ${serviceLevel.serviceName} <br />
                				 <input id=${serviceLevel.id} type="checkbox" value=${serviceLevel.id}/> Attorney free ${serviceLevel.price} EUR. 
                			</li>
                		</#list>
                	</ul>
                </li>
                <li>Applicant details</li>
                <li>Final provisions</li>
                <button type="submit">Submit</button>               
            </ul>
        </div>
        
        
    </div>

                	
   
   
</body>

</html>