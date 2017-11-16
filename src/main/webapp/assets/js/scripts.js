
jQuery(document).ready(function() {
	
    
  //  $.backstretch("assets/img/backgrounds/1.jpg");
    
    /*
        Login form validation
    */
    
    
	$("#email").blur(function(){
		$.ajax({
			url : 'AjaxEmailValidation',
			data : { 
				email:$("#email").val()
			},
			success: function(responseText){
				$('.emailAjax').text(responseText);
			}
		});	
	});
	
	
	
	
	
	
    $("#name").blur(function(){
    	var name=$("#name").val();
    	var pattern=/^[a-zA-Z]{4,15}/;
    	if((name.charAt(0)).match(/[0-9]$/)){
    		
    		$('#name').addClass('input-error');
    		$(".name").text("* Username must start with character");
    	}
    	else if(name.length<4){
    		$('#name').addClass('input-error');
    		$(".name").text("* Username must Contain Atleast 4 characters");
    		
    	}
    	else if(!(name.match(pattern)))
    	{
    		$('#name').addClass('input-error');
    		$(".name").text("* Username only contain a-z,A-Z,0-9 characters");
    	}else{
    		$(".name").empty();
        	
    	}
    	
    	
    });
     
    $('.login-form input[type="text"], .login-form input[type="password"]').on('focus', function() {
    	$(this).removeClass('input-error');
    });
   
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"]').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    /*
        Registration form validation
    */
   
    

    
    $("#password").blur(function(){
    	var password= $("#password").val();
    	if(password.length<8){
    		$("#password").addClass('input-error');
    		$(".password").text("* Password Strength should be 8 Character");
    	}else{
    		$(".password").empty();
    		}
    });
  
    $("#confirm").blur(function(){
    	var confirm=$("#confirm").val();
    	var password=$("#password").val();
    	if(confirm!=password){
    		 $("#confirm").addClass('input-error');
     		 $(".confirm").text("* Password not match,Try again..");
     		 $("#confirm").val('');
    	}else{
    		$(".confirm").empty();
    		}
    	
    });
  
       $("#email").blur(function(){
    	   var pattern=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    	   var email=$("#email").val();
    	   if(!(email.match(pattern))){
    		   $("#email").addClass('input-error');
       		 $(".email").text("* Please enter valid email...");
    	   }else if(email.match(pattern)){
    		   $("#email").addClass('input-error');
    		   $(".email").empty();
    		   $.ajax({
    				url : 'AjaxEmailValidation',
    				data : { 
    					email:$("#email").val()
    				},
    				success: function(responseText){
    					$('.emailAjax').text(responseText);
    				}
    			});
    			
    	   }
    	
    	   }); 
    
       $("#number").blur(function(){
       	var number=$('#number').val();
       	var pattern=/[0-9]{10}/;
       	if(!(number.match(pattern))){
       		$('#number').addClass('input-error');
       		$('.number').text("* Please enter 10 digit number...");
       		$('#number').val('');
       		}
       	else if(number.length>10){
       		$('#number').addClass('input-error');
       		$('.number').text("* Please enter 10 digit number...");
       		$('#number').val('');
       		
       	}
       	else{
       			$('.number').empty();
       		}
       });
       
    
    
    
    
    $('.registration-form input[type="text"], .registration-form input[type="password"]').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.registration-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"]').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
});
