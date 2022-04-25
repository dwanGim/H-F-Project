package kr.co.hf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.PreviewDAO;
import kr.co.hf.domain.PreviewVO;

/**
 * Servlet implementation class GetPreviewList2
 */
@WebServlet("/getPreviewList")
public class GetPreviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPreviewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 리퀘스트
		String postId = request.getParameter("postID");
		String previewId =request.getParameter("previewID");
		String rankId = request.getParameter("rankID");
		
		
		// DAO getInstance();
		PreviewDAO dao = PreviewDAO.getInstance();
		List<PreviewVO> preview = dao.getPriviewList(Integer.parseInt(postId));
		
		System.out.println("데이터 디버깅 : " + preview);
		
		// 바인딩
		request.setAttribute("rankId", rankId);
		request.setAttribute("preview", preview);
		
		RequestDispatcher dp = request.getRequestDispatcher("http://localhost:8181/HFprj/preview/previewtest.jsp");
		
		// 포워딩
		dp.forward(request, response);
		
		

	}

}
