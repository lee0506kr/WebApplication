package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FileService;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
	FileService fileService;

	public FileServlet() {
		// service 객체 얻어오기 :singleton
		fileService = FileService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String command = req.getParameter("command");

		if (command != null && command.equals("fileList")) {
			// 파일 목록 출력
			// 서비스에서 파일 목록가져오기
			List<String> fileList = fileService.getAllFileNames();
			req.setAttribute("fileList", fileList);

			req.getRequestDispatcher("fileList.jsp").forward(req, resp);

		} else if (command != null && command.equals("download")) {
			// 파일 다운로드
			// 서비스에서 파일 가져오기
			// System.out.println("download 요청받음!!");
			String fileName = req.getParameter("filename");
			// System.out.println("fileName : " + fileName);

			// 파일의 경로는 이미 알고 있기 때문에 해당 경로에 가서 파일을 만들어 오면된다.
			String downloadPath = "c:\\tmp\\";
			// 파일의 전체 경로
			String filePath = downloadPath + fileName;

			// 파일 복사 : FileInputStream 사용
			byte b[] = new byte[4096];
			FileInputStream fis = new FileInputStream(filePath);

			// 응답에 실어서 전달을 해야 하는데, 파일의 종류를 알려줘야 한다.
			// 파일의 종류 및 실행 어플리케이션에 대한 정의
			String sMimeType = getServletContext().getMimeType(filePath);
			// MIME : Multipurpose Internet Mail Extensions
			if (sMimeType == null) {
				sMimeType = "application/octect-stream";
			}
			resp.setContentType(sMimeType);
			
			//파일이름 에서 UUID 제거 하기
			//UUID만들고 뒤쪽에 _하나 넣어줬기 떄문에 '_'로 UUID를 구분해서 제거
			int idx = fileName.indexOf("_");
			String originFileName = fileName.substring(idx+1);
			//한들 파일명 처리
			String strEncoding = new String(fileName.getBytes("utf-8"),"8859_1");
			
			
			resp.setHeader("Content-Disposition", "attachment;filename=" +strEncoding);

			ServletOutputStream servletOutputStream = resp.getOutputStream();

			int readNum = 0;

			while ((readNum = fis.read(b, 0, b.length)) != -1) {
				servletOutputStream.write(b, 0, readNum);
			}
			servletOutputStream.flush();
			servletOutputStream.close();
			fis.close();

		}else if (command.equals("delete")) {
			System.out.println("delete 요청 받았습니다.");
			// 지우기 위해서는 지우려는 member의 id

			String file = req.getParameter("filename");

			boolean result = fileService.removefile(file);

			resp.getWriter().print("(\"result\" : " + result + ")");

		}

	}

}
