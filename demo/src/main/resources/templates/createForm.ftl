<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>

<head>
     
    <link rel="stylesheet" type="text/css" href="../css/universal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Nunito">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Montserrat"> 
	<script src="../js/createForm.js"></script>
</head>

<body>
    <div>
        <a href="industrypage"><img id="logo" src="../images/nya.png"></a>
        <nav id="nav">
        
        </nav>
    </div>
    
    <div>
          
        <h1>New Form</h1>
        <form id="form" action="/formConfirm" method="post" >      

        <h3>Form Name:</h3>
        <@spring.formInput "form.name" />		
		<br />		
		
		<h3>Industry Field:</h3>       
        <button type="button" onclick="openPopup(0);" style="float:none; margin:0;">Select IndustryField</button>               
        <div id="industryFieldPopup" class="popup">
        	<div class="popupBackground" onclick="closePopup(0);"></div>
 			<div id="industryFieldPopupFg" class="popupForeground">
					<@spring.formCheckboxes "form.industryFieldIds" industryFieldMap "<br>"/>
					<button type="button" onclick="confirmPopup(0);"> OK </button>		        	
     		</div>
        </div>
        
        <div id="industryFieldResults">
        	
        </div>
        
		<br />
		
		
		<h3>Primary Terms:</h3>
		
			<input id="primaryTermsInput" type="text" >
			<button type="button" onclick="openPopup(1);">
				<i class="fa fa-search" aria-hidden="true"></i>
			</button>
			<br/>		        
     	
        <div id="primaryTermsPopup" class="popup">
        	<div id="popupBackgroundTest" class="popupBackground" onclick="closePopup(1);"></div>
 			<div id="primaryTermsPopupFg" class="popupForeground" >
					<@spring.formCheckboxes "form.terms1Ids" termsMap "<br>" />
					<button type="button" onclick="confirmPopup(1);"> OK </button>		        	
     		</div>
        </div>
	       			
        <div id="primaryTermsResults">
        	
        </div>
	       			
	    <h3>Secondary Terms:</h3>
			<input id="secondaryTermsInput" type="text">
			<button type="button" onclick="openPopup(2);">
				<i class="fa fa-search" aria-hidden="true"></i>
			</button>
			<br/>
			
			<div id="secondaryTermsPopup" class="popup">
				<div class="popupBackground" onclick="closePopup(2);"></div>
 				<div id="secondaryTermsPopupFg" class="popupForeground">
					<@spring.formCheckboxes "form.terms2Ids" termsMap " <br> " />
					<button type="button" onclick="confirmPopup(2);"> OK </button>		        	
     			</div>
        	</div>			
		
		<div id="secondaryTermsResults">
        	
        </div>
        
		<br/>
		<br/>
				
		<button type="submit">Submit</button>               

        </form>
    </div>

                	
   
   
</body>

</html>