<table>
    <thead>
         <tr>
            <g:each in="${columnProperties}" var="p" status="i">
                <g:sortableColumn property="${p.property}" title="${p.label}"/>
            </g:each>
        </tr>
    </thead>
    <tbody>
        <g:each in="${collection}" var="bean" status="i">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <g:each in="${columnProperties}" var="p" status="j">
                    <g:if test="${j==0 && p.property == "crn"}">
                        <td><g:link method="GET" resource="${bean}"><f:display bean="${bean}" property="${p.property}" displayStyle="${displayStyle?:'table'}" theme="${theme}"/></g:link></td>
                    </g:if>
                    <g:else>
                    	<g:if test="${p.type == java.util.List}">
                        	<td>
                        		<g:each in="${bean.(p.property)}" var="item" status="k">
                        			<p>${item}</p>
                        		</g:each>
                        	</td>
                    	</g:if>
                    	<g:else>
                        	<td><f:display bean="${bean}" property="${p.property}"  displayStyle="${displayStyle?:'table'}" theme="${theme}"/></td>
                        </g:else>
                    </g:else>
                </g:each>
            </tr>
        </g:each>
    </tbody>
</table>