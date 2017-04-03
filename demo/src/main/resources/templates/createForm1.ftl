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
        
        <form id="createForm" action="/createForm" method="post" >
       	
                      
        <label>Form Name</label>	
		<@spring.formInput "form.name"  />
		<br />
		                	
       <#-- <h3>Primary Terms:</h3>				        
     		<#assign m1 = terms1Map>
	       	<#assign keys = m1?keys>
	       	<#assign values = m1?values>

	       	<#list values as termMap1>					       		
	       		<p>Class ${keys[termMap1?index]}</p>					       									
	       		<@spring.formCheckboxes "form.terms1" termMap1 "<br>" />
	       	</#list>
	       						       	
	    <h3>Secondary Terms:</h3>
       		<#assign m2 = terms2Map>
	       	<#assign keys = m2?keys>

	       	<#list terms2Map?values as termMap2>
	       		<p>Class ${keys[termMap2?index]}</p>
	       		<@spring.formCheckboxes "form.terms2" termMap2 "<br>" />
	       		
	       	</#list> -->
					
		<button type="submit">Submit</button>               
			
        </form> 
        
        
    </div>

                	
   
   
</body>

</html>