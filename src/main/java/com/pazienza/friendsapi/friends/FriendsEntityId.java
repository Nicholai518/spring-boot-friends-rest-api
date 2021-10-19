package com.pazienza.friendsapi.friends;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FriendsEntityId implements Serializable {

	private Integer firstUser;

	private Integer secondUser;
}
