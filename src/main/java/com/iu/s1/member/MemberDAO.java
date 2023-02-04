package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnetion;

@Repository
public class MemberDAO {

	public List<MemberDTO> getMemberList() throws Exception {
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		
		Connection connection = DBConnetion.getConnection();
		
		String sql = "SELECT MEMBERID, MEMBERPASSWORD, MEMBERNAME, MEMBERADDRESS, MEMBERPHONE, MEMBEREMAIL "
				+ "FROM MEMBER";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMemberId(rs.getString("MEMBERID"));
			memberDTO.setMemberPassword(rs.getString("MEMBERPASSWORD"));
			memberDTO.setMemberName(rs.getString("MEMBERNAME"));
			memberDTO.setMemberAddress(rs.getString("MEMBERADDRESS"));
			memberDTO.setMemberPhone(rs.getString("MEMBERPHONE"));
			memberDTO.setMemberEmail(rs.getString("MEMBEREMAIL"));
			ar.add(memberDTO);
		}
		DBConnetion.disconnect(rs, st, connection);
		
		return ar;
	}
	
	public int setMember (MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnetion.getConnection();
		
		String sql = "INSERT INTO MEMBER (MEMBERID, MEMBERPASSWORD, MEMBERNAME, MEMBERADDRESS, MEMBERPHONE, MEMBEREMAIL) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberId());
		st.setString(2, memberDTO.getMemberPassword());
		st.setString(3, memberDTO.getMemberName());
		st.setString(4, memberDTO.getMemberAddress());
		st.setString(5, memberDTO.getMemberPhone());
		st.setString(6, memberDTO.getMemberEmail());
		
		int result = st.executeUpdate();
		
		DBConnetion.disconnect(st, connection);
		
		return result;
		
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception {
		MemberDTO memberDTO2 = new MemberDTO();
		Connection connection = DBConnetion.getConnection();
		 String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
		 PreparedStatement st = connection.prepareStatement(sql);
		 
		 st.setString(1, memberDTO.getMemberId());
		 
		 ResultSet rs = st.executeQuery();
		 
		 if(rs.next()) {
			 memberDTO2.setMemberId(rs.getString("MEMBERID"));
			 memberDTO2.setMemberPassword(rs.getString("MEMBERPASSWORD"));
			 memberDTO2.setMemberName(rs.getString("MEMBERNAME"));
			 memberDTO2.setMemberAddress(rs.getString("MEMBERADDRESS"));
			 memberDTO2.setMemberPhone(rs.getString("MEMBERPHONE"));
			 memberDTO2.setMemberEmail(rs.getString("MEMBEREMAIL"));
			 
		 } else {
			 memberDTO2 = null;
		 }
		 
		 DBConnetion.disconnect(rs, st, connection);
		 
		 return memberDTO2;
	}
		
}
