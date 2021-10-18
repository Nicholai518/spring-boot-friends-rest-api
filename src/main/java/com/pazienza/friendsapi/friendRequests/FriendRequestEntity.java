package com.pazienza.friendsapi.friendRequests;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "friend_requests")
public class FriendRequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int senderId;
	private int receiverId;
	private String status;
	private Date createdAt;

	private Date updatedAt;

	public FriendRequestEntity() {

	}

	public FriendRequestEntity(Integer senderId, Integer receiverId, String status) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = status;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int sender_id) {
		this.senderId = sender_id;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date created_at) {
		this.createdAt = created_at;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
