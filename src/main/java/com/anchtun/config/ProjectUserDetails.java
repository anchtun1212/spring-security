package com.anchtun.config;

/**
 * because we are defining our custom Authentication Provider: ProjectUsernamePasswordAuthenticationProvider
 * so we can remove this class
 */
/**
 * 
 * @author anchtun1212
 * custom user fetching logic
 */
//When we want to load the user details based on our own tables, columns, custom logic, 
//then we need to create a bean that implements UserDetailsService and overrides the method loadUserByUsername.
//@Service
//@AllArgsConstructor
//public class ProjectUserDetails implements UserDetailsService {

	/*private final CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		Customer customer = customerRepository.findOneByUsername(username);
		if (Objects.isNull(customer)) {
			throw new UsernameNotFoundException("User details not found, please verify this username: " + username);
		} else {
			String userName = customer.getUsername();
			String password = customer.getPassword();
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.getRole().name()));
			user = new User(userName, password, authorities);
		}
		return user;
	}*/
	
//}
