package courseorganizer

import grails.gorm.services.Service

@Service(AClass)
interface AClassService {

    AClass get(Serializable id)

    List<AClass> list(Map args)

    Long count()

    void delete(Serializable id)

    AClass save(AClass AClass)

}