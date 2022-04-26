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
	} //  BoardDAO getInstance END;
	
	
	
	public List<BoardVO> getBoardList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			
			BoardVO board = new BoardVO();
			con = ds.getConnection();
			String sql = "SELECT * FROM board ORDER BY postTime DESC";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			
				while(rs.next()) {
					
					
					board.setPostID(rs.getInt(1));
					board.setPostAuthor(rs.getInt(2));
					board.setPostTitle(rs.getString(3));
					board.setPostContent(rs.getString(4));
					board.setPostTime(rs.getDate(5));
					board.setPostLastModified(rs.getDate(6));
					board.setViewCount(rs.getInt(7));
					board.setPostType(rs.getInt(8));
					
					
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
	
	} // getBoardList END;
	
	
	public BoardVO getBoardDetail(int postID) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		BoardVO board = new BoardVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM board WHERE postID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setPostID(rs.getInt(1));
				board.setPostAuthor(rs.getInt(2));
				board.setPostTitle(rs.getString(3));
				board.setPostContent(rs.getString(4));
				board.setPostTime(rs.getDate(5));
				board.setPostLastModified(rs.getDate(6));
				board.setViewCount(rs.getInt(7));
				board.setPostType(rs.getInt(8));
				
				System.out.println("데이터 디버깅 : " + board);
			} else {
				System.out.println("해당 계정이 없습니다.");
			}
			
			
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				
				try {
					con.close();
					rs.close();
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			return board;
			
	} // getBoardDetail END.
	
	
	
	public void boardInsert(int postAuthor, String postTitle, String postContent, int postType) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO board (postAuthor, postTitle, postContent, postType) VALUES (?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postAuthor);
			pstmt.setString(2, postTitle);
			pstmt.setString(3, postContent);
			pstmt.setInt(4, postType);
			
			
			System.out.println("데이터 디버깅 : " + sql);
			pstmt.executeUpdate();
			System.out.println("boardInsert 업데이트 수행 완료");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} // boardInsert() END.
	
	
	
	public void boardDelete(int postID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM board WHERE postID = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, postID);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
				pstmt.close();
				}catch(Exception e) {
				e.printStackTrace();
				}
	
		}
	} //boardDelete END.
	
	
	public void boardUpdate(String postTitle, String postContent, int postType, int postID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "UPDATE board SET postTitle = ?, postContent = ?, postType = ?,  postLastModified = now() WHERE postID = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, postTitle);
			pstmt.setString(2, postContent);
			pstmt.setInt(3, postID);
			pstmt.setInt(4, postType);
			
			System.out.println("데이터 디버깅 : " + sql);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();	
			}
			
		}
	} //  boardUpdate END.
	
}
