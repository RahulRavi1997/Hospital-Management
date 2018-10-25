$(document).ready(function () {
  $(function () {
    $("#autocomplete").autocomplete({
      source: function (request, response) {
        $.ajax({
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          url: "displayUserAutocomplete",
          type: "GET",
          data: {
            query: request.term + "%"
          },
          dataType: "json",
          success: function (data) {


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

$("#menu-toggle").click(function (e) {
  e.preventDefault();
  $("#wrapper").toggleClass("toggled");
});

$("#filterChoice").change(function () {
  var choice = $(this).val().toUpperCase();
  $("table tr").each(function (index) {
    if (index !== 0) {
      $row = $(this);
      var id = $row.find("td.type").text().toUpperCase();
      if (id.indexOf(choice) == -1) {
        $row.hide();
      } else {
        $row.show();
      }
    }
  });
});

$(document).ready(function () {
  setTimeout(function () {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () {
      x.className = x.className.replace("show", "");
    }, 1000);
  }, 2000)
});

$(document).ready(function () {
  $(function () {
    $("#search").autocomplete({
      source: function (request, response) {
        $.ajax({
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          url: "searchPatientByName",
          type: "GET",
          data: {
            name: request.term
          },
          dataType: "json",
          success: function (data) {
            response($.map(data, function (value, key) {
              if (value == []) {
                return {
                  label: "No Patients Found"
                };
              } else {
                console.log(value);
                $("#patientId").val(value.id);
                var id = value.id;
                return {
                  label: value.firstName + " - [" + id + "]",
                  value: value.firstName,
                };
              }
            }));

          }
        });
      }
    });
  });
});
$(document).ready(function () {

  $("#specialisation").change(function () {
    var specialisation = $(this).val();

    $.ajax({
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      url: 'displayPhysiciansBySpecialisation',
      type: 'GET',
      data: {
        specialisationName: specialisation
      },
      dataType: 'json',
      success: function (response) {
        var len = response.length;

        $("#sel_user").empty();
        for (var i = 0; i < len; i++) {
          var id = response[i]['id'];
          var name = response[i]['firstName'];
          $("#physicianId").val(id);
          $("#sel_user").append("<option value='" + id + "'>" + name + "</option>");

        }
      }
    });
  });
});
$(document).ready(function(){
	$("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
        if($.isNumeric(value)) {
	      $("#myTable tr").filter(function() {
	        $(this).toggle($(this).find("td:first").text().toLowerCase().indexOf(value) > -1)
	       });
	    } else {
	      $("#myTable tr").filter(function() {
	        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	      });
	    }
    });
});


$("#createButton").click(function (e) {
	  e.preventDefault();
	  $("#createTr").toggleClass("hidden");
	  $("#createButton").toggleClass("fa-plus");
	});

$(document).ready(function () {
    document.getElementById("age").value = GetAge()==0?"":GetAge();
       function onchange() {
           var birthDate = $('#birthDate');
           var age = $('#age');
           var a = GetAge(birthDate.val());
           if (a == 0) {
        	   age.val("");
           } else {
               age.val(a);
           }
       }
       $('#birthDate').on('change', onchange);
   });

function GetAge() {
   var today = new Date();
   var birthDate = new Date(document.getElementById('birthDate').value);
   var age = today.getFullYear() - birthDate.getFullYear();
   var m = today.getMonth() - birthDate.getMonth();
   if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
       age--;
   }
   if (isNaN(age)) {
	   age=0;
   }
   return age;
}

$(document).ready(function() {
   $(function() {
       $(".search").autocomplete({     
           source : function(request, response) { $.ajax({
           headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
                  url : "/getAllMedicines",
                  type : "GET",
                  data : {
                         search : this.term
                  },
                  dataType : "json",
                  success : function(data) {
                  response($.map(data, function(value, key) {
                  console.log(value);
                  return {
                   label: value.itemName,
                   value: value.itemName
               };
                 }));

                 }
           });
        }
    });
 });
});
$(document).ready(function() {
	   $(function() {
	       $("#searchMedicine").autocomplete({     
	           source : function(request, response) {
	             $.ajax({
	           headers: { 
	                'Accept': 'application/json',
	                'Content-Type': 'application/json' 
	            },
	                  url : "searchMedicineByName",
	                  type : "GET",
	                  data : {
                       name : request.term
	                  },
	                  dataType : "json",
	                  success : function(data) {
	           response($.map(data, function (value, key) {
	               console.log(value);
                $("#Id").val(value.id);
                var id = value.id;
	               return {
	                   label: value.name,
	                   value: value.name,
	               };
	           }));
	                  }
	           });
	        }
	    });
	 });
	});

function myFunction() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 50000);
} 
<<<<<<< HEAD


=======
>>>>>>> 1146a4ff88dc08992293823ca57a4a2c1b635bea
