package org.kuzdowicz.repoapps.tutorials.services;

import java.security.Principal;
import java.util.List;

import org.kuzdowicz.repoapps.tutorials.dao.CategoriesDao;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

	private CategoriesDao categoriesDao;
	private UsersDao usersDao;

	@Autowired
	public CategoriesService(CategoriesDao tutorialsCategoriesDao, UsersDao usersDao) {
		this.categoriesDao = tutorialsCategoriesDao;
		this.usersDao = usersDao;
	}

	public List<Category> selectAll() {
		return categoriesDao.findAll();
	}

	public Category getOneById(Long categoryId) {

		return categoriesDao.findOne(categoryId);
	}

	public Category getOneByNameAndUserLogin(String name, String username) {
		return categoriesDao.findOne(usersDao.findOneUserByUsername(username).getUserid());
	}

	public Category getOneByIdWithTutorials(Long categoryId) {
		return categoriesDao.getOneByIdWithTutorials(categoryId);
	}

	public void insertOrUpdate(Category category) {

		categoriesDao.saveOrUpdate(category);
	}

	public void saveNewCategoryIfNotExistFotGivenNameAndUser(String name, Principal principal) {

		String username = principal.getName();
		if (getOneByNameAndUserLogin(name, username) == null) {
			Category newCategory = new Category();
			newCategory.setCategoryName(name);
			newCategory.setUserId(usersDao.findOneUserByUsername(username).getUserid());
			insertOrUpdate(newCategory);
		}

	}

	public void removeOneByPk(Long categoryPK) {
		Category tutorialToRemove = categoriesDao.findOne(categoryPK);
		if (categoriesDao != null) {
			categoriesDao.delete(tutorialToRemove);
		}
	}

	public List<String> getUserCategoriesNames(String username) {
		Long userid = usersDao.findOneUserByUsername(username).getUserid();
		return categoriesDao.getAllUserCategoriesNames(userid);
	}

	public List<Category> getUserCategories(String username) {
		Long userid = usersDao.findOneUserByUsername(username).getUserid();
		return categoriesDao.getAllUserCategories(userid);

	}

}
