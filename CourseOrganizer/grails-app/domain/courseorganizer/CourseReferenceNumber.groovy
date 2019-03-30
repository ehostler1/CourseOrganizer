package courseorganizer

class CourseReferenceNumber {
	static belongsTo = [class:Class]
	
	Integer crn

    static constraints = {
		crn range: 10000..99999
    }
}
