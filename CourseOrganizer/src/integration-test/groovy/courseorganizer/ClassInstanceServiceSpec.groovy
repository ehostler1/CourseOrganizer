package courseorganizer

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClassInstanceServiceSpec extends Specification {

    ClassInstanceService classInstanceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ClassInstance(...).save(flush: true, failOnError: true)
        //new ClassInstance(...).save(flush: true, failOnError: true)
        //ClassInstance classInstance = new ClassInstance(...).save(flush: true, failOnError: true)
        //new ClassInstance(...).save(flush: true, failOnError: true)
        //new ClassInstance(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //classInstance.id
    }

    void "test get"() {
        setupData()

        expect:
        classInstanceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ClassInstance> classInstanceList = classInstanceService.list(max: 2, offset: 2)

        then:
        classInstanceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        classInstanceService.count() == 5
    }

    void "test delete"() {
        Long classInstanceId = setupData()

        expect:
        classInstanceService.count() == 5

        when:
        classInstanceService.delete(classInstanceId)
        sessionFactory.currentSession.flush()

        then:
        classInstanceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ClassInstance classInstance = new ClassInstance()
        classInstanceService.save(classInstance)

        then:
        classInstance.id != null
    }
}
