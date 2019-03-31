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

        <p>There are ${aClassTotal} classes in the database.</p>

        <ul>
        <g:each in="${courseorganizer.AClass.list()}" var="aClass">
            <li>
                <g:link controller="aClass" action="show" id="${aClass.id}">
                    ${aClass.title}
                </g:link>
            </li>
        </g:each>
        </ul>

        <g:form action="updateName" style="margin: 0 auto; width:320px"> 
            <g:textField name="name" value="" />
            <g:submitButton name="Update name" />
        </g:form>

    </section>
</div>

</body>
</html>