package kr.co.hf.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PreviewDAO {
	
	
	private DataSource ds;

	public static PreviewDAO dao = new PreviewDAO();
	
	private PreviewDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // PreviewDAO END;
	

	
	public static PreviewDAO getInstance() {
		
		if(dao == null) {
			dao = new PreviewDAO();
		}
		return dao;
	} //  previewDAO getINstance() END;
	
	
	
	public List<PreviewVO> getPriviewList(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<PreviewVO> previewList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM preview WHERE postID =? ORDER BY postTime DESC";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, postID);
			
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < 10; i++) {
				if(rs.next()) {
					PreviewVO preview = new PreviewVO();
					
					preview.setPreviewID(rs.getInt(1));
					preview.setPostID(rs.getInt(2));
					preview.setPreviewContent(rs.getString(3));
					preview.setPreviewLink(rs.getString(4));
					
					System.out.println("데이터 디버깅 : " + preview);
					previewList.add(preview);
					
				}
			}
			
			System.out.println("리스트에 쌓인 자료 체크 : " + previewList);
			
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
		
		return previewList;
		
		
	} // getPreviewList() END;
	

	
	
	
		
	
}
