package courseorganizer

class Course {
	static belongsTo = [aClass:AClass]
	
	String subject
	Integer courseNumber
	Integer section

    static constraints = {
		subject inList: ["ACC","ANT","ARB","ART","BEH","BIO","CHM","CHN","CVE","CM","CS","CRW","CJA","ECH","ESS","ECO","EDU","ECE","EGR","ENT","FLM","FIN","FYS","FCM","FCO","FRN","BUS","G","GRM","GER","HIS","HSP","HSV","IFS","IA","IBS","INT","KT","LIT","MGT","MKT","MAT","ME","MLE","MUS","NUR","PHL","PAW","PSC","PHY","PS","PMD","PSY","PR","QBA","REC","REL","RT","SE","SOC","SPN","SPE","SPM","SCM","THE","WGS","WRT"]
		courseNumber range: 100..999
		section range: 100..999
    }
}
