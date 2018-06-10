package ziyujewelry.com.dao;

import java.util.List;
import java.util.Set;

import ziyujewelry.com.pojo.GoodsType;

public interface IGoodsTypeDAO {
	public boolean doCreate(GoodsType goodsType)throws Exception;
	public boolean doUpdate(GoodsType goodsType)throws Exception;
	public boolean doRemoveBatch(Set<Integer> goodsTypeId)throws Exception;
	public GoodsType findById(Integer goodsTypeId)throws Exception;
	public List<GoodsType> findAll()throws Exception;
	public List<GoodsType> findAllSplit(Integer currentPage,Integer lineSize,String colnum, String keyWord)throws Exception;
	public Integer getAllCount(String colnum, String keyWord)throws Exception;
}
