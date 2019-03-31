package courseorganizer

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AClassServiceSpec extends Specification {

    AClassService AClassService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AClass(...).save(flush: true, failOnError: true)
        //new AClass(...).save(flush: true, failOnError: true)
        //AClass AClass = new AClass(...).save(flush: true, failOnError: true)
        //new AClass(...).save(flush: true, failOnError: true)
        //new AClass(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //AClass.id
    }

    void "test get"() {
        setupData()

        expect:
        AClassService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AClass> AClassList = AClassService.list(max: 2, offset: 2)

        then:
        AClassList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        AClassService.count() == 5
    }

    void "test delete"() {
        Long AClassId = setupData()

        expect:
        AClassService.count() == 5

        when:
        AClassService.delete(AClassId)
        sessionFactory.currentSession.flush()

        then:
        AClassService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AClass AClass = new AClass()
        AClassService.save(AClass)

        then:
        AClass.id != null
    }
}
