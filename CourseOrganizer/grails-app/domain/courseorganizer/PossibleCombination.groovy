package courseorganizer

class PossibleCombination {
	static belongsTo = [classCombinations:ClassCombinations]
	static hasMany = [possibleCombinationClass:AClass]

    static constraints = {
    }
}
