package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	@Id
	private String username;
	@Column(nullable = false)
	private String password;
	
	@Builder.Default
	@Column(columnDefinition = "varchar(32) default ''")
	private String alias = "";
	
	@Builder.Default
	@Column(columnDefinition = "varchar(32) default 'ROLE_USER'")
	private String role = "ROLE_USER";

	@Builder.Default
	@Column(columnDefinition = "boolean default true")
	private Boolean enabled = true;
}
