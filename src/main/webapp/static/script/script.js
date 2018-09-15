  $(document).ready(function() {
    $(function() {
        $("#autocomplete").autocomplete({     
            source : function(request, response) {
              $.ajax({
           	  headers: { 
           	       'Accept': 'application/json',
           	       'Content-Type': 'application/json' 
           	   },
                   url : "displayUsers",
                   type : "GET",
                   data : {
                          query : request.term
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
