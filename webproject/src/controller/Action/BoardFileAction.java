package controller.Action;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.FileDao;

public class BoardFileAction implements Action {
	FileDao fileDao;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		saveFilename(req, resp);
		String fileName = req.getParameter("filename");
		
	}

	private void saveFilename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			if (part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				// 파일네임을 DB에 저장

				UUID uuid = UUID.randomUUID();

				String saveName = uuid.toString() + "_" + fileName;

				if (part.getSize() > 0) {
					// part.write("C:\\tmp\\"+ fileName);
					// web.xml에 기본 경로 지정후
					uploadFile(saveName);
				}

				System.out.println("saveName : " + saveName);

			}
		}

	}

	public boolean uploadFile(String fileName) {
		int result = fileDao.insertFile(fileName);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<String> getAllFileNames() {
		// List<String> files;
		// files =fileDao.selectAllFiles() ;

		return fileDao.selectAllFiles();
	}

	public boolean removefile(String Filename) {
		int result = fileDao.deletefile(Filename);

		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

}
