package com.anchtun.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

// The logic inside this KeycloakRoleConverter is, my Keycloak Auth server is going to return an access token.
// Inside this access token, there'll be details about the roles of my client application or roles of my end user.
// It our responsibility to extract those roles information or authorities information
// from the token and convert them into a format which my Spring security framework can understand.
// So, like you can see here, this converter is going to accept the JWT token that receives from my Keycloak server
// and it is going to extract the roles information and send back the list of GrantedAuthority because my Spring security framework can only understand
// the roles information or authorities information if I send in the form of GrantedAuthority objects.
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

		if (realmAccess == null || realmAccess.isEmpty()) {
			return new ArrayList<>();
		}

		Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles"))
				.stream()
				.map(roleName -> "ROLE_" + roleName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		return returnValue;
	}

}