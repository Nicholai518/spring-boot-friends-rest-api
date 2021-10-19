package com.pazienza.friendsapi.friendrequests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "friend_requests")
@NoArgsConstructor
@Getter
@Setter
public class FriendRequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int senderId;
	private int receiverId;
	private String status;
	private Date createdAt;

	private Date updatedAt;

	public FriendRequestEntity(Integer senderId, Integer receiverId, String status) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = status;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
