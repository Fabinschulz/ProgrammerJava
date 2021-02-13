package dao;

import java.util.ArrayList;

public interface DAO<T>  {
  
	public void insert(T r);
	
	public ArrayList<T>	select();
		

	
}
