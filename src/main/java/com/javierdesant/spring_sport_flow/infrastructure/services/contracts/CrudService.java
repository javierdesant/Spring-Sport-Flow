package com.javierdesant.spring_sport_flow.infrastructure.services.contracts;

public interface CrudService<RQ, EN, ID> {

    EN create(RQ request);

    EN read(ID id);

    EN update(RQ request, ID id);

    void delete(ID id);

}
