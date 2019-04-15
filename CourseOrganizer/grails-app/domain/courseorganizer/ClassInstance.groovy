package courseorganizer
import java.util.Calendar

class ClassInstance {
	
	Integer crn
	
	String subject
	Integer courseNumber
	Integer sectionNumber
	
	//display item for subject courseNumber and sectionNumber
	String course
	
	String title
	
	String days
	
	Integer beginHour
	Integer beginMinute
	String beginMeridiem
	Integer endHour
	Integer endMinute
	String endMeridiem
	
	//display item for time
	String beginTime
	String endTime
	
	String building
	Integer room
	
	//display item for building and room
	String location
	
	String instructor
	
	Date startDate
	Date finishDate
	
	//display item for dates
	String beginDate
	String endDate
	
	//values for combination generation
	String subjectCourseNumber
	Integer beginTimeMinutes
	Integer endTimeMinutes

    static constraints = {
		
		crn max: 30000
		crn min: 10000
		crn unique: true
		
		subject inList: ["","ACC","ANT","ARB","ART","BEH","BIO","CHM","CHN","CVE","CM","CS","CRW","CJA","ECH","ESS","ECO","EDU","ECE","EGR","ENT","FLM","FIN","FYS","FCM","FCO","FRN","BUS","G","GRM","GER","HIS","HSP","HSV","IFS","IA","IBS","INT","KT","LIT","MGT","MKT","MAT","ME","MLE","MUS","NUR","PHL","PAW","PSC","PHY","PS","PMD","PSY","PR","QBA","REC","REL","RT","SE","SOC","SPN","SPE","SPM","SCM","THE","WGS","WRT"]
		courseNumber max: 999
		courseNumber min: 100
		sectionNumber max: 999
		sectionNumber min: 100
		
		course display: false
		course nullable: true
		
		title size: 5..50
		
		days inList: ["","M","T","W","R","S","M W F","T R","M W"]
		
		beginHour max: 12
		beginHour min: 1
		beginMinute max: 59
		beginMinute min: 0
		beginMeridiem inList: ["AM","PM"]
		endHour max: 12
		endHour min: 1
		endMinute max: 59
		endMinute min: 0
		endMeridiem inList: ["AM","PM"]
		
		beginTime display: false
		beginTime nullable: true
		endTime display: false
		endTime nullable: true
		
		building inList: ["","CCE","CEC","CH","COMM","DHL","GC","GETTYS","GH","HOS","HUM","ICE","KEC","LAF","LIBRY","LS","MVA","NESC","ONLINE","PAC","RUDY","SCHOOL","STU","STUDY","SUBR","WALLOP","WBC","WOLF"]
		room max: 499
		room min: 1
		room nullable: true
		
		location display: false
		location nullable: true
		
		instructor nullable: true
		
		startDate nullable: true
		finishDate nullable: true
		
		beginDate display: false
		beginDate nullable: true
		endDate display: false
		endDate nullable: true
		
		//constraints for values for combination generation
		subjectCourseNumber display: false
		subjectCourseNumber nullable: true
		subjectCourseNumber size: 6..6
		beginTimeMinutes display: false
		beginTimeMinutes nullable: true
		beginTimeMinutes range: 1..1440
		endTimeMinutes display: false
		endTimeMinutes nullable: true
		endTimeMinutes range: 1..1440
	}
	
	def updateComplexItems() {
		//update the course
		this.setCourse(this.subject + this.courseNumber + "." + this.sectionNumber)
		
		//update the begin and end times
		String begin = new String()
		String end = new String()
		
		if(this.beginHour < 10) {
			begin += "0"
		}
		begin += this.beginHour + ":"
		
		
		if(this.beginMinute < 10) {
			begin += "0"
		}
		begin += this.beginMinute + " " + this.beginMeridiem
		
		if(this.endHour < 10) {
			end += "0"
		}
		end += this.endHour + ":"
		
		
		if(this.endMinute < 10) {
			end += "0"
		}
		end += this.endMinute + " " + this.endMeridiem
		
		this.setBeginTime(begin)
		this.setEndTime(end)
		
		//update location
		if(this.room != null) {
			this.setLocation(this.building + " " + this.room)
		}
		else {
			this.setLocation(this.building)
		}
		
		//update begin and end dates
		Integer month
		Integer day
		Integer year
		
		if(this.startDate != null) {
			month = this.startDate.calendarDate.getMonth()
			day = this.startDate.calendarDate.getDayOfMonth()
			year = this.startDate.calendarDate.getYear()
			
			this.setBeginDate(month + " / " + day + " / " + year)
		}
		else {
			this.setBeginDate("")
		}
		
		if(this.finishDate != null) {
		month = this.finishDate.calendarDate.getMonth()
		day = this.finishDate.calendarDate.getDayOfMonth()
		year = this.finishDate.calendarDate.getYear()
		
		this.setEndDate(month + " / " + day + " / " + year)
		}
		else {
			this.setEndDate("")
		}
		
		//update subjectCourseNumber
		this.setSubjectCourseNumber(this.subject + this.courseNumber)
		
		//update begin and end time minutes
		Integer minutes = 0
		
		if(this.beginMeridiem == "PM") {
			minutes += 720
		}
		minutes += this.beginHour * 60
		minutes += this.beginMinute
		
		this.setBeginTimeMinutes(minutes)
		
		minutes = 0
		
		if(this.endMeridiem == "PM") {
			minutes += 720
		}
		minutes += this.endHour * 60
		minutes += this.endMinute
		
		this.setEndTimeMinutes(minutes)
	}
}
