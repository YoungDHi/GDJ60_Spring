package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER(MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, "
				+ "MEMBER_ADDRESS, MEMBER_PHONE, MEMBER_EMAIL) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberId());
		st.setString(2, memberDTO.getMemberPassword());
		st.setString(3, memberDTO.getMemberName());
		st.setString(4, memberDTO.getMemberAddress());
		st.setString(5, memberDTO.getMemberPhone());
		st.setString(6, memberDTO.getMemberEmail());
		
		int result = st.executeUpdate();
		
		DBConnection.disconnect(st, connection);
		
		return result;
		
		
		
		
	}

}
