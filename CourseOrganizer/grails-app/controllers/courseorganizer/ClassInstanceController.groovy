package courseorganizer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClassInstanceController {

    ClassInstanceService classInstanceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond classInstanceService.list(params), model:[classInstanceCount: classInstanceService.count()]
    }

    def show(Long id) {
        respond classInstanceService.get(id)
    }

    def create() {
        respond new ClassInstance(params)
    }

    def save(ClassInstance classInstance) {
        if (classInstance == null) {
            notFound()
            return
        }

        try {
			classInstance.updateComplexItems()
            classInstanceService.save(classInstance)
        } catch (ValidationException e) {
            respond classInstance.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'classInstance.label', default: 'ClassInstance'), classInstance.id])
                redirect controller: "home"
            }
            '*' { respond classInstance, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond classInstanceService.get(id)
    }

    def update(ClassInstance classInstance) {
        if (classInstance == null) {
            notFound()
            return
        }

        try {
			classInstance.updateComplexItems()
            classInstanceService.save(classInstance)
        } catch (ValidationException e) {
            respond classInstance.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'classInstance.label', default: 'ClassInstance'), classInstance.id])
                redirect classInstance
            }
            '*'{ respond classInstance, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        classInstanceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'classInstance.label', default: 'ClassInstance'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'classInstance.label', default: 'ClassInstance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
