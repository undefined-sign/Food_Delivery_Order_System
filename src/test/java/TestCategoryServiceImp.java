import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hkd.pojo.Category;
import com.hkd.service.CategoryService;

public class TestCategoryServiceImp {

	@Test
	public void selectAllCategorys() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application_context.xml");
		
		CategoryService categoryService = (CategoryService) context.getBean("categoryServiceImp");
		
		ArrayList<Category> categorys = categoryService.getAllCategories();
		
		for (Category category : categorys) {
			System.out.println(category);
		}
		
	}
	
}
