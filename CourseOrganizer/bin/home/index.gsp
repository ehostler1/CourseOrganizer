<!doctype html>
<html>
<head>
    <meta name="layout" content="general"/>
    <title>Course Organizer</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Course Organizer</h1>
        <g:if test="${flash.message}"> 
            <div class="message" role="status">${flash.message}</div>
        </g:if>
    </section>
</div>

<div id="list-classInstance" class="content scaffold-list" role="main">
	<h1>Available Classes (total: ${classInstanceCount})</h1>
    <f:table collection="${classInstanceList}" properties="crn, course, title, days, beginTime, endTime, location, instructor, beginDate, endDate"/>

    <div class="pagination">
         <g:paginate total="${classInstanceCount ?: 0}" />
    </div>
    
    <g:form action="generateCombinations" style="width:320px"> 
         <g:submitButton name="Generate" />
    </g:form>
</div>

<div id="list-combinationInstance" class="content scaffold-list" role="main">
	<h1>Possible Combinations (total: ${combinationInstanceCount})</h1>
    <f:table collection="${combinationInstanceList}" properties="combinationID, combinationClasses, crn, course, title, days, beginTime, endTime, location"/>

    <div class="pagination">
         <g:paginate total="${classInstanceCount ?: 0}" />
    </div>
</div>

</body>
</html>