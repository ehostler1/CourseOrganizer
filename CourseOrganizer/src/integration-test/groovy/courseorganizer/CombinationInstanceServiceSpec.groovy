package courseorganizer

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CombinationInstanceServiceSpec extends Specification {

    CombinationInstanceService combinationInstanceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CombinationInstance(...).save(flush: true, failOnError: true)
        //new CombinationInstance(...).save(flush: true, failOnError: true)
        //CombinationInstance combinationInstance = new CombinationInstance(...).save(flush: true, failOnError: true)
        //new CombinationInstance(...).save(flush: true, failOnError: true)
        //new CombinationInstance(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //combinationInstance.id
    }

    void "test get"() {
        setupData()

        expect:
        combinationInstanceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CombinationInstance> combinationInstanceList = combinationInstanceService.list(max: 2, offset: 2)

        then:
        combinationInstanceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        combinationInstanceService.count() == 5
    }

    void "test delete"() {
        Long combinationInstanceId = setupData()

        expect:
        combinationInstanceService.count() == 5

        when:
        combinationInstanceService.delete(combinationInstanceId)
        sessionFactory.currentSession.flush()

        then:
        combinationInstanceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CombinationInstance combinationInstance = new CombinationInstance()
        combinationInstanceService.save(combinationInstance)

        then:
        combinationInstance.id != null
    }
}
