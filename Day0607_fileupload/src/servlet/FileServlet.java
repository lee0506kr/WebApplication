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
		// service ��ü ������ :singleton
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
			// ���� ��� ���
			// ���񽺿��� ���� ��ϰ�������
			List<String> fileList = fileService.getAllFileNames();
			req.setAttribute("fileList", fileList);

			req.getRequestDispatcher("fileList.jsp").forward(req, resp);

		} else if (command != null && command.equals("download")) {
			// ���� �ٿ�ε�
			// ���񽺿��� ���� ��������
			// System.out.println("download ��û����!!");
			String fileName = req.getParameter("filename");
			// System.out.println("fileName : " + fileName);

			// ������ ��δ� �̹� �˰� �ֱ� ������ �ش� ��ο� ���� ������ ����� ����ȴ�.
			String downloadPath = "c:\\tmp\\";
			// ������ ��ü ���
			String filePath = downloadPath + fileName;

			// ���� ���� : FileInputStream ���
			byte b[] = new byte[4096];
			FileInputStream fis = new FileInputStream(filePath);

			// ���信 �Ǿ ������ �ؾ� �ϴµ�, ������ ������ �˷���� �Ѵ�.
			// ������ ���� �� ���� ���ø����̼ǿ� ���� ����
			String sMimeType = getServletContext().getMimeType(filePath);
			// MIME : Multipurpose Internet Mail Extensions
			if (sMimeType == null) {
				sMimeType = "application/octect-stream";
			}
			resp.setContentType(sMimeType);
			
			//�����̸� ���� UUID ���� �ϱ�
			//UUID����� ���ʿ� _�ϳ� �־���� ������ '_'�� UUID�� �����ؼ� ����
			int idx = fileName.indexOf("_");
			String originFileName = fileName.substring(idx+1);
			//�ѵ� ���ϸ� ó��
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
			System.out.println("delete ��û �޾ҽ��ϴ�.");
			// ����� ���ؼ��� ������� member�� id

			String file = req.getParameter("filename");

			boolean result = fileService.removefile(file);

			resp.getWriter().print("(\"result\" : " + result + ")");

		}

	}

}
