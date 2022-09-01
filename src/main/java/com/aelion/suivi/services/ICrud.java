/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

/**
 * @author Aelion
 *
 */
public interface ICrud<T> {
	
	public T add(T t);
	//dans la parenthèse le T correspond au T de type générique de ICrud et le t est le nom de la cariable que je n eocnnait pas
	
	public T[] add(T[] ts);
	//on peut ajouter deux fois la même méthode si signature() différente
	
	public void update(T t);
	public void delete(T t);
	public void delete(Long id) throws Exception;
	public List<T> findAll();
	public Optional<T> findOne(Long id);
}
