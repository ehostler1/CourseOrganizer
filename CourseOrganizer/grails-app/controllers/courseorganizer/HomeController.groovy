package courseorganizer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import javax.tools.ForwardingFileObject

import org.grails.web.i18n.ParamsAwareLocaleChangeInterceptor

class HomeController {

	ClassInstanceService classInstanceService
	CombinationInstanceService combinationInstanceService
	
    def index(Integer max) {
		
		def classBindingMap
		def combinationBindingMap
		
		if(params.sort == "combinationID") {
			combinationBindingMap = params
		}
		else {
			classBindingMap = params
		}
		
		respond classInstanceService.list(classBindingMap), model:[classInstanceCount: classInstanceService.count()]
		respond combinationInstanceService.list(combinationBindingMap), model:[combinationInstanceCount: combinationInstanceService.count()]
	}
	
	def generateCombinations() {
		
		//remove previous combinations
		List<CombinationInstance> combinations = combinationInstanceService.list(params);
		for(int i = 0 ; i < combinations.size() ; i++ ) {
			combinationInstanceService.delete(combinations.get(i).getId());
		}
		
		//generation code HERE
		System.out.println("################# BEGINNING GENERATION #################");
		
		//first obtain a list of all classes
		List<ClassInstance> classes = classInstanceService.list(params);
		System.out.println("Number of classes generator recieved: "+ classes.size());
		
		//separate the classes into lists containing only one kind of subjectCourseNumber
		List<String> uniqueSubjectCourseNumbers = findSubjectCourseNumbers(classes);
		System.out.println("Number of unique subjectCourseNumbers found: "+ uniqueSubjectCourseNumbers.size());
		List<List<ClassInstance>> separatedClasses = separateClassesByCourse(classes, uniqueSubjectCourseNumbers);
		System.out.println("Number of unique courses found: "+ separatedClasses.size() +" (should match the number of unique subjectCourseNumbers)");
		
		
		
		//iterate through the possible combinations and check their validity
		boolean morePossibleCombinations = true;
		List<Integer> combinationIndexes = new ArrayList<Integer>();
		for(int i = 0 ; i < separatedClasses.size() ; i++) {
			
			combinationIndexes.add(0);
		}
		System.out.println("Initial combination indexes generated: "+ combinationIndexes.toString() +" (should match the number of unique courses)");
		
		List<ClassInstance> workingCombination = new ArrayList<ClassInstance>();
		for(int i = 0 ; i < combinationIndexes.size() ; i++ ) {
			
			workingCombination.add(separatedClasses.get(i).get(0));
		}
		System.out.println("Working combination initialized to: "+ workingCombination.toString());
		
		Integer maxIndexCount = 0;
		while(morePossibleCombinations) {
			
			tryCombination(workingCombination);
			
			combinationIndexes = incrementCombinationIndexes(combinationIndexes, separatedClasses);
			
			for(int i = 0 ; i < combinationIndexes.size() ; i++) {
				
				workingCombination.set(i, separatedClasses.get(i).get(combinationIndexes.get(i)))
			}
			
			if(maxIndexCount == separatedClasses.size()) {
				morePossibleCombinations = false;
			}
			
			maxIndexCount = 0
			for(int i = 0 ; i < combinationIndexes.size() ; i++) {
				
				if(combinationIndexes.get(i) + 1 >= separatedClasses.get(i).size()) {
					maxIndexCount++
				}
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
	
	def void tryCombination(ArrayList<ClassInstance> currentCombination) {
		boolean isValid = true
		for(int classOneIndex = 0; classOneIndex < currentCombination.size() ; classOneIndex++) {
			
			if(!isValid) {
				break
			}
			for(int classTwoIndex = 0; classTwoIndex < currentCombination.size() ; classTwoIndex++) {
				
				if(classOneIndex != classTwoIndex && !timeDoesNotOverlap(currentCombination.get(classOneIndex), currentCombination.get(classTwoIndex))) {
					isValid = false
				}
			}
		}
		
		if(isValid) {
			System.out.println("Attempting to add valid combination to database:"+ currentCombination.toString());
			
			//create crn, course, title, days, beginTime, endTime, and location lists
			List<Integer> currentCombinationCrns = new ArrayList<Integer>();
			List<String> currentCombinationCourses = new ArrayList<String>();
			List<String> currentCombinationTitles = new ArrayList<String>();
			List<String> currentCombinationDays = new ArrayList<String>();
			List<String> currentCombinationBeginTimes = new ArrayList<String>();
			List<String> currentCombinationEndTimes = new ArrayList<String>();
			List<String> currentCombinationLocations = new ArrayList<String>();
			
			for(int i = 0 ; i < currentCombination.size() ; i++) {
				
				currentCombinationCrns.add(currentCombination.get(i).getCrn());
				currentCombinationCourses.add(currentCombination.get(i).getCourse());
				currentCombinationTitles.add(currentCombination.get(i).getTitle());
				currentCombinationDays.add(currentCombination.get(i).getDays());
				currentCombinationBeginTimes.add(currentCombination.get(i).getBeginTime());
				currentCombinationEndTimes.add(currentCombination.get(i).getEndTime());
				currentCombinationLocations.add(currentCombination.get(i).getLocation());
				
			}
			
			def validCombination = new CombinationInstance(
				combinationID: (Integer)combinationInstanceService.count() + 1, 
				combinationClasses: currentCombination,
				crn: currentCombinationCrns,
				course: currentCombinationCourses,
				title: currentCombinationTitles,
				days: currentCombinationDays,
				beginTime: currentCombinationBeginTimes,
				endTime: currentCombinationEndTimes,
				location: currentCombinationLocations);
			
			combinationInstanceService.save(validCombination);
		}
	}
	
	def boolean timeDoesNotOverlap(ClassInstance classOne, ClassInstance classTwo) {
		
		String daysOne = classOne.getDays();
		String daysTwo = classTwo.getDays();
		Integer beginOne = classOne.getBeginTimeMinutes();
		Integer	endOne = classOne.getEndTimeMinutes();
		Integer beginTwo = classTwo.getBeginTimeMinutes();
		Integer endTwo = classTwo.getEndTimeMinutes();
		
		if(daysOne.contains(daysTwo) || daysTwo.contains(daysOne)) {
			if((beginOne + endOne)/2 < (beginTwo + endTwo)/2 && endOne > beginTwo) {
				return false
			}
			if((beginOne + endOne)/2 > (beginTwo + endTwo)/2 && endTwo > beginOne) {
				return false
			}
		}
		
		return true
			
	}
	
	def List<Integer> incrementCombinationIndexes(List<Integer> combinationIndexes, List<List<ClassInstance>> separatedClasses){
		
		List<Integer> newCombinationIndexes = new ArrayList<Integer>();
		boolean incrementNext = true
		for(int i = 0 ; i < combinationIndexes.size() ; i++) {
			
			if(incrementNext) {
				if(combinationIndexes.get(i) >= separatedClasses.get(i).size() - 1) {
					newCombinationIndexes.add(0);
					incrementNext = true;
				}
				else {
					newCombinationIndexes.add(combinationIndexes.get(i) + 1);
					incrementNext = false;
				}
			}
			else {
				newCombinationIndexes.add(combinationIndexes.get(i));
			}
		}
		
		System.out.println("New combination indexes: "+ newCombinationIndexes.toString());
		return newCombinationIndexes;
	}	
}
