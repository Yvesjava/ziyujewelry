package ziyujewelry.com.dao;

import java.util.List;
import java.util.Set;

import ziyujewelry.com.pojo.Mosaic;

public interface IMosaicDAO {
	public boolean doCreate(Mosaic mosaic)throws Exception;
	public boolean doUpdate(Mosaic mosaic)throws Exception;
	public boolean doRemovebatch(Set<Integer> mosId)throws Exception;
	public Mosaic findById(Integer mosId)throws Exception;
	public List<Mosaic> findAll()throws Exception;
	public List<Mosaic> findAllSplit(Integer currentPage,Integer lineSize,String colnum, String keyWord)throws Exception;
	public Integer getAllCount(String colnum, String keyWord)throws Exception;
}
