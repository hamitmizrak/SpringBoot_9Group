package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //CrudRepository, JpaRepository , PagingAndSortingRepository
public interface IRolesRepository extends CrudRepository<RolesEntity,Long> {
}
