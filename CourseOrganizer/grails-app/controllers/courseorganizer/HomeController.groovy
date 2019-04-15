package courseorganizer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import java.util.ListIterator

class HomeController {

	ClassInstanceService classInstanceService
	CombinationInstanceService combinationInstanceService
	
    def index() {
		respond classInstanceService.list(params), model:[classInstanceCount: classInstanceService.count()]
		respond combinationInstanceService.list(params), model:[combinationInstanceCount: combinationInstanceService.count()]
	}
	
	def generateCombinations() {
		//generation code HERE
		
		//first obtain a list of all classes
		List<ClassInstance> classes = classInstanceService.list(params);
		
		//separate the classes into lists containing only one kind of subjectCourseNumber
		List<String> uniqueSubjectCourseNumbers = findSubjectCourseNumbers(classes);
		List<List<ClassInstance>> separatedClasses = separateClassesByCourse(classes, uniqueSubjectCourseNumbers);
		
		
		//iterate through the possible combinations and check their validity
		boolean morePossibleCombinations = true;
		List<Integer> combinationIndexes = new ArrayList<Integer>();
		for(int i = 0 ; i < separatedClasses.size() ; i++) {
			combinationIndexes.add(0);
		}
		List<ClassInstance> workingCombination = new ArrayList<ClassInstance>();
		for(int i = 0 ; i < combinationIndexes.size() ; i++) {
			workingCombination.add(separatedClasses.get(i).get(0));
		}
		while(morePossibleCombinations) {
			
			tryCombination(workingCombination);
			
			combinationIndexes = incrementCombinationIndexes(combinationIndexes, separatedClasses);
			
			for(int i = 0 ; i < combinationIndexes.size() ; i++) {
				workingCombination.set(i, separatedClasses.get(i).get(combinationIndexes.get(i)))
			}
			
			Integer maxIndexCount = 0
			for(int i = 0 ; i < combinationIndexes.size() ; i++) {
				if(combinationIndexes.get(i) + 1 >= separatedClasses.get(i).size()) {
					maxIndexCount++
				}
			}
			if(maxIndexCount == separatedClasses.size()) {
				morePossibleCombinations = false;
			}
		}
		
		flash.message = "Class Combinations Generated"
		redirect action: 'index'
	}
	
	def List<String> findSubjectCourseNumbers(List<ClassInstance> classes){
		//find the unique subjectCourseNumbers
		List<String> subjectCourseNumbers = new ArrayList<String>();
		for(int i = 0 ; i < classes.size() ; i++) {
			String subjectCourseNumber = classes.get(i).getSubjectCourseNumber();
			if(!subjectCourseNumbers.contains(subjectCourseNumber)) {
				subjectCourseNumbers.add(subjectCourseNumber);
			}
		}
		
		return subjectCourseNumbers;
	}
	
	def List<List<ClassInstance>> separateClassesByCourse(List<ClassInstance> classes, List<String> uniqueSubjectCourseNumbers){
		//separate the classes into lists containing only classes with the same subjectCourseNumbers
		List<List<ClassInstance>> seperatedClasses = new ArrayList<ArrayList<ClassInstance>>();
		for(int i = 0 ; i < uniqueSubjectCourseNumbers.size() ; i++) {
			
			List<ClassInstance> courseSections = new ArrayList<ClassInstance>();
			String courseSectionSubjectCourseNumber = uniqueSubjectCourseNumbers.get(i);
			
			for(int j = 0 ; j < classes.size() ; j++) {
				String subjectCourseNumber = classes.get(j).getSubjectCourseNumber();
				if(subjectCourseNumber == courseSectionSubjectCourseNumber) {
					courseSections.add(classes.get(j));
				}
			}
			
			seperatedClasses.add(courseSections);
		}
		
		return seperatedClasses;
	}
	
	def void tryCombination(List<ClassInstance> currentCombination) {
		boolean isValid = true
		for(int classOneIndex = 0; classOneIndex < currentCombination.size() ; classOneIndex++) {
			if(!isValid) {
				break
			}
			for(int classTwoIndex = 0; classTwoIndex < currentCombination.size() ; classTwoIndex++) {
				if(!timeDoesNotOverlap(currentCombination.get(classOneIndex), currentCombination.get(classTwoIndex))) {
					isValid = false
				}
			}
		}
		
		if(isValid) {
			def validCombination = new CombinationInstance();
			validCombination.setCombinationID((Integer)combinationInstanceService.count() + 1);
			validCombination.addToClasses(currentCombination);
			validCombination.save();
		}
	}
	
	def boolean timeDoesNotOverlap(ClassInstance classOne, ClassInstance classTwo) {
		String daysOne = classOne.getDays();
		String daysTwo = classTwo.getDays();
		
		if(daysOne.contains("M") && daysTwo.contains("M"))
		(daysOne.contains("T") && daysTwo.contains("T"))||
		(daysOne.contains("W") && daysTwo.contains("W"))||
		(daysOne.contains("R") && daysTwo.contains("R"))||
		(daysOne.contains("F") && daysTwo.contains("F"))||
		(daysOne.contains("S") && daysTwo.contains("S")){
			Integer beginOne = classOne.getBeginTimeMinutes();
			Integer	endOne = classOne.getEndTimeMinutes();
			Integer beginTwo = classTwo.getBeginTimeMinutes();
			Integer endTwo = classTwo.getEndTimeMinutes();
			
			if((beginOne < beginTwo && endOne > beginTwo)||(beginTwo < beginOne && endTwo > beginOne)) {
				return false
			}
		}
		else {
			return true
		}	
	}
	
	def List<Integer> incrementCombinationIndexes(List<Integer> combinationIndexes, List<List<ClassInstance>> separatedClasses){
		List<Integer> newCombinationIndexes = new ArrayList<Integer>();
		boolean incrementNext = true
		for(int i = 0 ; i < combinationIndexes.size() ; i++) {
			if(incrementNext) {
				if(combinationIndexes.get(i) + 1 >= separatedClasses.get(i).size()) {
					newCombinationIndexes.add(0);
					incrementNext = true;
				}
				else {
					newCombinationIndexes.add(combinationIndexes.get(i) + 1);
					incrementNext = false;
				}
			}
		}
		
		return newCombinationIndexes;
	}	
}
