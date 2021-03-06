package org.kuzdowicz.repoapps.tutorials.services;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.kuzdowicz.repoapps.tutorials.constants.UserRole;
import org.kuzdowicz.repoapps.tutorials.dao.CategoriesDao;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsDao;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.kuzdowicz.repoapps.tutorials.models.Tutorial;
import org.kuzdowicz.repoapps.tutorials.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitStartDataForTestService {

	private CategoriesDao tutorialsCategoriesDao;
	private TutorialsDao tutorialsDao;
	private UsersDao usersDao;

	@Autowired
	public InitStartDataForTestService(CategoriesDao tutorialsCategoriesDao, TutorialsDao tutorialsDao,
			UsersDao usersDao) {
		this.tutorialsCategoriesDao = tutorialsCategoriesDao;
		this.tutorialsDao = tutorialsDao;
		this.usersDao = usersDao;
	}

	@Transactional
	public void initSomeData() {

		// USERS
		AppUser user = new AppUser();
		user.setUsername("user");
		user.setPassword("$2a$10$Q.1ZPyA01dhdglv8PjjReOP.4DKAAd5JTUobIlsjnh7dRzfrwq.Uu");
		user.setType(UserRole.ROLE_USER);
		user.setEmail("user@user");

		AppUser admin = new AppUser();
		admin.setUsername("admin");
		admin.setPassword("$2a$10$2MLaGiTNvYLBHoKaRGbIy.AFoPBB03uyKmby.xupUoifICoFhjIFq");
		admin.setType(UserRole.ROLE_ADMIN);
		admin.setEmail("admin@admin");

		usersDao.saveOrUpdate(user);
		usersDao.saveOrUpdate(admin);

		// ------------------------------------------------------

		// CATEGORIES

		Category javaCategory = new Category();
		javaCategory.setCategoryName("Java");
		javaCategory.setUserId(admin.getUserid());
		Category aspCategory = new Category();
		aspCategory.setCategoryName("asp");
		aspCategory.setUserId(user.getUserid());
		tutorialsCategoriesDao.saveOrUpdate(javaCategory);
		tutorialsCategoriesDao.saveOrUpdate(aspCategory);

		// ------------------------------------------------------

		Tutorial tut1 = new Tutorial();
		tut1.setAuthor("JavaBrains");
		tut1.setTitle("hibernate tutorial");
		tut1.setUrl("https://www.youtube.com/watch?v=Yv2xctJxE-w&list=PL4AFF701184976B25");
		tut1.setServiceDomain("youtube");
		tut1.setRating(3L);
		tut1.setProgress(0);
		tut1.setStartDateToDo(DateTime.now().toDate());
		tut1.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut1.setUserId(admin.getUserid());
		tut1.setTutorialCategory(javaCategory);

		tutorialsDao.saveOrUpdate(tut1);

		Tutorial tut2 = new Tutorial();
		tut2.setAuthor("Artur Owczarek");
		tut2.setTitle("Jpa Kurs");
		tut2.setUrl("https://www.youtube.com/watch?v=bUpOL_b7g6k&index=23&list=PLU2dl_1LV_SQWZI2R_RSEeYm1tfueszOc");
		tut2.setServiceDomain("youtube");
		tut2.setRating(4L);
		tut2.setProgress(0);
		tut2.setStartDateToDo(DateTime.now().toDate());
		tut2.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut2.setUserId(admin.getUserid());
		tut2.setTutorialCategory(javaCategory);

		tutorialsDao.saveOrUpdate(tut2);

		Tutorial tut3 = new Tutorial();
		tut3.setAuthor("Mykong");
		tut3.setTitle("Spring MVC tutorial");
		tut3.setUrl("http://www.mkyong.com/spring3/spring-3-mvc-hello-world-example-annotation/");
		tut3.setServiceDomain("www.mkyong.com");
		tut3.setRating(5L);
		tut3.setProgress(0);
		tut3.setStartDateToDo(DateTime.now().toDate());
		tut3.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut3.setUserId(admin.getUserid());
		tut3.setTutorialCategory(javaCategory);

		tutorialsDao.saveOrUpdate(tut3);

		javaCategory.setTutorials(new ArrayList<>());
		javaCategory.getTutorials().add(tut1);
		javaCategory.getTutorials().add(tut2);
		javaCategory.getTutorials().add(tut3);
		javaCategory.setUserId(tut1.getUserId());

		tutorialsCategoriesDao.saveOrUpdate(javaCategory);

		aspCategory.setTutorials(new ArrayList<>());

		Tutorial tut4 = new Tutorial();
		tut4.setAuthor("MSDN");
		tut4.setTitle("c# tutorial");
		tut4.setUrl("https://msdn.microsoft.com/en-us/library/aa288436(v=vs.71).aspx");
		tut4.setServiceDomain("msdn.microsoft");
		tut4.setRating(5L);
		tut4.setStartDateToDo(DateTime.now().toDate());
		tut4.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut4.setProgress(0);
		tut4.setUserId(user.getUserid());
		tut4.setTutorialCategory(aspCategory);

		tutorialsDao.saveOrUpdate(tut4);

		aspCategory.getTutorials().add(tut4);
		aspCategory.setUserId(tut4.getUserId());

		tutorialsCategoriesDao.saveOrUpdate(aspCategory);

	}

}
