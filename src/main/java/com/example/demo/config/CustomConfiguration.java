package com.example.demo.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.access.expression.*;

import jakarta.annotation.*;
import jakarta.servlet.*;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;

@Configuration
@EnableMethodSecurity
public class CustomConfiguration {

	@Value("${aws.accessKeyId}")
	private String accessKeyId;
	@Value("${aws.secretAccessKey}")
	private String secretAccessKey;

	@Value("${aws.bucketUrl}")
	private String bucketUrl;

	@Autowired
	private ServletContext application;

	@PostConstruct
	public void init() {
		application.setAttribute("bucketUrl", bucketUrl);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();

//		http.formLogin(Customizer.withDefaults());
		http.formLogin().loginPage("/member/login");
		http.logout().logoutUrl("/member/logout");

//		http.authorizeHttpRequests().requestMatchers("/add").authenticated();
//		http.authorizeHttpRequests().requestMatchers("/member/signup").anonymous();
//		http.authorizeHttpRequests().requestMatchers("/**").permitAll();

//		http.authorizeHttpRequests()
//				.requestMatchers("/add")
//				.access(new WebExpressionAuthorizationManager("isAuthenticated()"));
//		http.authorizeHttpRequests()
//				.requestMatchers("/member/signup")
//				.access(new WebExpressionAuthorizationManager("isAnonymous()"));
//		http.authorizeHttpRequests()
//				.requestMatchers("/**")
//				.access(new WebExpressionAuthorizationManager("permitAll"));

		return http.build();
	}

	@Bean
	public S3Client s3client() {

		AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
		AwsCredentialsProvider provider = StaticCredentialsProvider.create(credentials);

		S3Client s3client = S3Client.builder()
				.credentialsProvider(provider)
				.region(Region.AP_NORTHEAST_2)
				.build();

		return s3client;
	}
}
