package courseorganizer

class PossibleCombination {
	static belongsTo = [classCombinations:ClassCombinations]
	static hasMany = [classes:AClass]

    static constraints = {
    }
}
