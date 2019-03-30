package courseorganizer

class Date {
	
	Integer month
	Integer day

    static constraints = {
		month range: 1..12
		day range: 1..31
    }
}
