<!doctype html>
<html>
<head>
    <meta name="layout" content="general"/>
    <title>Course Organizer</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome ${name}!</h1>
        <g:if test="${flash.message}"> 
            <div class="message" role="status">${flash.message}</div>
        </g:if>

        <p>There are ${classTotal} classes in the database.</p>

        <g:form action="updateName" style="margin: 0 auto; width:320px"> 
            <g:textField name="name" value="" />
            <g:submitButton name="Update name" />
        </g:form>

    </section>
</div>

<ul>
	<g:each in="${courseorganizer.ClassInstance.list()}" var="classInstance">
		<li>
			<g:link controller="classInstance" action="show" id="${classInstance.id}">
				${classInstance.crn}
			</g:link>
			&nbsp; ${classInstance.subject}${classInstance.courseNumber}.${classInstance.section} &nbsp; ${classInstance.title} &nbsp; ${classInstance.days} &nbsp;
			${classInstance.beginHour}:${classInstance.beginMinute}${classInstance.beginMeridiem}-${classInstance.endHour}:${classInstance.endMinute}${classInstance.endMeridiem}
			&nbsp; ${classInstance.building} ${classInstance.room} &nbsp; ${classInstance.instructor} &nbsp; ${classInstance.beginDate}-${classInstance.endDate}
		</li>
	</g:each>
</ul>

</body>
</html>