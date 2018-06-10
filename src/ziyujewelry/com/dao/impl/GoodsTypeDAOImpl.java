package ziyujewelry.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ziyujewelry.com.dao.IGoodsTypeDAO;
import ziyujewelry.com.pojo.GoodsType;

public class GoodsTypeDAOImpl implements IGoodsTypeDAO {
	private PreparedStatement psmt;
	private Connection conn;
	
	public GoodsTypeDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(GoodsType goodsType) throws Exception {
		String sql = " insert into goodstype(goodsTypeId,goodsTypeName,goodsTypeDesc) values(?,?,?) ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setInt(1, goodsType.getGoodsTypeId());
		this.psmt.setString(2, goodsType.getGoodsTypeName());
		this.psmt.setString(3, goodsType.getGoodsTypeDesc());
		return this.psmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(GoodsType goodsType) throws Exception {
		String sql = " update goodstype set goodsTypeName=?,goodsTypeDesc=? where goodsTypeId=? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, goodsType.getGoodsTypeName());
		this.psmt.setString(2, goodsType.getGoodsTypeDesc());
		this.psmt.setInt(3, goodsType.getGoodsTypeId());
		return this.psmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> goodsTypeId) throws Exception {
		if(goodsTypeId.isEmpty()){
			return false;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from goodstype where goodsTypeId in (");
		for (Integer integer : goodsTypeId) {
			sb.append(integer).append(",");
		}
		sb.deleteCharAt(sb.length()-1).append(")");
		this.psmt = this.conn.prepareStatement(sb.toString());
		return this.psmt.executeUpdate() == goodsTypeId.size();
	}

	@Override
	public GoodsType findById(Integer goodsTypeId) throws Exception {
		GoodsType goodsType = null;
		String sql = " select goodsTypeId,goodsTypeName,goodsTypeDesc from goodsType where goodsTypeId=? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setInt(1, goodsTypeId);
		ResultSet rs = this.psmt.executeQuery();
		if(rs.next()){
			goodsType = new GoodsType();
			goodsType.setGoodsTypeId(rs.getInt(1));
			goodsType.setGoodsTypeName(rs.getString(2));
			goodsType.setGoodsTypeDesc(rs.getString(3));
		}
		return goodsType;
	}

	@Override
	public List<GoodsType> findAll() throws Exception {
		List<GoodsType> list = new ArrayList<GoodsType>();
		String sql = " select goodsTypeId,goodsTypeName,goodsTypeDesc from goodsType ";
		this.psmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.psmt.executeQuery();
		while(rs.next()){
			GoodsType goodsType = new GoodsType();
			goodsType.setGoodsTypeId(rs.getInt(1));
			goodsType.setGoodsTypeName(rs.getString(2));
			goodsType.setGoodsTypeDesc(rs.getString(3));
			list.add(goodsType);
		}
		return list;
	}

	@Override
	public List<GoodsType> findAllSplit(Integer currentPage, Integer lineSize, String colnum, String keyWord)
			throws Exception {
		List<GoodsType> list = new ArrayList<GoodsType>();
		String sql = " select goodsTypeId,goodsTypeName,goodsTypeDesc from goodsType where " + colnum + " like ? limit ?,? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, "%" + keyWord + "%");
		this.psmt.setInt(2, currentPage*lineSize);
		this.psmt.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs = this.psmt.executeQuery();
		while(rs.next()){
			GoodsType goodsType = new GoodsType();
			goodsType.setGoodsTypeId(rs.getInt(1));
			goodsType.setGoodsTypeName(rs.getString(2));
			goodsType.setGoodsTypeDesc(rs.getString(3));
			list.add(goodsType);
		}
		return list;
	}

	@Override
	public Integer getAllCount(String colnum, String keyWord) throws Exception {
		String sql = " select count from goodsType where " + colnum + " like ? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.psmt.executeQuery();
		if(rs.next()){
			return this.psmt.executeUpdate();
		}
		return null;
	}

}
