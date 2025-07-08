	  
	 $(document).ready(function(){
		 
		 
		  var speechRecognition=window.speechRecognition || window.webkitSpeechRecognition;

		  var recognition=new speechRecognition();

		  var textbox;
		
		  let content="";

		  recognition.continuous=true;

		  recognition.onstart=function(){
			  console.log("voice recognition is on");
		  }
		  recognition.onspeechend=function(){
			  console.log("No Activity");

		  }
		  recognition.onerror=function(event){
			  console.log(event);
			  console.log("aborted");

		  }
		  recognition.onresult=function(event){
		  	var current=event.resultIndex;
		  	var transcript=event.results[current][0].transcript;
		  	content +=transcript;
		  	
		  	textbox.val(content);
		  }

		  $(".start-btn").click(function(event){		  
			  textbox=$(this).parent().parent().find("textarea");
			  $(this).css("display","none");
		  		$(this).siblings().css("display","");
		  	if(content.length){
		  		//content += '';
		  		content=$(textbox).val()+" ";
		  	}
		  	
		  	recognition.start();
		  	$(textbox).focus();
		  	console.log("start");
		  });

		  	$(".stop-btn").click(function(event){
		  		recognition.abort();
		  		$(this).css("display","none");
		  		$(this).siblings().css("display","");
		  		console.log("stopped");
		  });
	 });
	
	  
	  	
	  	
	  	
	  	function abortMic(obj){
	  		$(obj).parent().find(".stop-btn").trigger("click");
	  	}