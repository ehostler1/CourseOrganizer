package courseorganizer

class HomeController {

	ClassInstanceService classInstanceService
	CombinationInstanceService combinationInstanceService
	
    def index() {
		respond classInstanceService.list(params), model:[classInstanceCount: classInstanceService.count()]
		respond combinationInstanceService.list(params), model:[combinationInstanceCount: combinationInstanceService.count()]
	}
	
	def generateCombinations() {
		
		def testOne = new ClassInstance(crn: '30000', subject: 'ACC', courseNumber: '100', sectionNumber: '100', title: 'Test One', days: 'M', beginHour: '1', beginMinute: '0', beginMeridiem: 'AM', endHour: '1', endMinute: '0', endMeridiem: 'PM', building: 'PAC')
		def testTwo = new ClassInstance(crn: '29000', subject: 'ACC', courseNumber: '100', sectionNumber: '100', title: 'Test Two', days: 'M', beginHour: '1', beginMinute: '0', beginMeridiem: 'AM', endHour: '1', endMinute: '0', endMeridiem: 'PM', building: 'PAC')
		combinationInstanceService.save(new CombinationInstance(combinationID: '0', classes: [testOne, testTwo]))
		
		//generation code HERE
		
		
		flash.message = "Class Combinations Generated"
		redirect action: 'index'
	}
}
