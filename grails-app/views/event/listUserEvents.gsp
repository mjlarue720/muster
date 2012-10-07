

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="events" value="${events}" />
  <title>user events</title>
</head>
<body>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="home"/></a></span>
  </div>
  <div class="body">
    <h1>Existing events</h1>
    <div class="list">
      <table>
        <thead>
          <tr>
            <td>Event Name</td>
            <td>Description</td>
            <td>Event Date</td>
            <td>Location</td>
            <td>State</td>
          </tr>
        </thead>
        <tbody>
        <g:each in="${events}" status="i" var="thisEvent">
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td>"${thisEvent['name']}"</td>
            <td>"${thisEvent['description']}"</td>
            <td>"${thisEvent['eventDate']}"</td>
            <td>"${thisEvent['location']}"</td>
            <td>"${thisEvent['state']}"</td>
          </tr>
        </g:each>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>
