package com.pazienza.friendsapi.friends;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity(name = "friends")
@IdClass(FriendsEntityId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FriendsEntity {

	@Id
	private Integer firstUser;

	@Id
	private Integer secondUser;

	private Date createdAt;
}
