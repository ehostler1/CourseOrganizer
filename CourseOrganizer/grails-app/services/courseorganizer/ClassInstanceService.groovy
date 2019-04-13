package courseorganizer

import grails.gorm.services.Service

@Service(ClassInstance)
interface ClassInstanceService {

    ClassInstance get(Serializable id)

    List<ClassInstance> list(Map args)

    Long count()

    void delete(Serializable id)

    ClassInstance save(ClassInstance classInstance)

}