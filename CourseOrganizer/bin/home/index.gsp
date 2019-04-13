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

        <g:form action="updateName" style="margin: 0 auto; width:320px"> 
            <g:textField name="name" value="" />
            <g:submitButton name="Update name" />
        </g:form>

    </section>
</div>

<div id="list-classInstance" class="content scaffold-list" role="main">
	<h1>Available Classes (total: ${classInstanceCount})</h1>
    <f:table collection="${classInstanceList}" properties="crn, course, title, days, beginTime, endTime, location, instructor, beginDate, endDate"/>

    <div class="pagination">
         <g:paginate total="${classInstanceCount ?: 0}" />
    </div>
</div>

</body>
</html>