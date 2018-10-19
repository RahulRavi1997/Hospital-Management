$(document).ready(function() {
	   $(function() {
	       $(".dosage").autocomplete({     
	           source : function(request, response) { $.ajax({
	           headers: { 
	                'Accept': 'application/json',
	                'Content-Type': 'application/json' 
	            },
	                  url  : "/getAllDosage",
	                  type : "GET",
	                  data : {
	                       dosage : this.term
	                  },
	                  dataType : "json",
	                  success : function(data) {
	                  response($.map(data, function(value, key) {
	                  console.log(value);
	                  $(".days").keyup(function () {
	                	  var dosages = ($(this).closest("tr").find(".dosage").val()).split("-");
	                	  var count = 0;
	                	  for (i = 0; i < dosages.length; i++) {
	                		  count += parseInt(dosages[i]);
	                      } 
	                	  console.log($(this).closest('tr').find(".days").val());
	                	  count = count*parseInt($(this).closest('tr').find(".days").val());
	                	  console.log(count);
	                      $(this).closest('tr').find(".dosageQuantity").val(count);
	                  });
	                  return {
	                  label: value.dosage,
	                  value: value.dosage
	                  };
	                  }));

	                 }
	           });
	        }
	    });
	 });
	});





