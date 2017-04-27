<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>

<head>
     
    <link rel="stylesheet" type="text/css" href="../css/universal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Nunito">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Montserrat"> 

	<script>

		//
		//	Global variables used with functions.
		//
		var popups = [];
		
		// Industry Field
		var industryFieldPopup 			= {};
		var industryFieldResultsDiv;
		
		// Primary Terms
		var primaryTermsPopup = {};
		var primaryTermsResultsDiv;
		
		// Secondary Terms
		var secondaryTermsPopup = {};		
		var secondaryTermsResultsDiv;
		
		document.addEventListener('DOMContentLoaded', function(){

			//
			//	The three popups that are the core of the functionality of this page:
			//
			popups[0] = document.querySelector('#industryFieldPopup');
			popups[1] = document.querySelector('#primaryTermsPopup');
			popups[2] = document.querySelector('#secondaryTermsPopup');
					
			//
			//	At the start, hide all the form selection data. These are shown in popups later.
			//
			for ( var i = 0; i < popups.length; i++ ) { hide(popups[i]); }			
						
			// =========================================================================
			//	Industry Field Popup
			//
			//	Save checkboxes & labels for access later. Save results div for output.
			// =========================================================================
			industryFieldPopup.checkboxes 	= getCheckboxesFrom(document.getElementById("industryFieldPopupFg"));
			industryFieldPopup.labels 		= document.getElementById("industryFieldPopupFg").getElementsByTagName('LABEL');
			industryFieldResultsDiv 		= document.querySelector('#industryFieldResults');	

			// =========================================================================
			//	Primary Terms popup
			//
			//	Save checkboxes & labels for access later. Save results div for output.
			// =========================================================================	    
			primaryTermsPopup.divNameFg		= "primaryTermsPopupFg";
		    primaryTermsPopup.checkboxes 	= getCheckboxesFrom(document.getElementById(primaryTermsPopup.divNameFg));
		    primaryTermsPopup.labels 		= document.getElementById("primaryTermsPopupFg").getElementsByTagName('LABEL');
		    primaryTermsResultsDiv 			= document.querySelector('#primaryTermsResults');				
			
			// =========================================================================
			//	Primary Terms popup
			//
			//	Save checkboxes & labels for access later. Save results div for output.
			// =========================================================================	    
			secondaryTermsPopup.divNameFg	= "secondaryTermsPopupFg";
		    secondaryTermsPopup.checkboxes 	= getCheckboxesFrom(document.getElementById(secondaryTermsPopup.divNameFg));
			secondaryTermsPopup.labels 		= document.getElementById("secondaryTermsPopupFg").getElementsByTagName('LABEL');
			secondaryTermsResultsDiv 		= document.querySelector('#secondaryTermsResults');

			//
			//	Block enter key to submit form because search functionality is triggered with it!
			//
			var formX = document.querySelector("#form");
			var prim = document.querySelector("#primaryTermsInput");
			var sec = document.querySelector("#secondaryTermsInput");
			formX.addEventListener("keypress", function(event) {
			
				 if (event.keyCode == 13) {
				 	
				 	if ( prim === document.activeElement )
				 	{
				 		openPopup(1);
				 	}
				 	
				 	if ( sec === document.activeElement )
				 	{
				 		openPopup(2);
				 	}
				 	
				 	console.log("Blocked Enter -keypress for search feature.");
        			event.preventDefault();
    			}
			});
		});
		
		
		//
		//	Global functions.
		//		
		
		//
		//	Deletes the HTML element and restores the checkbox choice.
		//
		function killPrimaryTerm(element, checkboxId)
		{

			console.log("xxsxs checkboxId: " + checkboxId.id);
			console.log("asdfs checkboxId: " + checkboxId.checked);
			console.log("xx checkboxId: ", checkboxId);
			document.getElementById(checkboxId.id).checked = false;
			//removeElem('label','for',checkboxId.id);
	
			console.log("element to kill:", element);
			//var	xxx = element.nextSibling;
//			element.nextSibling.removeChild(element.nextSibling.firstChild);
			element.parentNode.removeChild(element.nextSibling);
			console.log("434next name:", element.nextSibling.nodeName);
			if(element.nextSibling.nodeName=='BR')
				element.parentNode.removeChild(element.nextSibling);
			
			element.parentNode.removeChild(element);
			
	
//			var baseElement = document.getElementById(checkboxId).checked = false;
			
			//document.getElementById(checkboxId).checked = false;
		}
		
		//
		//	Finds the choices the user made from checkboxes.
		//
		function getChoicesAsStringArray( dataObject ) //dataObject.checkboxes & dataObject.labels
		{
			var results = [];
			for ( var i = 0; i < dataObject.checkboxes.length; i++ )
			{
				if ( dataObject.checkboxes[i].checked )
				{
					//NOTE: ( dataObject.checkboxes[i].value ) contains the chosen value results like 203, 213, etc.
					//console.log("val:" + dataObject.checkboxes[i].value);
					//The copied HTML needs to be shown instead of hidden on the main page for the user.
					var hiddenLabel = dataObject.labels[i].outerHTML;
					var shownLabel = hiddenLabel.replace("display: none;", "display:inline-block;");
//					console.log("dataObject.checkboxes[i].id: " + dataObject.checkboxes[i].id);
					var everything = "<button type='button' onclick='killPrimaryTerm(this,";
					everything += "" + dataObject.checkboxes[i].id+ ");";
					everything += "'>Remove</button>";
					results.push( everything + shownLabel + "<br/>" );
				}
			}
			return results;
		}
		
		//
		//	Confirm choices made in the popup. 0 = industry, 1 = primary terms, 2 = secondary terms.
		//
		function confirmPopup(popupId)
		{
			var resultsStringArray = [];
			if ( popupId === 0 )
			{
				resultsStringArray = getChoicesAsStringArray( industryFieldPopup ); //NOTE: Regexp removes commas.
				industryFieldResultsDiv.innerHTML = "<p>" + resultsStringArray.toString().replace(/\,/g,"<br/>") + "</p>";
			}

			if ( popupId == 1 )
			{
				resultsStringArray = getChoicesAsStringArray( primaryTermsPopup ); //NOTE: Regexp removes commas.
				var dataAsString = "";
				for ( var i = 0; i < resultsStringArray.length; i++ )
				{
					dataAsString += resultsStringArray[i];
				}
				primaryTermsResultsDiv.innerHTML = "<br/>" + dataAsString;
			}
			
			if ( popupId == 2 )
			{
				resultsStringArray = getChoicesAsStringArray( secondaryTermsPopup ); //NOTE: Regexp removes commas.
				var dataAsString = "";
				for ( var i = 0; i < resultsStringArray.length; i++ )
				{
					dataAsString += resultsStringArray[i];
				}
				secondaryTermsResultsDiv.innerHTML = "<br/>" + dataAsString;
			}
			closePopup(popupId);
		}

		//
		//	Close a popup 0 = industry, 1 = primary terms, 2 = secondary terms.
		//
		function closePopup(popupId)
		{
			var popupTarget = 0; 
			if ( popupId == 1 ) { popupTarget = primaryTermsPopup; 		}
			if ( popupId == 2 ) { popupTarget = secondaryTermsPopup; 	}
			
			if ( popupTarget != 0 )
			{
				//Restore all possibly hidden brs.
				var brsToReveal = document.getElementById(popupTarget.divNameFg).getElementsByTagName('br');
				for ( var i = 0; i < brsToReveal.length; i++ )
				{
					show(brsToReveal[i]);
				}
			}
			
			hide( popups[popupId] );
		}

		
		//
		//	Opens a popup. 1 and 2 are filtering their data using an input field.
		//
		function openPopup(popupId)
		{
		
			//
			//	Primary search terms popup
			//
			if ( popupId == 1 )
			{
				
				//
				//	Set the search term.
				//
				var searchTerm = document.getElementById("primaryTermsInput").value;
				
				//
				//	Hide elements that don't contain the search term.
				//
				filterPopupContents( searchTerm, primaryTermsPopup );
			
			}

			//
			//	Secondary search terms popup
			//
			if ( popupId == 2 )
			{
				
				//
				//	Set the search term.
				//
				var searchTerm = document.getElementById("secondaryTermsInput").value;
				
				//
				//	Hide elements that don't contain the search term.
				//
				filterPopupContents( searchTerm, secondaryTermsPopup );

			}		
			
			show(popups[popupId]);
		}	  
		
		function showSpecial(el){
	  		el.style.display = 'inline-block';
		}
		
		function show(el){
	  		el.style.display = 'block';
		}
		
		function hide(el){
		  el.style.display = 'none';
		}

		//
		//	Gets the checkbox -elements from a HTML DIV and returns them as an array.
		//		
		function getCheckboxesFrom(targetElement)
		{
			var result = [];
			var targetInputElements = targetElement.getElementsByTagName('INPUT');
		    for (var i = 0; i < targetInputElements.length; i++)
		    {
		        if (targetInputElements[i].type.toUpperCase()=='CHECKBOX') // Only add checkboxes.
		        {
					result.push( targetInputElements[i] );
		        	// DEBUG // targetInputElements[i].addEventListener('click', function(){ console.log("id: " + this.id + " checked: " + this.checked ); });				
		        }
		    }
		    return result;
		}
		
		function filterPopupContents(searchTerm, targetPopup)
		{			
			for ( var i = 0; i < targetPopup.checkboxes.length; i++ )
			{
				//targetPopup.checkboxes[i].checked = false;
				if ( targetPopup.checkboxes[i].checked == true)
				{
					hide(targetPopup.labels[i]);
					hide(targetPopup.checkboxes[i]);
					var brsToHide = document.getElementById(targetPopup.divNameFg).getElementsByTagName('br');
					hide(brsToHide[i]);
				}
				else
				{
					showSpecial(targetPopup.labels[i]);
					showSpecial(targetPopup.checkboxes[i]);
				}
			}
			
			var numberOfBRsToHide = 0;
			var numToShow = 0;
			for ( var i = 0; i < targetPopup.checkboxes.length; i++ )
			{
				//console.log("outerhtml popup: " + targetPopup.labels[i].innerHTML);
				var comparisonText = targetPopup.labels[i].innerHTML;
				if ( comparisonText.toUpperCase().indexOf( searchTerm.toUpperCase() ) != -1 )
				{
					if ( targetPopup.checkboxes[i].checked == false)
					{
						showSpecial(targetPopup.checkboxes[i]);
						showSpecial(targetPopup.labels[i]);
						numToShow++;
					}
				} else {
					numberOfBRsToHide++;
					hide(targetPopup.checkboxes[i]);
					hide(targetPopup.labels[i]);
				}			
			}
			
			//Hide some of the extra spaces after.
			var brsToHide = document.getElementById(targetPopup.divNameFg).getElementsByTagName('br');
			for ( var i = numToShow; i < numberOfBRsToHide; i++ )
			{
				hide(brsToHide[i]);
			}
		}

	</script>
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