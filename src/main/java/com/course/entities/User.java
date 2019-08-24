package com.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> oders = new ArrayList<Order>();
	
	public List<Order> getOders() {
		return oders;
	}

	public User() { }

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		
	
}