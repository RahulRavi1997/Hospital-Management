$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  var $this = $(this),
    label = $this.prev('label');

  if (e.type === 'keyup') {
    if ($this.val() === '') {
      label.removeClass('active highlight');
    } else {
      label.addClass('active highlight');
    }
  } else if (e.type === 'blur') {
    if ($this.val() === '') {
      label.removeClass('active highlight');
    } else {
      label.removeClass('highlight');
    }
  } else if (e.type === 'focus') {

    if ($this.val() === '') {
      label.removeClass('highlight');
    } else if ($this.val() !== '') {
      label.addClass('highlight');
    }
  }
});

$('.tab a').on('click', function (e) {
  e.preventDefault();

  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');

  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();

  $(target).fadeIn(600);

});
var password = document.getElementById("password"),
  confirm_password = document.getElementById("confirmPassword");

function validatePassword() {
  if (password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

$(document).ready(function () {
  $(function () {
    $("#signupemail").autocomplete({
      source: function (request, response) {
        $.ajax({
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          url: "searchUser",
          type: "GET",
          data: {
            email: request.term
          },
          dataType: "json",
          success: function (data) {
            if ($.trim(data)) {

              response($.map(data, function (value, key) {
                console.log(value);
                $("#nonUniqueEmail").html(value.email + " is already registered");
              }));
            } else {
              $("#nonUniqueEmail").html("");
            }

          }
        });
      }
    });
  });
});

$(".reveal").on('click', function () {
  var $pwd = $(".pwd");
  if ($pwd.attr('type') === 'password') {
    $pwd.attr('type', 'text');
  } else {
    $pwd.attr('type', 'password');
  }
});