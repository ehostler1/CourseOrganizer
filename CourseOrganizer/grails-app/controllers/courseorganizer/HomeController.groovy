package courseorganizer

class HomeController {

	ClassInstanceService classInstanceService
	CombinationInstanceService combinationInstanceService
	
    def index() {
		respond classInstanceService.list(params), model:[classInstanceCount: classInstanceService.count()]
		respond combinationInstanceService.list(params), model:[combinationInstanceCount: combinationInstanceService.count()]
	}
	
	def generateCombinations() {
		
		//generation code HERE
		
		
		flash.message = "Class Combinations Generated"
		redirect action: 'index'
	}
}
