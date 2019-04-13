package courseorganizer

class HomeController {

	ClassInstanceService classInstanceService
	
    def index() {
		respond name: session.name ?: 'User', model:[classInstanceCount: classInstanceService.count()], classInstanceService.list(params)
	}
	
	def updateName(String name) {
		session.name = name

		flash.message = "Name has been updated"

		redirect action: 'index'
	}
}
