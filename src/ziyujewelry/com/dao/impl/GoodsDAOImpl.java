package ziyujewelry.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import ziyujewelry.com.dao.IGoodsDAO;
import ziyujewelry.com.pojo.Goods;

public class GoodsDAOImpl implements IGoodsDAO {
	private Connection conn ;
	private PreparedStatement pstmt;
	
	/**
	 * 如果要想树勇数据层进行原子性的功能操作实现，必须要提供有Connection接口对象<br>
	 * 另外，犹豫开发之中业务层要调用数据层，所以数据层的打开与关闭交由业务层处理
	 * @param conn 表示数据层的连接对象
	 */
	public GoodsDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	/**
	 * 传入一个goods对象，执行插入操作
	 */
	public boolean doCreate(Goods goods) throws Exception {
		String sql = "insert into goods(goodsId,goodsSn,goodsName,goodsImg,goodsDesc,materId,goodsTypeId,mosId,shopName,markePrice,goodsCost,goodsStock,saleCount,isHot,isNew) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goods.getGoodsId());
		this.pstmt.setString(2, goods.getGoodsSn());
		this.pstmt.setString(3, goods.getGoodsName());
		this.pstmt.setString(4, goods.getGoodsImg());
		this.pstmt.setString(5, goods.getGoodsDesc());
		this.pstmt.setInt(6, goods.getMaterId());
		this.pstmt.setInt(7, goods.getGoodsTypeId());
		this.pstmt.setInt(8, goods.getMosId());
		this.pstmt.setString(9, goods.getShopName());
		this.pstmt.setDouble(10, goods.getMarkePrice());
		this.pstmt.setDouble(11, goods.getGoodsCost());
		this.pstmt.setInt(12, goods.getGoodsStock());
		this.pstmt.setInt(13, goods.getSaleCount());
		this.pstmt.setBoolean(14, goods.getIsHot());
		this.pstmt.setBoolean(15, goods.getIsNew());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	/**
	 * 传入一个goods对象，执行更新操作
	 */
	public boolean doUpdate(Goods goods) throws Exception {
		String sql = "update goods set goodsSn=?,goodsName=?,goodsImg=?,goodsDesc=?,materId=?,goodsTypeId=?,mosId=?,shopName=?,markePrice=?,goodsCost=?,goodsStock=?,saleCount=?,isHot=?,isNew=? where goodsId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, goods.getGoodsSn());
		this.pstmt.setString(2, goods.getGoodsName());
		this.pstmt.setString(3, goods.getGoodsImg());
		this.pstmt.setString(4, goods.getGoodsDesc());
		this.pstmt.setInt(5, goods.getMaterId());
		this.pstmt.setInt(6, goods.getGoodsTypeId());
		this.pstmt.setInt(7, goods.getMosId());
		this.pstmt.setString(8, goods.getShopName());
		this.pstmt.setDouble(9, goods.getMarkePrice());
		this.pstmt.setDouble(10, goods.getGoodsCost());
		this.pstmt.setInt(11, goods.getGoodsStock());
		this.pstmt.setInt(12, goods.getSaleCount());
		this.pstmt.setBoolean(13, goods.getIsHot());
		this.pstmt.setBoolean(14, goods.getIsNew());
		this.pstmt.setInt(15, goods.getGoodsId());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	/**
	 * 根据一个set集合中的goodsId，删除表中的记录，返回一个boolean值，成功为true，失败为false
	 */
	public boolean doRemoveBatch(Set<Integer> goodsId) throws Exception {
		if(goodsId == null || goodsId.size() == 0){ //没有要删除的数据
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("delete from goods where goodsId in(");
		Iterator<Integer> iter = goodsId.iterator();
		while(iter.hasNext()){
			sql.append(iter.next()).append(",");
		}
		sql.delete(sql.length()-1,sql.length()).append(")");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate()==goodsId.size();
	}

	@Override
	/**
	 * 根据goodId查询该表中的某条记录，返回一个Goods对象
	 */
	public Goods findById(Integer goodsId) throws Exception {
		Goods goods = null;
		String sql = "select goodsId,goodsSn,goodsName,goodsImg,goodsDesc,materId,goodsTypeId,mosId,shopName,markePrice,goodsCost,goodsStock,saleCount,isHot,isNew from goods where goodsId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, goodsId);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setGoodsSn(rs.getString(2));
			goods.setGoodsName(rs.getString(3));
			goods.setGoodsImg(rs.getString(4));
			goods.setGoodsDesc(rs.getString(5));
			goods.setMaterId(rs.getInt(6));
			goods.setGoodsTypeId(rs.getInt(7));
			goods.setMosId(rs.getInt(8));
			goods.setShopName(rs.getString(9));
			goods.setMarkePrice(rs.getDouble(10));
			goods.setGoodsCost(rs.getDouble(11));
			goods.setGoodsStock(rs.getInt(12));
			goods.setSaleCount(rs.getInt(13));
			goods.setIsHot(rs.getBoolean(14));
			goods.setIsNew(rs.getBoolean(15));
		}
		return goods;
	}

	@Override
	/**
	 * 查询该表中的所有记录
	 */
	public List<Goods> findAll() throws Exception {
		List<Goods> all = new ArrayList<Goods>();
		String sql = "select goodsId,goodsSn,goodsName,goodsImg,goodsDesc,materId,goodsTypeId,mosId,shopName,markePrice,goodsCost,goodsStock,saleCount,isHot,isNew from goods" ;
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Goods goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setGoodsSn(rs.getString(2));
			goods.setGoodsName(rs.getString(3));
			goods.setGoodsImg(rs.getString(4));
			goods.setGoodsDesc(rs.getString(5));
			goods.setMaterId(rs.getInt(6));
			goods.setGoodsTypeId(rs.getInt(7));
			goods.setMosId(rs.getInt(8));
			goods.setShopName(rs.getString(9));
			goods.setMarkePrice(rs.getDouble(10));
			goods.setGoodsCost(rs.getDouble(11));
			goods.setGoodsStock(rs.getInt(12));
			goods.setSaleCount(rs.getInt(13));
			goods.setIsHot(rs.getBoolean(14));
			goods.setIsNew(rs.getBoolean(15));
			all.add(goods);
		}
		return all;
	}

	@Override
	/**
	 * 根据关键词keyWord模糊查询指定数据列colnum，返回一个list集合，并且根据currentPage（开始页数）和lineSize（页面条数），分页展示
	 */
	public List<Goods> findAllSplit(Integer currentPage, Integer lineSize, String colnum, String keyWord)
			throws Exception {
		List<Goods> all = new ArrayList<Goods>();
		String sql = "select goodsId,goodsSn,goodsName,goodsImg,goodsDesc,materId,goodsTypeId,mosId,shopName,markePrice,goodsCost,goodsStock,saleCount,isHot,isNew from goods where " + colnum +" like ? limit ?,? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage*lineSize);
		this.pstmt.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Goods goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setGoodsSn(rs.getString(2));
			goods.setGoodsName(rs.getString(3));
			goods.setGoodsImg(rs.getString(4));
			goods.setGoodsDesc(rs.getString(5));
			goods.setMaterId(rs.getInt(6));
			goods.setGoodsTypeId(rs.getInt(7));
			goods.setMosId(rs.getInt(8));
			goods.setShopName(rs.getString(9));
			goods.setMarkePrice(rs.getDouble(10));
			goods.setGoodsCost(rs.getDouble(11));
			goods.setGoodsStock(rs.getInt(12));
			goods.setSaleCount(rs.getInt(13));
			goods.setIsHot(rs.getBoolean(14));
			goods.setIsNew(rs.getBoolean(15));
			all.add(goods);
		}
		return all;
	}
	
	
	/**
	 * 根据关键词keyWord模糊查询指定数据列colnum的总条数count
	 */
	@Override
	public Integer getAllCount(String colnum, String keyWord) throws Exception {
		String sql = "select count(goodsId) from goods where" + colnum + "like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

}
