package com.shopping.shoppingCartApp;

import com.shopping.shoppingCartApp.models.User;
import com.shopping.shoppingCartApp.repositories.CartRepository;
import com.shopping.shoppingCartApp.repositories.UserRepository;
import com.shopping.shoppingCartApp.service.CartService;
import com.shopping.shoppingCartApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import static org.mockito.Mockito.*;

@SpringBootTest
class ShoppingCartAppApplicationTests {

	@Autowired
	private UserService userService;
	@MockBean
	private UserRepository userRepository;
	@Autowired
	private CartService cartService;
	@MockBean
	private CartRepository cartRepository;

	@Test
	public void getAllUsersTest(){
		when(userRepository.findAll())
				.thenReturn(Stream.of(new User(1L,"Sonit","Sonit","Sonit","Sonit","Sonit"),
						new User(2L,"Anand","Anand","Anand","Anand","Anand")).collect(Collectors.toList()));
		Assert.assertEquals(2, userService.getAllUsers().size());
	}

	@Test
	public void getUserDetailByUserNameTest(){
		String name = "Sonit";
		when(userRepository.findByUserName(name)).thenReturn(new User(1L,"Sonit","Sonit","Sonit","Sonit","Sonit"));
		Assert.assertEquals(name, userService.getUserDetailByUserName(name).getUserName());
	}

	@Test
	public void saveUserTest(){
		User user = new User(1L,"Sonit","Sonit","Sonit","Sonit","Sonit");
		when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(user, userService.saveUser(user));
	}

	@Test
	public void deleteUserTest(){
		User user = new User(1L,"Sonit","Sonit","Sonit","Sonit","Sonit");
		userService.deleteUser(user);
		verify(userRepository,times(1)).delete(user);
	}
}
