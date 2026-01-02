import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hkd.pojo.Dish;
import com.hkd.service.DishService;

public class TestDishServiceImp {
	
	@Test
	public void testGetAllDish() {

		ApplicationContext context = new ClassPathXmlApplicationContext("application_context.xml");

		DishService dishService = (DishService) context.getBean("dishServiceImp");

		ArrayList<Dish> dishes = dishService.getAllDishes();

		for (Dish dish : dishes) {
			System.out.println(dish);
		}

		ArrayList<Dish> dishes2 = dishService.getDishesByCid(1);

		for (Dish dish : dishes2) {
			System.out.println(dish);
		}

		System.out.println(dishService.getDishByid(1));

	}


}
