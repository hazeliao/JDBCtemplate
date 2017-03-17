<!DOCTYPE html>
<html>
    <head>    
        <title>Apply for KittyLitter sandcastles.</title>
        <link rel="stylesheet" type="text/css" href="css/universal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Nunito">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Montserrat">
    </head>
    <body>
        <div id="header">
            <a href="industrypage"><img id="logo" src="images/nya.png"></a>
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
        <div id="main">
            <div class="mainHeader">
                <div class="content-title">
                	<br>
                    <span class="headerIcon"><span class="activeHeaderIcon" >①</span>②③</span>
                    <h2><span id="headerSpan">Choose your destiny</span><br></h2>
                    <h4><span id="headerSpan2">Your qalatic conquest beings here, become The Kitty of universe.</span></h4>
                </div>
            </div>    
            <div id="content">
				<#list industryFields as industryField>
	                <div class="industryGroup">
	                    <div class="icon"><i class="${industryField.iconFilePath}"></i></div>
	                    <span class="industryField">${industryField.name}</span>
	                	<ul>
	                    	<#list industryField.forms as form>	                    	
	                    		<li class="formLink"><a href="/form/${form.id}">${form.name}</a></li>
	                        </#list>
	                    </ul>
	                </div>
	            </#list>
            </div>
       	</div>
        <div id="footer">
        </div>
    </body>
</html>

