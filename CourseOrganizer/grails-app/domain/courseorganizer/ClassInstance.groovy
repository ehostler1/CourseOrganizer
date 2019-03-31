package courseorganizer

class ClassInstance {
	
	Integer crn
	
	String subject
	Integer courseNumber
	Integer section
	
	String title
	
	String days
	
	Integer beginHour
	Integer beginMinute
	String beginMeridiem
	Integer endHour
	Integer endMinute
	String endMeridiem
	
	String building
	Integer room
	
	String instructor
	
	Integer beginMonth
	Integer beginDay
	Integer beginYear
	Integer endMonth
	Integer endDay
	Integer endYear

    static constraints = {
		crn max: 12000
		crn min: 10000
		crn unique: true
		
		subject inList: ["ACC","ANT","ARB","ART","BEH","BIO","CHM","CHN","CVE","CM","CS","CRW","CJA","ECH","ESS","ECO","EDU","ECE","EGR","ENT","FLM","FIN","FYS","FCM","FCO","FRN","BUS","G","GRM","GER","HIS","HSP","HSV","IFS","IA","IBS","INT","KT","LIT","MGT","MKT","MAT","ME","MLE","MUS","NUR","PHL","PAW","PSC","PHY","PS","PMD","PSY","PR","QBA","REC","REL","RT","SE","SOC","SPN","SPE","SPM","SCM","THE","WGS","WRT"]
		
		courseNumber max: 999
		courseNumber min: 100
		
		section max: 999
		section min: 100
		
		title size: 5..50
		
		days inList: ["M","T","W","R","S","MWF","TR","MW"]
		
		beginMeridiem inList: ["am","pm"]
		beginHour max: 12
		beginHour min: 1
		beginMinute max: 59
		beginMinute min: 0
		
		endMeridiem inList: ["am","pm"]
		endHour max: 12
		endHour min: 1
		endMinute max: 59
		endMinute min: 0
		
		building inList: ["CCE","CEC","CH","COMM","DHL","GC","GETTYS","GH","HOS","HUM","ICE","KEC","LAF","LIBRY","LS","MVA","NESC","ONLINE","PAC","RUDY","SCHOOL","STU","STUDY","SUBR","WALLOP","WBC","WOLF"]
		room max: 499
		room min: 1
		room nullable: true
		
		instructor nullable: true
		
		beginMonth max: 12
		beginMonth min: 1
		beginMonth nullable: true
		beginDay max: 31
		beginDay min: 1
		beginDay nullable: true
		beginYear max: 99
		beginYear min: 0
		beginYear nullable: true
		
		endMonth max: 12
		endMonth min: 1
		endMonth nullable: true
		endDay max: 31
		endDay min: 1
		endDay nullable: true
		endYear max: 99
		endYear min: 0
		endYear nullable: true
    }
}
