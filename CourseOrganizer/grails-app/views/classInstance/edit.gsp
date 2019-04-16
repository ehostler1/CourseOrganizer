<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="general" />
        <g:set var="entityName" value="${message(code: 'classInstance.label', default: 'ClassInstance')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="edit-classInstance" class="content scaffold-edit" role="main">
            <h1>Edit Mode</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.classInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.classInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.classInstance}" method="PUT">
                <g:hiddenField name="version" value="${this.classInstance?.version}" />
                <fieldset class="form">
                    <f:all bean="classInstance"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
