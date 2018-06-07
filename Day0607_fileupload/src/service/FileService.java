package service;

import java.io.FilenameFilter;
import java.util.List;

import dao.FileDao;

public class FileService {
	private static FileService instance;

	public static FileService getInstance() {
		if (instance == null) {
			instance = new FileService();
		}
		return instance;
	}

	FileDao fileDao;

	public FileService() {
		fileDao = FileDao.getInstance();
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
