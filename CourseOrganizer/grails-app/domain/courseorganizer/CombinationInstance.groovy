package courseorganizer

class CombinationInstance {

	Integer combinationID
	
	List<ClassInstance> combinationClasses
	List<Integer> crn
	List<String> course
	List<String> title
	List<String> days
	List<String> beginTime
	List<String> endTime
	List<String> location
	
	static hasMany = [combinationClasses:ClassInstance, crn:Integer, course:String, title:String, days:String, beginTime:String, endTime:String, location:String]
	
    static constraints = {
		combinationID unique: true
		
		combinationClasses nullable: true
		
		crn nullable: true
		
		course nullable: true
		
		title nullable: true
		
		days nullable: true
		
		beginTime nullable: true
		
		endTime nullable: true
		
		location nullable: true
    }
}
