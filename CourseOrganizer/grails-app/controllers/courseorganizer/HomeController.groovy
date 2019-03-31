package courseorganizer

class HomeController {

    def index() {
		respond([name: session.name ?: 'User', classTotal: ClassInstance.count()])
	}
	
	def updateName(String name) {
		session.name = name

		flash.message = "Name has been updated"

		redirect action: 'index'
	}
}
