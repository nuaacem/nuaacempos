package nuaa.ggx.pos.frontend.service.interfaces;

public interface IBaseService<T> {
	public T getById(Integer id);
	public T loadById(Integer id);
	public void save(T t);
	public void delete(Integer id);
	public void delete(T t);
	public void update(T t);
	public T merge(T t);
}
