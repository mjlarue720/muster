<%@ page import="muster.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="event.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${eventInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="event.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${eventInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="event.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${eventInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'state', 'error')} ">
	<label for="state">
		<g:message code="event.state.label" default="State" />
		
	</label>
	<g:textField name="state" value="${eventInstance?.state}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="event.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${eventInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'quorum', 'error')} required">
	<label for="quorum">
		<g:message code="event.quorum.label" default="Quorum" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quorum" type="number" value="${eventInstance.quorum}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'eventDate', 'error')} required">
	<label for="eventDate">
		<g:message code="event.eventDate.label" default="Event Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="eventDate" precision="day"  value="${eventInstance?.eventDate}"  />
</div>

