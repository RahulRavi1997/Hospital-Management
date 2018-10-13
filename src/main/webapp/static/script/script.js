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

