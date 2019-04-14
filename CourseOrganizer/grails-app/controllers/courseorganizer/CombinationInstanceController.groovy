package courseorganizer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CombinationInstanceController {

    CombinationInstanceService combinationInstanceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static scaffold = CombinationInstance

    def show(Long id) {
        respond combinationInstanceService.get(id)
    }

    def create() {
        respond new CombinationInstance(params)
    }

    def save(CombinationInstance combinationInstance) {
        if (combinationInstance == null) {
            notFound()
            return
        }

        try {
            combinationInstanceService.save(combinationInstance)
        } catch (ValidationException e) {
            respond combinationInstance.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'combinationInstance.label', default: 'CombinationInstance'), combinationInstance.id])
                redirect combinationInstance
            }
            '*' { respond combinationInstance, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond combinationInstanceService.get(id)
    }

    def update(CombinationInstance combinationInstance) {
        if (combinationInstance == null) {
            notFound()
            return
        }

        try {
            combinationInstanceService.save(combinationInstance)
        } catch (ValidationException e) {
            respond combinationInstance.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'combinationInstance.label', default: 'CombinationInstance'), combinationInstance.id])
                redirect combinationInstance
            }
            '*'{ respond combinationInstance, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        combinationInstanceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'combinationInstance.label', default: 'CombinationInstance'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'combinationInstance.label', default: 'CombinationInstance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
