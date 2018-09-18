  $(document).ready(function() {
    $(function() {
        $("#autocomplete").autocomplete({     
            source : function(request, response) {
              $.ajax({
           	  headers: { 
           	       'Accept': 'application/json',
           	       'Content-Type': 'application/json' 
           	   },
                   url : "displayUserAutocomplete",
                   type : "GET",
                   data : {
                          query : request.term+"%"
                   },
                   dataType : "json",
                   success : function(data) {


            response($.map(data, function (value, key) {
                console.log(value);
                return {
                    label: value.email,
                    value: value.email
                };
            }));

                   }
            });
         }
     });
  });
});

$("#menu-toggle").click(function(e) {
  e.preventDefault();
$("#wrapper").toggleClass("toggled");
});

$("#filterChoice").change(function(){
    var choice = $(this).val().toUpperCase();
    $("table tr").each(function (index) {
                if (index !== 0) {
                    $row = $(this);
                    var id = $row.find("td.type").text().toUpperCase();
                    if (id.indexOf(choice) == -1) {
                        $row.hide();
                    }
                    else {
                        $row.show();
                    }
                }
            });
});

$(document).ready(function() {
 setTimeout(function(){ 
        var x = document.getElementById("snackbar");
        x.className = "show";
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 1000);
       }, 2000)
    });

$(document).ready(function() {
	   $(function() {
	       $("#search").autocomplete({     
	           source : function(request, response) {
	             $.ajax({
	           headers: { 
	                'Accept': 'application/json',
	                'Content-Type': 'application/json' 
	            },
	                  url : "searchPatientByName",
	                  type : "GET",
	                  data : {
                       name : request.term
	                  },
	                  dataType : "json",
	                  success : function(data) {


	           response($.map(data, function (value, key) {
	               console.log(value);
                $("#patientId").val(value.id);
                var id = value.id;
	               return {
	                   label: value.firstName +" - [" +  id  + "]",
	                   value: value.firstName,
	               };
	           }));

	                  }
	           });
	        }
	    });
	 });
	});
$(document).ready(function(){

	    $("#specialisation").change(function(){
	        var specialisation = $(this).val();

	        $.ajax({
		           headers: { 
		                'Accept': 'application/json',
		                'Content-Type': 'application/json' 
		            },
	            url: 'displayPhysiciansBySpecialisation',
	            type: 'GET',
	            data: {
	            	specialisationName : specialisation
	            	},
	            dataType: 'json',
	            success:function(response){
	                var len = response.length;

	                $("#sel_user").empty();
	                for( var i = 0; i<len; i++) {
	                    var id = response[i]['id'];
	                    var name = response[i]['firstName'];
	                    $("#physicianId").val(id);
	                    $("#sel_user").append("<option value='"+id+"'>"+name+"</option>");

	                }
	            }
	        });
	    });

	});


