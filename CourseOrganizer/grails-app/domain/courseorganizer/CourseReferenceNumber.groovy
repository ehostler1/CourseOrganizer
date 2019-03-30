package courseorganizer

class CourseReferenceNumber {
	static belongsTo = [aClass:AClass]
	
	Integer crn

    static constraints = {
		crn range: 10000..12000
    }
}
