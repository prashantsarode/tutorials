package com.sampleprograms.spring.boot.rest.webservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.sampleprograms.spring.boot.rest.webservices.user.post.Post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the model class for Entity User")
@JsonFilter("UserFilter")
@Entity
public class User {

	@ApiModelProperty(notes = "Indicates primary unique identifier for User")
	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty(message = "Name should not be empty")
	@ApiModelProperty(notes = "Indicates user name. Name should not be empty")
	private String name;

	@PastOrPresent(message = "Birth Date cannot be in future")
	@NotNull(message = "Birth Date should not be empty")
	@ApiModelProperty(notes = "Indicates user Birthdate. Birthday should not be in the past")
	private Date birthDate;

	@NotNull(message = "Phone number should not be empty")
	@Size(min = 10, message = "A Valid phone number is required")
	@ApiModelProperty(notes = "Indicates contact number of user")
	private String phoneNumber;

	@NotNull(message = "SSN should not be empty")
	@Size(min = 9, message = "A Valid Social Security Number is required")
	@ApiModelProperty(notes = "Indicates SSN of user")
	private String socialSecurityNumber;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User() {
	}

	public User(Integer id, @NotEmpty(message = "Name should not be empty") String name,
			@PastOrPresent(message = "Birth Date cannot be in future") @NotNull(message = "Birth Date should not be empty") Date birthDate,
			@Size(min = 10, message = "A Valid phone number is required") String phoneNumber,
			@Size(min = 9, message = "A Valid Social Security Number is required") String socialSecurityNumber) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public List<Post> addPost(Post post) {
		this.getPosts().add(post);
		return this.getPosts();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((socialSecurityNumber == null) ? 0 : socialSecurityNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (socialSecurityNumber == null) {
			if (other.socialSecurityNumber != null)
				return false;
		} else if (!socialSecurityNumber.equals(other.socialSecurityNumber))
			return false;
		return true;
	}

}
