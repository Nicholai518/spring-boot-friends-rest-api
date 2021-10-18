package com.pazienza.friendsapi.friendRequests;

import com.pazienza.friendsapi.ApiErrorResponse;
import com.pazienza.friendsapi.users.UserEntity;
import com.pazienza.friendsapi.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/friend-request")
public class FriendRequestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FriendRequestRepository friendRequestRepository;

	@ResponseBody
	@PostMapping(path = "/")
	public ResponseEntity<?> createFriendRequest(
			@Valid @RequestBody CreateFriendRequestData createFriendRequestData) {

		// check that receiver is a real user
		String userAlias = createFriendRequestData.getReceiverPlayerAlias();
		Optional<UserEntity> optionalReceivingUserEntity
				= userRepository.findByPlayerAlias(userAlias);
		if (optionalReceivingUserEntity.isEmpty()) {
			return ResponseEntity
					.badRequest()
					.body(new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Unknown receiver"));
		}

		// check that the sender is a real user
		int senderId = createFriendRequestData.getSenderId();
		Optional<UserEntity> optionalSenderEntity = userRepository.findById(senderId);
		if (optionalSenderEntity.isEmpty()) {
			return ResponseEntity
					.badRequest()
					.body(new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Unknown sender"));
		}
		UserEntity sendingUser = optionalSenderEntity.get();

		// check that both users are not already friends
		List<UserEntity> friendsOfSenderList
				= userRepository.findAllFriendsForUserById(sendingUser.getId());
		HashSet<UserEntity> friendsOfSenderSet = new HashSet<>(friendsOfSenderList);
		UserEntity receivingUser = optionalReceivingUserEntity.get();
		if (friendsOfSenderSet.contains(receivingUser)) {
			return ResponseEntity
					.badRequest()
					.body(new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Users are already friends"));
		}

		// check that there isn't already a pending friend request
		List<FriendRequestEntity> pendingFriendRequests
				= friendRequestRepository.findAllPendingFriendRequestsForUserById(sendingUser.getId());
		for (FriendRequestEntity pendingRequest : pendingFriendRequests) {
			if (pendingRequest.getReceiverId() == receivingUser.getId() ||
					pendingRequest.getSenderId() == receivingUser.getId()) {
				return ResponseEntity
						.badRequest()
						.body(new ApiErrorResponse(HttpStatus.BAD_REQUEST, "A pending friend request already exists"));
			}
		}

		// create and save the friend request
		FriendRequestEntity friendRequestEntity = new FriendRequestEntity(
				senderId,
				receivingUser.getId(),
				"PENDING"
		);
		friendRequestRepository.save(friendRequestEntity);

		// return a response entity
		return ResponseEntity.ok(friendRequestEntity);
	}
}
