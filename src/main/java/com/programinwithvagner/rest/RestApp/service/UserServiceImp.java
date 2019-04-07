package com.programinwithvagner.rest.RestApp.service;

import com.programinwithvagner.rest.RestApp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("userService")
public class UserServiceImp implements UserService {

    private static List<User> users;

    private static final AtomicLong counter = new AtomicLong();

	static { users = populateDummyUsers(); }

	public List<User> findAllUsers() {
		return users;
	}

	public User findById(long id) {

	    for(User user: users) {
	        if(user.getId() == id ) {
	            return user;
            }
        }
	    return  null;
    }

	private static List populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
        users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
        users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
        users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
        return users;
    }
}
