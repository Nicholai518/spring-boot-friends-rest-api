package com.pazienza.friendsapi.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	@Query(
		value= "select *\n" +
				"from (SELECT  \n" +
				"CASE\n" +
				"when first_user = :user_id then second_user\n" +
				"when second_user = :user_id then first_user\n" +
				"end as friend_id\n" +
				"from friends\n" +
				"where first_user = :user_id or second_user = :user_id) as f, users\n" +
				"where f.friend_id = users.id",
		nativeQuery = true
	)
	List<UserEntity> findAllFriendsForUserById(@Param("user_id") Integer id);
}

