package courseorganizer

class Location {
	
	String building
	Integer room

    static constraints = {
		building inList: ["CCE","CEC","CH","COMM","DHL","GC","GETTYS","GH","HOS","HUM","ICE","KEC","LAF","LIBRY","LS","MVA","NESC","ONLINE","PAC","RUDY","SCHOOL","STU","STUDY","SUBR","WALLOP","WBC","WOLF"]
		room range: 1..499
    }
}
