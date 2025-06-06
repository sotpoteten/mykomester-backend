package no.ntnu.isaksj.backend.security;
import java.util.Collections;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.ntnu.isaksj.backend.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filter to validate JWT token and add user details to the authentication context if token is valid
 * 
 * Same class as used in Systemutvikling project spring 2024.
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter {

  private static final Logger LOGGER = LogManager.getLogger(JWTAuthorizationFilter.class);

  public static final String USER = "USER";
  public static final String ROLE_USER = "ROLE_" + USER;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    // check Bearer auth header
    final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (header == null || !header.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    // if Bearer auth header exists, validate token, and extract userId from token.
    // Note that we have added userId as subject to the token when it is generated
    // Note also that the token comes in this format 'Bearer token'
    String token = header.substring(7);
    final String username = validateTokenAndGetUserId(token);
    if (username == null) {
      // validation failed or token expired
      filterChain.doFilter(request, response);
      return;
    }

    // if token is valid, add user details to the authentication context
    // Note that user details should be fetched from the database in real scenarios
    // this is case we will retrieve use details from mock
    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
        username,
        null,
        Collections.singletonList(new SimpleGrantedAuthority(ROLE_USER)));
    SecurityContextHolder.getContext().setAuthentication(auth);

    // then, continue with authenticated user context
    filterChain.doFilter(request, response);
  }

  public String validateTokenAndGetUserId(final String token) {
    try {
      final Algorithm hmac512 = Algorithm.HMAC512(LoginService.KEY_STR);
      final JWTVerifier verifier = JWT.require(hmac512).build();
      return verifier.verify(token).getSubject();
    } catch (final JWTVerificationException verificationEx) {
      LOGGER.warn("token is invalid: {}", verificationEx.getMessage());
      return null;
    }
  }
}

