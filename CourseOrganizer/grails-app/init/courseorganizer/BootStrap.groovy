package courseorganizer

class BootStrap {

    def init = { servletContext ->
		
		ClassInstanceService classInstanceService
		
		boolean test = true
		if(test) {
			def classOne = new ClassInstance(
				crn: '10161', 
				subject: 'CS', 
				courseNumber: '420', 
				sectionNumber: '101', 
				title: 'Operating Systems', 
				days: 'M W F', 
				beginHour: '1', 
				beginMinute: '0', 
				beginMeridiem: 'PM', 
				endHour: '1', 
				endMinute: '50', 
				endMeridiem: 'PM', 
				building: 'KEC',
				room: '119',
				instructor: 'Moscola J')
			
			def classTwo = new ClassInstance(
				crn: '10163',
				subject: 'CS',
				courseNumber: '420',
				sectionNumber: '102',
				title: 'Operating Systems',
				days: 'M W F',
				beginHour: '2',
				beginMinute: '0',
				beginMeridiem: 'PM',
				endHour: '2',
				endMinute: '50',
				endMeridiem: 'PM',
				building: 'KEC',
				room: '119',
				instructor: 'Moscola J')
			
			def classThree = new ClassInstance(
				crn: '10156',
				subject: 'CS',
				courseNumber: '350',
				sectionNumber: '101',
				title: 'Data Structures',
				days: 'T R',
				beginHour: '12',
				beginMinute: '30',
				beginMeridiem: 'PM',
				endHour: '1',
				endMinute: '45',
				endMeridiem: 'PM',
				building: 'KEC',
				room: '119',
				instructor: 'Moscola J')
			
			def classFour = new ClassInstance(
				crn: '10157',
				subject: 'CS',
				courseNumber: '350',
				sectionNumber: '102',
				title: 'Data Structures',
				days: 'T R',
				beginHour: '2',
				beginMinute: '0',
				beginMeridiem: 'PM',
				endHour: '3',
				endMinute: '15',
				endMeridiem: 'PM',
				building: 'KEC',
				room: '119',
				instructor: 'Moscola J')
			
			def classFive = new ClassInstance(
				crn: '10178',
				subject: 'ECE',
				courseNumber: '310',
				sectionNumber: '101',
				title: 'D&A/Analog Circuits',
				days: 'M W F',
				beginHour: '10',
				beginMinute: '0',
				beginMeridiem: 'AM',
				endHour: '11',
				endMinute: '40',
				endMeridiem: 'AM',
				building: 'KEC',
				room: '122',
				instructor: 'Meah K')
			
			def classSix = new ClassInstance(
				crn: '10179',
				subject: 'ECE',
				courseNumber: '332',
				sectionNumber: '101',
				title: 'Intro Signal Proces',
				days: 'M W F',
				beginHour: '8',
				beginMinute: '0',
				beginMeridiem: 'AM',
				endHour: '9',
				endMinute: '40',
				endMeridiem: 'AM',
				building: 'KEC',
				room: '126',
				instructor: 'Blanding W')
			
			def classSeven = new ClassInstance(
				crn: '10738',
				subject: 'ECO',
				courseNumber: '201',
				sectionNumber: '101',
				title: 'Prin Econ-Micro',
				days: 'M W F',
				beginHour: '9',
				beginMinute: '0',
				beginMeridiem: 'AM',
				endHour: '9',
				endMinute: '50',
				endMeridiem: 'AM',
				building: 'WBC',
				room: '310',
				instructor: 'Cho I')
			
			def classEight = new ClassInstance(
				crn: '10741',
				subject: 'ECO',
				courseNumber: '201',
				sectionNumber: '102',
				title: 'Prin Econ-Micro',
				days: 'M W F',
				beginHour: '10',
				beginMinute: '0',
				beginMeridiem: 'AM',
				endHour: '10',
				endMinute: '50',
				endMeridiem: 'AM',
				building: 'WBC',
				room: '314',
				instructor: 'Cho I')
			
			def classNine = new ClassInstance(
				crn: '10742',
				subject: 'ECO',
				courseNumber: '201',
				sectionNumber: '103',
				title: 'Prin Econ-Micro',
				days: 'M W F',
				beginHour: '11',
				beginMinute: '0',
				beginMeridiem: 'AM',
				endHour: '11',
				endMinute: '50',
				endMeridiem: 'AM',
				building: 'WBC',
				room: '314',
				instructor: 'Cho I')
			
			def classTen = new ClassInstance(
				crn: '10744',
				subject: 'ECO',
				courseNumber: '201',
				sectionNumber: '104',
				title: 'Prin Econ-Micro',
				days: 'M W',
				beginHour: '3',
				beginMinute: '0',
				beginMeridiem: 'PM',
				endHour: '4',
				endMinute: '15',
				endMeridiem: 'PM',
				building: 'CH',
				room: '205',
				instructor: 'Salem H')
			
			def classEleven = new ClassInstance(
				crn: '10748',
				subject: 'ECO',
				courseNumber: '201',
				sectionNumber: '105',
				title: 'Prin Econ-Micro',
				days: 'T R',
				beginHour: '9',
				beginMinute: '30',
				beginMeridiem: 'AM',
				endHour: '10',
				endMinute: '45',
				endMeridiem: 'AM',
				building: 'CH',
				room: '302',
				instructor: 'Slaysman K')
			
			def classTwelve = new ClassInstance(
				crn: '10753',
				subject: 'ECO',
				courseNumber: '201',
				sectionNumber: '801',
				title: 'Prin Econ-Micro',
				days: 'T R',
				beginHour: '5',
				beginMinute: '0',
				beginMeridiem: 'PM',
				endHour: '6',
				endMinute: '15',
				endMeridiem: 'PM',
				building: 'WBC',
				room: '314',
				instructor: 'Slaysman K')
			
			classOne.save().updateComplexItems()
			classTwo.save().updateComplexItems()
			classThree.save().updateComplexItems()
			classFour.save().updateComplexItems()
			//classFive.save().updateComplexItems()
			//classSix.save().updateComplexItems()
			//classSeven.save().updateComplexItems()
			//classEight.save().updateComplexItems()
			//classNine.save().updateComplexItems()
			//classTen.save().updateComplexItems()
			//classEleven.save().updateComplexItems()
			//classTwelve.save().updateComplexItems()
		}
		
    }
    def destroy = {
    }
}
