package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //CrudRepository, JpaRepository , PagingAndSortingRepository
public interface IUsersRepository extends CrudRepository<UsersEntity,Long> {
}
