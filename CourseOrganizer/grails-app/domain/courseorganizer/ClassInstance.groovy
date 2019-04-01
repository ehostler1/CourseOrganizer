package courseorganizer
import java.util.Date

class ClassInstance {
	
	Integer crn
	
	String subject
	Integer courseNumber
	Integer section
	
	String title
	
	String days
	
	String beginHour
	String beginMinute
	String beginMeridiem
	String endHour
	String endMinute
	String endMeridiem
	
	String building
	Integer room
	
	String instructor
	
	Date beginDate
	Date endDate

    static constraints = {
		crn max: 12000
		crn min: 10000
		crn unique: true
		
		subject inList: ["","ACC","ANT","ARB","ART","BEH","BIO","CHM","CHN","CVE","CM","CS","CRW","CJA","ECH","ESS","ECO","EDU","ECE","EGR","ENT","FLM","FIN","FYS","FCM","FCO","FRN","BUS","G","GRM","GER","HIS","HSP","HSV","IFS","IA","IBS","INT","KT","LIT","MGT","MKT","MAT","ME","MLE","MUS","NUR","PHL","PAW","PSC","PHY","PS","PMD","PSY","PR","QBA","REC","REL","RT","SE","SOC","SPN","SPE","SPM","SCM","THE","WGS","WRT"]
		
		courseNumber max: 999
		courseNumber min: 100
		
		section max: 999
		section min: 100
		
		title size: 5..50
		
		days inList: ["","M","T","W","R","S","MWF","TR","MW"]
		
		beginHour inList: ["01","02","03","04","05","06","07","08","09","10","11","12"]
		beginMinute inList: ["00","05","10","15","20","25","30","35","40","45","50","55"]
		beginMeridiem inList: ["AM","PM"]
		
		endHour inList: ["01","02","03","04","05","06","07","08","09","10","11","12"]
		endMinute inList: ["00","05","10","15","20","25","30","35","40","45","50","55"]
		endMeridiem inList: ["AM","PM"]
		
		building inList: ["","CCE","CEC","CH","COMM","DHL","GC","GETTYS","GH","HOS","HUM","ICE","KEC","LAF","LIBRY","LS","MVA","NESC","ONLINE","PAC","RUDY","SCHOOL","STU","STUDY","SUBR","WALLOP","WBC","WOLF"]
		room max: 499
		room min: 1
		room nullable: true
		
		instructor nullable: true
		
		beginDate nullable: true
		endDate nullable: true
	}
}
