package ziyujewelry.com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.Connection;

import ziyujewelry.com.dao.IMosaicDAO;
import ziyujewelry.com.pojo.Mosaic;

public class MosaicDAOImpl implements IMosaicDAO {
	private PreparedStatement psmt;
	private Connection conn;
	
	
	@Override
	public boolean doCreate(Mosaic mosaic) throws Exception {
		String sql = "insert into mosaic(mosId,mosName,mosMater,mosShop,mosType,mosMaterCost,isSelfControl,mosControlCost,mosDesc) values(?,?,?,?,?,?,?,?,?)";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setInt(1, mosaic.getMosId());
		this.psmt.setString(2, mosaic.getMosName());
		this.psmt.setString(3, mosaic.getMosMater());
		this.psmt.setString(4, mosaic.getMosShop());
		this.psmt.setString(5, mosaic.getMosType());
		this.psmt.setDouble(6, mosaic.getMosMaterCost());
		this.psmt.setBoolean(7, mosaic.getIsSelfControl());
		this.psmt.setDouble(8, mosaic.getMosControlCost());
		this.psmt.setString(9, mosaic.getMosDesc());
		return this.psmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Mosaic mosaic) throws Exception {
		String sql = " update mosaic set mosName=?,mosMater=?,mosShop=?,mosType=?,mosMaterCost=?,isSelfControl=?,mosControlCost=?,mosDesc=? where mosId=? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, mosaic.getMosName());
		this.psmt.setString(2, mosaic.getMosMater());
		this.psmt.setString(3, mosaic.getMosShop());
		this.psmt.setString(4, mosaic.getMosType());
		this.psmt.setDouble(5, mosaic.getMosMaterCost());
		this.psmt.setBoolean(6, mosaic.getIsSelfControl());
		this.psmt.setDouble(7, mosaic.getMosControlCost());
		this.psmt.setString(8, mosaic.getMosDesc());
		this.psmt.setInt(9, mosaic.getMosId());
		return this.psmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemovebatch(Set<Integer> mosId) throws Exception {
		if(mosId.isEmpty()){
			return false;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" delete from goodstype where goodsTypeId in (");
		for (Integer integer : mosId) {
			sb.append(integer).append(",");
		}
		sb.deleteCharAt(sb.length()-1).append(")");
		this.psmt = this.conn.prepareStatement(sb.toString());
		return this.psmt.executeUpdate() == mosId.size();
	}

	@Override
	public Mosaic findById(Integer mosId) throws Exception {
		Mosaic mosaic = null;
		String sql = "select mosId,mosName,mosMater,mosShop,mosType,mosMaterCost,isSelfControl,mosControlCost,mosDesc from mosaic where mosId=? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setInt(1, mosId);
		ResultSet rs = this.psmt.executeQuery();
		while(rs.next()){
			mosaic = new Mosaic();
			mosaic.setMosId(rs.getInt(1));
			mosaic.setMosName(rs.getString(2));
			mosaic.setMosMater(rs.getString(3));
			mosaic.setMosShop(rs.getString(4));
			mosaic.setMosType(rs.getString(5));
			mosaic.setMosMaterCost(rs.getDouble(6));
			mosaic.setIsSelfControl(rs.getBoolean(7));
			mosaic.setMosControlCost(rs.getDouble(8));
			mosaic.setMosDesc(rs.getString(9));
		}
		return mosaic;
	}

	@Override
	public List<Mosaic> findAll() throws Exception {
		List<Mosaic> all = new ArrayList<Mosaic>();
		String sql = "select mosId,mosName,mosMater,mosShop,mosType,mosMaterCost,isSelfControl,mosControlCost,mosDesc from mosaic ";
		this.psmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.psmt.executeQuery();
		while(rs.next()){
			Mosaic mosaic = new Mosaic();
			mosaic.setMosId(rs.getInt(1));
			mosaic.setMosName(rs.getString(2));
			mosaic.setMosMater(rs.getString(3));
			mosaic.setMosShop(rs.getString(4));
			mosaic.setMosType(rs.getString(5));
			mosaic.setMosMaterCost(rs.getDouble(6));
			mosaic.setIsSelfControl(rs.getBoolean(7));
			mosaic.setMosControlCost(rs.getDouble(8));
			mosaic.setMosDesc(rs.getString(9));
			all.add(mosaic);
		}
		return all;
	}

	@Override
	public List<Mosaic> findAllSplit(Integer currentPage, Integer lineSize, String colnum, String keyWord)
			throws Exception {
		List<Mosaic> list = new ArrayList<Mosaic>();
		String sql = " select mosId,mosName,mosMater,mosShop,mosType,mosMaterCost,isSelfControl,mosControlCost,mosDesc from mosaic where " + colnum + " like ? limit ?,?;";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, "%"+ keyWord +"%");
		this.psmt.setInt(2, currentPage*lineSize);
		this.psmt.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs = this.psmt.executeQuery();
		while(rs.next()){
			Mosaic mosaic = new Mosaic();
			mosaic.setMosId(rs.getInt(1));
			mosaic.setMosName(rs.getString(2));
			mosaic.setMosMater(rs.getString(3));
			mosaic.setMosShop(rs.getString(4));
			mosaic.setMosType(rs.getString(5));
			mosaic.setMosMaterCost(rs.getDouble(6));
			mosaic.setIsSelfControl(rs.getBoolean(7));
			mosaic.setMosControlCost(rs.getDouble(8));
			mosaic.setMosDesc(rs.getString(9));
			list.add(mosaic);
		}
		return list;
	}

	@Override
	public Integer getAllCount(String colnum, String keyWord) throws Exception {
		String sql = " select count(mosId) from mosaic where " + colnum + " like ? ";
		this.psmt = this.conn.prepareStatement(sql);
		this.psmt.setString(1, "%"+ keyWord +"%");
		ResultSet rs = this.psmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

}
