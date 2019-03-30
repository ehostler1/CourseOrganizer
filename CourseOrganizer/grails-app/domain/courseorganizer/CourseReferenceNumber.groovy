package courseorganizer

class CourseReferenceNumber {
	
	Integer crn

    static constraints = {
		crn range: 10000..99999
    }
}
