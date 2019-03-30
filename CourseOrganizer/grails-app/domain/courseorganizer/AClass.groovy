package courseorganizer

class AClass {
	static hasOne = [crn:CourseReferenceNumber,
		course:Course,
		days:Days]
	
	
	String title
	Time beginTime
	Time endTime
	String instructor
	Date beginDate
	Date endDate
	Location location
	

    static constraints = {
    }
}
