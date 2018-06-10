package ziyujewelry.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import ziyujewelry.com.dao.IMaterDAO;
import ziyujewelry.com.pojo.Mater;

public class MaterDAOImpl implements IMaterDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MaterDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Mater mater) throws Exception {
		String sql = " insert into mater(materId,materName,materShape,materCost,materSize) values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, mater.getMaterId());
		this.pstmt.setString(2, mater.getMaterName());
		this.pstmt.setString(3, mater.getMaterShape());
		this.pstmt.setDouble(4, mater.getMaterCost());
		this.pstmt.setString(5, mater.getMaterSize());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Mater mater) throws Exception {
		String sql = "update mater set materName=?,materShape=?,materCost=?,materSize=? where materId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, mater.getMaterName());
		this.pstmt.setString(2, mater.getMaterShape());
		this.pstmt.setDouble(3, mater.getMaterCost());
		this.pstmt.setString(4, mater.getMaterSize());
		this.pstmt.setInt(5, mater.getMaterId());
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> materId) throws Exception {
		if(materId.isEmpty()){
			return false;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("delete from mater where materID in (");
		for (Integer integer : materId) {
			sb.append(integer).append(",");
		}
		sb.deleteCharAt(sb.length()-1).append(")");
		this.pstmt = this.conn.prepareStatement(sb.toString());
		return this.pstmt.executeUpdate() == materId.size();
	}

	@Override
	public Mater findById(Integer materId) throws Exception {
		Mater mater = null;
		String sql = " select materId,materName,materShape,materCost,materSize from mater where materId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, materId);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			mater = new Mater();
			mater.setMaterId(rs.getInt(1));
			mater.setMaterName(rs.getString(2));
			mater.setMaterShape(rs.getString(3));
			mater.setMaterCost(rs.getDouble(4));
			mater.setMaterSize(rs.getString(5));
		}
		rs.close();
		return mater;
	}

	@Override
	public List<Mater> findAll() throws Exception {
		List<Mater> list = new ArrayList<Mater>();
		String sql = " select materId,materName,materShape,materCost,materSize from mater ";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Mater mater = new Mater();
			mater.setMaterId(rs.getInt(1));
			mater.setMaterName(rs.getString(2));
			mater.setMaterShape(rs.getString(3));
			mater.setMaterCost(rs.getDouble(4));
			mater.setMaterSize(rs.getString(5));
			list.add(mater);
		}
		rs.close();
		return list;
	}

	@Override
	public List<Mater> findAllSplit(Integer currentPage, Integer lineSize, String colnum, String keyWord)
			throws Exception {
		List<Mater> all = new ArrayList<Mater>();
		String sql = " select materId,materName,materShape,materCost,materSize from mater where " + colnum + " like ? limit ?,? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage*lineSize);
		this.pstmt.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Mater mater = new Mater();
			mater.setMaterId(rs.getInt(1));
			mater.setMaterName(rs.getString(2));
			mater.setMaterShape(rs.getString(3));
			mater.setMaterCost(rs.getDouble(4));
			mater.setMaterSize(rs.getString(5));
			all.add(mater);
		}
		rs.close();
		return all;
	}

	@Override
	public Integer getAllCouut(String colnum, String keyWord) throws Exception {
		String sql = "select count(materId) from mater where" + colnum + "like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

}
