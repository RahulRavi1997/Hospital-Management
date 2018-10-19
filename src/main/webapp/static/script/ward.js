$(document).ready(function () {

  $("#warddd").click(function () {
    var specialisation = $(this).val();
    $.ajax({
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      url: 'searchWardByNumber',
      type: 'GET',
      data: {
        wardNumber: specialisation
        
      },
      dataType: 'json',
      success: function (response) {
        var len = response.length;

        $("#seluser").empty();
        for (var i = 0; i < len; i++) {
          var id = response[i]['id'];
          var name = response[i]['roomNumber'];
          $("#roomid").val(name);
          $("#seluser").append("<option value='" + id + "'>" + name + "</option>");

        }
      }
    });
  });
});




$(document).ready(function () {

  $("#seluser").click(function () {
    var specialisation = $(roomid).val();
  console.log("your specialisation" +specialisation );
    $.ajax({
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      url: 'searchRoomByNumber',
      type: 'GET',
      data: {
        roomNumber: specialisation
        
      },
      dataType: 'json',
      success: function (response) {
        var len = response.length;

        $("#bedss").empty();
        for (var i = 0; i < len; i++) {
          var id = response[i]['id'];
          var name = response[i]['bedNumber'];
          $("#physicianId").val(id);
           $("#bedsId").val(name)
          $("#bedss").append("<option value='" + id + "'>" + name + "</option>");

        }
      }
    });
  });
});





