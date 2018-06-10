package ziyujewelry.com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ziyujewelry.com.pojo.Mater;

public interface IMaterService {
	/**
	 * 实现产品数据的增加操作，本次操作要调用IGoodsDAO接口的如下方法：<br>
	 * <li>需要调用IGoodsDAO.findById（）方法，判断要增加的数据的id是否已经存在
	 * <li>如果现在要增加的数据编号不存在，则调用IGoodsDAO.doCreate()方法，返回操作结果
	 * @param pro 包含了要增加的数据vo对象
	 * @return 如果增加的数据的id重复或者保存失败返回false。否则返回true
	 * @throws Exception
	 */
	public boolean insert(Mater mater)throws Exception;
	
	
	
	/**
	 * 实现商品数据的修改操作，本次调用的IGoodsDAO.doUpdate()方法，本次修改属于全部内容修改
	 * @param pro 包含了要修改数据的VO对象
	 * @return 修改成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean update(Mater mater)throws Exception;
	
	
	
	/**
	 * 执行商品数据的删除操作，可以删除多个商品信息，调用IGoodsDAO.doRemoveBatch()方法
	 * @param goods 包含了全部要删除数据的集合，没有重复的数据
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception
	 */
	public boolean delete(Set<Integer> materId)throws Exception;
	
	
	/***
	 * 根据商品编号查找商品的完整信息，调用IGoodsDAO.findById（）方法
	 * @param goodsId 要查找的商品编号
	 * @return 如果找到了则商品信息以VO对象的方式返回，否则返回null
	 * @throws Exception
	 */
	public Mater get(Integer materId)throws Exception;
	
	
	
	/**
	 * 查询全部商品信息，调用IGoodsDAO.findAll（）方法
	 * @return 查询结果以List集合的形式返回，没有数据则集合的长度为0
	 * @throws Exception
	 */
	public List<Mater> list()throws Exception;
	
	
	
	/**
	 * 实现数据的模糊查询与统计，要调用IGoodsDAO接口的两个方法：<br>
	 * <li>调用IGoodsDAO.findAllSplit（）方法，查询出所有的表数据，返回List<Goods>;
	 * <li>调用IGoodsDAO.getAllCount（）方法，查询出所有的数据量，返回Integer；
	 * @param currentPage 当前所在的页
	 * @param lineSize 每页显示的记录数
	 * @param colnum 模糊查询的数据列
	 * @param keyWord 模糊查询关键字
	 * @return 本方法由于需要返回多种数据类型，所以使用Map集合，由于类型不统一，所以所有value的类型设置为Object，返回内容如下<br>
	 * <li>key = allGoods,value=IGoods.findAllSplit()返回结果，List<Goods>;
	 * <li>key = GoodsCount,value=IGoodsDAO.getAllCount()返回结果，Integer；
	 * @throws Exception
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String colnum,String keyWord)throws Exception; 
	
}
