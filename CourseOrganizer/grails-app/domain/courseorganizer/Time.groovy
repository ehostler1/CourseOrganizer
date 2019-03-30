package courseorganizer

class Time {
	
	String meridiem
	Integer hour
	Integer minute

    static constraints = {
		meridiem inList: ["am","pm"]
		hour range: 1..12
		minute range: 0..59
    }
}
