package com.thebookStore.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookStore.app.entity.Users;
import com.thebookStore.app.exception.UsersException;
import com.thebookStore.app.repositiory.UsersRepository;


/***********************************************************************************
 *
 * @author Gunnampalli Likhitha
 * Description It is a service class that provides the services for adding a new book, 
 * to category, updating the book, viewing the book, getting all the books,
 * and deleting a book.
 * Version 1.0
 * Created Date 09-FEB-2023

 ************************************************************************************/
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UsersRepository userRepository;
    
	
	/************************************************************************************

	 * Method:-Add new user to database
	 * Description: -To add a new user to database
	 * @param user -User to be added to added
	 * @returns Users -User is returned after adding to database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
    @Override
    public Users addUser(Users user) {
        
        return userRepository.save(user);
    }
    
    
    /************************************************************************************
     * 
	 * Method:-updateUsers
	 * Description: -To update a user in database
	 * @param UserId -Id of the user to be updated
	 * @returns Users -User is returned after updating to database
	 * @throws UserNotFoundException -raised if the userId does not exist in database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
    @Override
    public Users updateUser(Users user) throws UsersException {
        return userRepository.save(user);
    }

    
    /************************************************************************************

	 * Method:-removeUserById
	 * Description: -To remove a user from database
	 * @param userId -Id of the user to be removed
	 * @returns Users -User is returned after adding to database
	 * @throws UserNotFoundException -raised if the userId does not exist in database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 


	 ************************************************************************************/
    @Override
    public Users removeUser(Integer UserId) throws UsersException {
        Optional<Users> optUsers = this.userRepository.findById(UserId);
        if (optUsers.isEmpty())
            throw new UsersException("User id does not exists to delete !");
        Users user = optUsers.get();
        this.userRepository.delete(user);
        return user;
    }
    
    
    /************************************************************************************
	 
	 * Method:-showAllUsers
	 * Description: -To get all the users in database
	 * @returns List<Users> -List of all the users present in the database is returned
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
    @Override
    public List<Users> showAllUsers() {
        
        return userRepository.findAll();
    }

    
    /************************************************************************************
	 
	 * Method:-getUserById
	 * Description: -To get user from database
	 * @param UserId -Id of the user to be returned
	 * @returns users -User is returned 
	 * @throws UserNotFoundException -raised if the userId does not exist in database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
	@Override
	public Users getUserByUserID(Integer UserId) throws UsersException {
		Optional<Users> optUsers = this.userRepository.findById(UserId);
        if (optUsers.isEmpty())
            throw new UsersException("User id does not exists");
		
		return optUsers.get();	
		}
	
	

}
