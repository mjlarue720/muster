<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=no;"/>
    <link rel="apple-touch-startup-image" href="splash-screen.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon-precomposed" href="http://santaclaritaapp.com/sites/default/files/Lrg-App-Logo_0.png" />
    <g:javascript src="browserUtil.js"/>
    <g:javascript library="jquery" plugin="jquery"/>
    <script type="text/javascript">        
        var cssFile = (navigator.userAgent.match(/iPhone|iPad|iPod|Android/i))? "css/jquery.mobile-1.2.0.min.css" : "css/main.css";
        var cssStmt = '<link href="'+ cssFile + '" type="text/css" rel="stylesheet">';
        document.write(cssStmt);
    </script>
  <g:layoutHead/>
  <r:layoutResources />
</head>
<body>
  <div id="grailsLogo" role="banner"><a href="/muster"><img src="${resource(dir: 'images', file: 'muster_logo.png')}"/></a></div>
<g:layoutBody/>
<div class="footer" role="contentinfo"></div>
<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<g:javascript library="application"/>
<r:layoutResources />
</body>
</html>