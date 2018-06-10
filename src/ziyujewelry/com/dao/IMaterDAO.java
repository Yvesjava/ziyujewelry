package ziyujewelry.com.dao;

import java.util.List;
import java.util.Set;

import ziyujewelry.com.pojo.Mater;


/**
 * 该接口定义了材质表Mater的操作标准，该标准中有增加，更新，批量删除，查找，分页查询等等功能
 * @author Administrator
 *
 */
public interface IMaterDAO {
	/**
	 * 执行插入数据的操作
	 * @param mater 传入一个mater对象，把该对象中的值取出，插入到数据库
	 * @return 返回一个boolean值，true为成功，false为失败
	 * @throws Exception
	 */
	public boolean doCreate(Mater mater)throws Exception;
	
	
	/**
	 * 定义了一个更新操作
	 * @param mater 传入一个mater对象，把该对象中的值取出，更新到数据库
	 * @return 返回一个boolean值，true为成功，false为失败
	 * @throws Exception
	 */
	public boolean doUpdate(Mater mater)throws Exception;
	
	
	/**
	 * 定义了一个批量删除操作
	 * @param materId 传入了一个set集合，集合中包含了需要删除的记录ID，删除对应的记录
	 * @return 返回一个boolean值，true为成功，false为失败
	 * @throws Exception
	 */
	public boolean doRemoveBatch(Set<Integer> materId)throws Exception;
	
	
	/**
	 * 定义了一个查找操作
	 * @param materId 传入了一个materId，该id对应为数据库中的某条记录，找到则删除
	 * @return 返回一个boolean值，true为成功，false为失败
	 * @throws Exception
	 */
	public Mater findById(Integer materId)throws Exception;
	
	
	/**
	 * 定义了一个查找所有记录的方法
	 * @return 返回一个List集合，集合中包含了查询到的所有Mater对象，自动封装到了Mater对象中
	 * @throws Exception
	 */
	public List<Mater> findAll()throws Exception;
	
	
	/**
	 * 分页进行数据的模糊查询，查询的结果以集合的形式返回
	 * @param currentPage 当前所在的页
	 * @param lineSize 每页显示数据的行数
	 * @param colnum 要进行模糊查询的数据列
	 * @param keyWord 模糊查询的关键字
	 * @return 如果产品信息存在，则将数据以VO类对象的形式返回，如果产品不存在，则返回null<br>
	 * 如果没有数据，那么集合的长度为0，（size（） == 0 不是null）
	 * @throws Exception
	 */
	public List<Mater> findAllSplit(Integer currentPage,Integer lineSize,String colnum, String keyWord)throws Exception;
	
	
	/**
	 * 要进模糊查询数据量的统计，如果表中没有记录统计的结果为0
	 * @param colnum 要进行模糊查询的数据列
	 * @param keyWord 要进行模糊查询的关键字
	 * @return 返回表中的数据量，如果没有数据返回0
	 * @throws Exception
	 */
	public Integer getAllCouut(String colnum,String keyWord)throws Exception;
}
