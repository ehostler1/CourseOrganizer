package courseorganizer

class ClassCombinations {
	static hasMany = [combination:PossibleCombination]
	

    static constraints = {
		combination unique: true
    }
}
