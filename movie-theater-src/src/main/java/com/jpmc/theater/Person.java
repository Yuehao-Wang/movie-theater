package com.jpmc.theater;

import com.jpmc.theater.type.AccountType;

/**
 * Super class for all types of user.
 * @author amorn
 *
 */
public abstract class Person {

	protected String name;

	protected String id;
    
	protected final AccountType type;
    
	/**
	 * @param type Person's AccountType 
	 */
    public Person(AccountType type) {
    	this.type = type;
    }
}
