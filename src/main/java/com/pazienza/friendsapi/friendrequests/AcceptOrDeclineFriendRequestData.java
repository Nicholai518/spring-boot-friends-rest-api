package com.pazienza.friendsapi.friendrequests;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcceptOrDeclineFriendRequestData {

	@NotNull
	@NotBlank
	@Pattern(regexp = "ACCEPTED|DECLINED")
	private String status;
}
