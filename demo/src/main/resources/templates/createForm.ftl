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
          
        <h1>New Form</h1>
                      
        <h3>Form Name:</h3>
        <textarea></textarea>	
		
		<br />
		
		<h3>Primary Terms:</h3>				        
     		<#list terms as term>
     		<p>${term.name}</p>
     		</#list>
	       						       	
	    <h3>Secondary Terms:</h3>
		
					
		<button type="submit">Submit</button>               

        
    </div>

                	
   
   
</body>

</html>