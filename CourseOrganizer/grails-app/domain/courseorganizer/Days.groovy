package courseorganizer

class Days {
	
	String days

    static constraints = {
		days inList: ["M","T","W","R","S","MWF","TR","MW"]
    }
}
