package com.pazienza.friendsapi.friendRequests;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CreateFriendRequestData {

	@NotNull
	@Min(1)
	private final Integer senderId;

	@NotNull
	@NotBlank
	private final String receiverPlayerAlias;

	public CreateFriendRequestData(int senderId, String receiverPlayerAlias) {
		this.senderId = senderId;
		this.receiverPlayerAlias = receiverPlayerAlias;
	}

	public int getSenderId() {
		return senderId;
	}

	public String getReceiverPlayerAlias() {
		return receiverPlayerAlias;
	}
}
