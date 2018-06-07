package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.FileService;

public class UploadServlet extends HttpServlet {

	FileService service;

	public UploadServlet() {
		service = FileService.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		/*
		 * ��û�� ������ �ؾ��� �� 1. ����ε� ��û���� Ȯ�� (���Ͼ��ε� ��û���� �ƴ���) ����Ʈ Ÿ�� �����ͼ� Ȯ�� 2. �����̸��� DB��
		 * �����ϰ� 3. multipart�� ���� ���� �����͸� ���Ϸ� ���� ����
		 * 
		 */

		// 1. ��û ����Ȯ���� ���� contype ��������
		String contentType = req.getContentType();
		System.out.println("ctype: " + contentType);
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			// ���� ��û�̴�.
			// ���� �̸��� DB�� �����ϱ� : �޼��� �ۼ�
			saveFilename(req, resp);

		}

	}

	private void saveFilename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ϵ��� ��Ʈ��� �и��Ǽ� ������ �Ǳ� ������
		// ���ϵ��� ��� ��Ƽ� ���Ϸ� ����� ����

		// �����̸��� �ߺ��Ǵ� ��� �����ͺ��̽��� ������ ���� �ʰų�
		// �������� ������ ������ �� ������ �߻��� �� ���� >> ���ε�Ǵ�
		// ���ε� �Ǵ� �����̸��� �ߺ����� �ʵ��� �ؾ��Ѵ� >> UUID

		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			if (part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				// ���ϳ����� DB�� ����

				UUID uuid = UUID.randomUUID();

				String saveName = uuid.toString() + "_" +fileName;
				
				if (part.getSize() > 0) {
					// part.write("C:\\tmp\\"+ fileName);
					// web.xml�� �⺻ ��� ������
					part.write(saveName);
					service.uploadFile(saveName);
				}

				System.out.println("saveName : " + saveName);

			}
		}

	}

}
