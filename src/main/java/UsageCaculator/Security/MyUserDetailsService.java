//package UsageCaculator.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import UsageCaculator.Security.Model.JwtUser;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	@Autowired
//	private JwtUser jwtuser;
//
////	List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
////	String role=user.getRole();
////	grantedAuthorities.add(new SimpleGrantedAuthoriCty(role));
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return null;
//		 
////		Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();   
////			String theRole=jwtuser.getRole();
////	        auths.add(new SimpleGrantedAuthority("theRole"));  
////	        
////	              
////	 
////	        jwtuser user = new jwtuser(username, "lcy", true, true, true, true, auths);   
////	        return user;    
//	        }   
//		
////		JwtUser user = repo.findByUsername(username);
////		if (user == null)
////			throw new UsernameNotFoundException("User 404");
////
////		return new UserPrincipal(user);
//		
////		  SysUserBO user = sysUserService.getUserBO(username);
////	        if (user != null) {
////	            
////	        	
////
////	            // 用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
////	            SysRoleBO role = user.getRoleBO();aity(role.getName()));
////	            }
////	            
////	            // 获取角色所拥有的所有权限，并添加到authorities
////	            List<SysPermission> permissions = role.getPermissions();
////	            for (SysPermission permission : permissions) {
////	                if (permission != null && permission.getName() != null) {
////	                    // 1：此处将权限信息添加到 GrantedAuthority
////	                    // 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
////	                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
////	                }
////	            }
////	            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
////	        } else {
////	            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
////	        }
////	}
//
//}
