package product;

import java.util.List;

public interface GenericDAO<T> {

	List<T> get(); // GET (Http Verbs/Methods
	
	T create(T entity); // POST
	
	void remove(T entity); // DELETE
	
	void remove(Long id); // DELETE
	
	T update(T entity); // PUT
	
	int count();
	
}
