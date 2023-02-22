package ru.tB;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test") // убрать
//@SpringBootTest // вернуть
@DataJpaTest // убрать
@AutoConfigureTestDatabase(replace = NONE) // убрать
class TBApplicationTests {

	@Test
	void contextLoads() {
	}

}
