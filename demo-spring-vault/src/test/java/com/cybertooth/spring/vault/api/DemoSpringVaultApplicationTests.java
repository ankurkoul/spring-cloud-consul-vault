package com.cybertooth.spring.vault.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

import lombok.AllArgsConstructor;
import lombok.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringVaultApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
	}

	@Test
	public void vaultTest() throws URISyntaxException {
		// 1client settings
		// given

		// when
		VaultTemplate template = new VaultTemplate(VaultEndpoint.from(new URI("http://127.0.0.1:8200")),
				new TokenAuthentication("s.RdDe5L5hXMFApbFLk450PZRi"));

		VaultResponse response = template.write("cubbyhole/admin", new AdminSecret("newUser1", "newPass1"));

		// then
		assertNull(response);
		// when

	VaultResponseSupport<AdminSecret> validResponse = template.read("cubbyhole/admin", AdminSecret.class);
		// then
		assertNotNull(validResponse.getData().getUsername());
		assertNotNull(validResponse.getData().getPassword());

	}


@Data
	public static class AdminSecret {
		private String username;
		private String password;
		public AdminSecret() {}
		public AdminSecret(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		
	}

}
