package kr.co.hf.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	private DataSource ds;
	
	public static BoardDAO dao = new BoardDAO();
	
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // BoardDAO END;
	

	
	public static BoardDAO getInstance() {
		
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	} //  BoardDAO getINstance() END;
	
	
	
	public List<BoardVO> getBoardList(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM board WHERE postID =?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, postID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setPostID(rs.getInt(1));
				board.setPostAuthor(rs.getString(2));
				board.setPostContent(rs.getString(3));
				board.setPostType(rs.getInt(4));
				board.setViewCount(rs.getInt(5));
				board.setPostTime(rs.getDate(6));
				board.setPostTitle(rs.getString(7));
				board.setPostLastModified(rs.getDate(8));
				
				System.out.println("데이터 디버깅 : " + board);
				boardList.add(board);
				
			}
			
			System.out.println("리스트에 쌓인 자료 체크 : " + boardList);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return boardList;
		
		
	} 
}
