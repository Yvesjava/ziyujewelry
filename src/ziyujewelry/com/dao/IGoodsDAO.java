package ziyujewelry.com.dao;

import java.util.List;
import java.util.Set;

import ziyujewelry.com.pojo.Goods;


/**
 * 定义Goods表的数据层的操作标准
 * @author Administrator
 *
 */
public interface IGoodsDAO {
	/**
	 * 实现数据库的增加操作
	 * @param goods 包含了要增加数据库的VO对象
	 * @return 数据保存成功返回true
	 * @throws Exception 
	 */
	public boolean doCreate(Goods goods)throws Exception;
	
	
	/**
	 * 实现数据库的修改操作，本次修改是根据id进行全部字段数据的修改
	 * @param goods 包含了要修改数据的信息，一定要提供有id内容
	 * @return 数据修改成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean doUpdate(Goods goods) throws Exception;
	
	
	
	/**
	 * 执行数据的批量删除操作，所有要删除的数据以Set集合的新市保存
	 * @param ids 包含了所有要删除的数据ID，不包含有重复内容
	 * @return 删除成功返回true（删除的数据个数与要删除的数据个数相同），否则返回false
	 * @throws Exception
	 */
	public boolean doRemoveBatch(Set<Integer> goodsId)throws Exception;
	
	
	
	/**
	 * 根据产品编号查询指定的产品信息
	 * @param goodsId 要查询的产品编号
	 * @return 如果产品信息存在，则将数据以VO类对象的形式返回，如果产品不存在，则返回null
	 * @throws Exception
	 */
	public Goods findById(Integer goodsId)throws Exception;
	
	
	
	/**
	 * 查询指定数据表的全部记录，并且以集合的形式返回
	 * @return 如果表中有数据，则所有的数据会封装为VO对象后，利用List集合返回
	 * 如果没有数据，那么集合的长度为0，（size（） == 0 不是null）
	 * @throws Exception
	 */
	public List<Goods> findAll()throws Exception;
	
	
	
	/**
	 * 分页进行数据的模糊查询，查询的结果以集合的形式返回
	 * @param currentPage 当前所在的页
	 * @param lineSize	每页显示数据的行数
	 * @param column 要进行模糊查询的数据列
	 * @param keyWord 模糊查询的关键字
	 * @return 如果产品信息存在，则将数据以VO类对象的形式返回，如果产品不存在，则返回null<br>
	 * 如果没有数据，那么集合的长度为0，（size（） == 0 不是null）
	 * @throws Exception
	 */
	public List<Goods> findAllSplit(Integer currentPage,Integer lineSize,String colnum, String keyWord)throws Exception;
	
	
	
	/**
	 * 要进模糊查询数据量的统计，如果表中没有记录统计的结果为0
	 * @param colnum 要进行模糊查询的数据列
	 * @param keyWord 要进行模糊查询的关键字
	 * @return 返回表中的数据量，如果没有数据返回0
	 * @throws Exception
	 */
	public Integer getAllCount(String colnum,String keyWord)throws Exception;
}
