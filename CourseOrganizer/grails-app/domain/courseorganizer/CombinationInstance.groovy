package courseorganizer

class CombinationInstance {

	Integer combinationID
	static hasMany = [classes:ClassInstance, crn:Integer, course:String, title:String, days:String, beginTime:String, endTime:String, location:String]
	
    static constraints = {
		combinationID unique: true
		
		classes nullable: true
		
		crn nullable: true
		
		course nullable: true
		
		title nullable: true
		
		days nullable: true
		
		beginTime nullable: true
		
		endTime nullable: true
		
		location nullable: true
    }
	
	def updateComplexItems() {
		
	}
}
