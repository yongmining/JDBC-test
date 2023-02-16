package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {

	public List<MemberDTO> insertNewMember(SqlSession sqlSession) {

		String query = prop.getProperty("insertMember");

		System.out.println(query);

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setInt(8, member.getAge());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<MemberDTO> selectMemberList(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList = null;

		String query = prop.getProperty("selectMemberList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			memberList = new ArrayList();

			while(rset.next()) {

				MemberDTO row = new MemberDTO();

				row.setMemberNo(rset.getInt("MEMBER_NO"));
				row.setMemberId(rset.getString("MEMBER_ID"));
				row.setMemberPwd(rset.getString("MEMBER_PWD"));
				row.setMemberName(rset.getString("MEMBER_NAME"));
				row.setGender(rset.getString("GENDER"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setAddress(rset.getString("ADDRESS"));
				row.setAge(rset.getInt("AGE"));
				row.setEnrollDate(rset.getDate("ENROLL_DATE"));

				memberList.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return memberList;
	}

	public MemberDTO selectMemberById(Connection con, String id) {

		String query = prop.getProperty("selectMemberId");

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO result = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);

			rset = pstmt.executeQuery();

			while(rset.next()) {

				result = new MemberDTO();

				result.setMemberNo(rset.getInt("MEMBER_NO"));
				result.setMemberId(rset.getString("MEMBER_ID"));
				result.setMemberPwd(rset.getString("MEMBER_PWD"));
				result.setMemberName(rset.getString("MEMBER_NAME"));
				result.setGender(rset.getString("GENDER"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPhone(rset.getString("PHONE"));
				result.setAddress(rset.getString("ADDRESS"));
				result.setAge(rset.getInt("AGE"));
				result.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return result;
	}

	public List<MemberDTO> selectMemberByGenderList(Connection con, String gender) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList = null;

		String query = prop.getProperty("selectMemberByGender");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, gender);

			rset = pstmt.executeQuery();

			memberList = new ArrayList();

			while(rset.next()) {

				MemberDTO row = new MemberDTO();

				row.setMemberNo(rset.getInt("MEMBER_NO"));
				row.setMemberId(rset.getString("MEMBER_ID"));
				row.setMemberPwd(rset.getString("MEMBER_PWD"));
				row.setMemberName(rset.getString("MEMBER_NAME"));
				row.setGender(rset.getString("GENDER"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setAddress(rset.getString("ADDRESS"));
				row.setAge(rset.getInt("AGE"));
				row.setEnrollDate(rset.getDate("ENROLL_DATE"));

				memberList.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return memberList;
	}

	public int updatePwd(Connection con, MemberDTO member) {

		String query = prop.getProperty("updateMemberPwdById");

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateEmail(Connection con, MemberDTO member) {

		String query = prop.getProperty("updateMemberEmailById");

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updatePhone(Connection con, MemberDTO member) {

		String query = prop.getProperty("updateMemberPhoneById");

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getPhone());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateAddress(Connection con, MemberDTO member) {

		String query = prop.getProperty("updateMemberAddressById");

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getAddress());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteMember(Connection con, String memberId) {

		String query = prop.getProperty("deleteMember");
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
}
