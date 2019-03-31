package courseorganizer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AClassController {

    AClassService AClassService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AClassService.list(params), model:[AClassCount: AClassService.count()]
    }

    def show(Long id) {
        respond AClassService.get(id)
    }

    def create() {
        respond new AClass(params)
    }

    def save(AClass AClass) {
        if (AClass == null) {
            notFound()
            return
        }

        try {
            AClassService.save(AClass)
        } catch (ValidationException e) {
            respond AClass.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'AClass.label', default: 'AClass'), AClass.id])
                redirect AClass
            }
            '*' { respond AClass, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond AClassService.get(id)
    }

    def update(AClass AClass) {
        if (AClass == null) {
            notFound()
            return
        }

        try {
            AClassService.save(AClass)
        } catch (ValidationException e) {
            respond AClass.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AClass.label', default: 'AClass'), AClass.id])
                redirect AClass
            }
            '*'{ respond AClass, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        AClassService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AClass.label', default: 'AClass'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'AClass.label', default: 'AClass'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
