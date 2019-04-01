package courseorganizer
import java.util.Collection

class ClassInstanceList {
	static hasMany = [classInstances:ClassInstance]
	
	String name
	Collection classInstances

    static constraints = {
		classInstances nullable: true
    }
}
