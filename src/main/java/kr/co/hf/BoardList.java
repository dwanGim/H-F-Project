package kr.co.hf;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			BoardDAO dao = BoardDAO.getInstance();
			
			List<BoardVO> boardList = dao.getBoardList();
			
			request.setAttribute("boardList", boardList);
			
			RequestDispatcher dp = request.getRequestDispatcher("http://localhost:8181/HFprj/board/boardTest.jsp");
			
			dp.forward(request, response);
			
		
	}

	
}
