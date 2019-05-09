package UsageCaculator.Security.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

public class MyUserDetails implements UserDetails {
	
	private String token;	
	private Collection<? extends GrantedAuthority> authorities;//That is ROLE
	private String stringOrgs;
	private List listOrgs;

	public MyUserDetails(String token, List<GrantedAuthority> grantedAuthorities,String orgs,String stringOrgs,List listOrgs) {	
		this.token = token;
		this.authorities = grantedAuthorities;
		this.stringOrgs=stringOrgs;
		this.listOrgs=listOrgs;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	
	@Override
	public String getUsername() {		
		return null;
	}
	
	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

	public String getStringOrgs() {
		return stringOrgs;
	}
	
	public List getListOrgs() {
		return listOrgs;
	}

}
