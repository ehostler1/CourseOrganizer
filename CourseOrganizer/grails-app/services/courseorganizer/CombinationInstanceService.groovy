package courseorganizer

import grails.gorm.services.Service

@Service(CombinationInstance)
interface CombinationInstanceService {

    CombinationInstance get(Serializable id)

    List<CombinationInstance> list(Map args)

    Long count()

    void delete(Serializable id)

    CombinationInstance save(CombinationInstance combinationInstance)

}