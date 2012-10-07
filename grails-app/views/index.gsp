<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Welcome to Musters</title>
    <style type="text/css" media="screen">
    </style>
  </head>
  <body>
    <script type="text/javascript">        
        $(function() {
          $("#signInButton").click(function() {
            
            var userName = $("#userNameInput").val();
            var pwd = $('#passwordInput').val();
            var loginUrl = "/muster/person/login/userName=" + userName + "&pwd=" + pwd;
            
            $.ajax({
                url: loginUrl,
                type: "GET",
                dataType: "xml",
                cache: false,
                async: false,
                success: function (xml) {
                  var loginInfo = $(xml).find('loginInfo');
                  loginInfo.each(function() {
                    var isLoginSuccessful = $(this).find('isLoginSuccessful').text();
                    var uName = $(this).find('uName').text();
                    if(isLoginSuccessful="true") {
                      alert("Login is successful");
                      var listEventUrl = "/muster/event/listUserEvents/userName=" + userName;
                      alert(listEventUrl);
                      window.location.href = listEventUrl;
                    }
                    
                  });
                }


            });  

          });
        });
    </script>

    <a href="#page-body" class="skip"></a>
    <div class="desktop" id="musterLogin">
      <label class="username js-username">
        <span>Musteer ID</span>
        <input class="js-username-field email-input" type="text" id="userNameInput" name="session[username_or_email]" autocomplete="on">
      </label>
      <label class="password js-password">
        <span>Password</span>
        <input class="js-password-field" type="password" value="" id="passwordInput" name="session[password]">
      </label>
      <input type="submit" id="signInButton" value="Sign In"/>
    </div>
    <div class="front-signup js-front-signup">
      <h2><strong>Not yet a Musteer?</strong> Sign up</h2>
      <form action="/muster/person/create" class="signup" method="post">
        <div class="placeholding-input">
          <input type="text" id="signup-user-name" class="text-input" autocomplete="off" name="user[name]" maxlength="20">
          <label for="signup-user-name" class="placeholder">Full name</label>
        </div>
        <div class="placeholding-input">
          <input type="text" id="signup-user-email" class="text-input email-input" autocomplete="off" name="user[email]">
          <label for="signup-user-email" class="placeholder">Email</label>
        </div>
        <div class="placeholding-input">
          <input type="password" id="signup-user-password" class="text-input" name="user[user_password]">
          <label for="signup-user-password" class="placeholder">Password</label>
        </div>
        <button type="submit" class="btn signup-btn">
          Become a Musteer!
        </button>
      </form>
    </div>
    <div id="page-body" role="main">
    </div>
  </body>
</html>
