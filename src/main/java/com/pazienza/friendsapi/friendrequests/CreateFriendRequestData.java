package com.pazienza.friendsapi.friendrequests;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class CreateFriendRequestData {

	@NotNull
	@Min(1)
	private final Integer senderId;

	@NotNull
	@NotBlank
	private final String receiverPlayerAlias;
}
