package com.anchtun.config;

// comment because we are giving the responsibility of authentication to the Keycloak server.
// our custom authentication logic
/*@AllArgsConstructor
@Component
public class ProjectUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
	
	private final CustomerService customerService;
	private final PasswordEncoder passwordEncoder;

	// Inside this authenticate method, it is our responsibility to define all the authentication logic right from loading the user details
	// from that storage system, comparing the passwords. And post that, we should create a successful authentication object
	// with an information whether the authentication is successful or not.
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		Customer customer = customerService.findByEmail(username);
		if (Objects.nonNull(customer)) {
			if (passwordEncoder.matches(password, customer.getPassword())) {
				return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(customer.getAuthorities()));
			} else {
				throw new BadCredentialsException("Wrong password");
			}
		} else {
			throw new BadCredentialsException("User details not exists");
		}
	}
	
	// Helper
    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }

	@Override
	public boolean supports(Class<?> authentication) {
		// if you want to support username, password authentication 
		// copy this from AbstractUserDetailsAuthenticationProvider
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}*/
