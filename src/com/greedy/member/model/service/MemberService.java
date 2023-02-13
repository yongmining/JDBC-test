package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;

public class MemberService {

	private MemberDAO memberDAO = new MemberDAO();

	public boolean createNewMember(MemberDTO member) {

		Connection con = getConnection();

		int result = memberDAO.insertNewMember(con, member);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result > 0? true: false;
	}

	public List<MemberDTO> findAllMembers() {

		Connection con = getConnection();

		List<MemberDTO> memberList = memberDAO.selectMemberList(con);

		close(con);

		return memberList;
	}

	public MemberDTO findMemberById(String id) {

		Connection con = getConnection();

		MemberDTO memberById = memberDAO.selectMemberById(con, id);

		close(con);

		return memberById;
	}

	public List<MemberDTO> searchMemberByGender(String gender) {

		Connection con = getConnection();

		List<MemberDTO> memberList = memberDAO.selectMemberByGenderList(con, gender);

		close(con);

		return memberList;
	}

	public boolean updatePassword(MemberDTO member) {

		Connection con = getConnection();

		int result = memberDAO.updatePwd(con, member);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result > 0? true: false;
	}

	public boolean updateEmail(MemberDTO member) {

		Connection con = getConnection();

		int result = memberDAO.updateEmail(con, member);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result > 0? true: false;
	}

	public boolean updatePhone(MemberDTO member) {

		Connection con = getConnection();

		int result = memberDAO.updatePhone(con, member);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result > 0? true: false;
	}

	public boolean updateAddress(MemberDTO member) {

		Connection con = getConnection();

		int result = memberDAO.updateAddress(con, member);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result > 0? true: false;
	}

	public boolean deleteMember(String memberId) {

		Connection con = getConnection();
		
		int result = memberDAO.deleteMember(con, memberId);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result > 0? true: false;
	}
}
