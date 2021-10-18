package com.pazienza.friendsapi.friendRequests;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRequestRepository extends CrudRepository<FriendRequestEntity, Integer> {

	@Query(
			value = "select *\n" +
					"from friend_requests\n" +
					"where sender_id  = :user_id or receiver_id = :user_id\n" +
					"and status = 'PENDING'",
			nativeQuery = true
	)
	List<FriendRequestEntity> findAllPendingFriendRequestsForUserById(@Param("user_id") Integer id);
}
