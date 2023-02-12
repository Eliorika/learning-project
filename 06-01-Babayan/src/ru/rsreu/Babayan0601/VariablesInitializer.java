package ru.rsreu.Babayan0601;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class VariablesInitializer {
	private static FileOutputStream output = null;
	private static FileInputStream inputMoved = null;
	private static FileInputStream inputCopied = null;
	private static File data = null;
	private static File dataCopy = null;
	private static MethodicalInstructions[] methodicalInstructionsArray;
	private static String pathMove;

	private VariablesInitializer() {
	}

	public static void initialize() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		
			FileProcessor.createFileSystem();
			methodicalInstructionsArray = intializeMethodicalInstructionsArray();
			String pathDataFile = System.getProperty("user.dir") + File.separator
					+ resourcer.getString("files.folder.source.name") + File.separator
					+ resourcer.getString("files.file.data.name") + resourcer.getString("files.filer.data.extension");
			try {
				data = FileProcessor.createFile(pathDataFile);
			

			String pathCopyFile = System.getProperty("user.dir") + File.separator
					+ resourcer.getString("files.folder.source.name") + File.separator
					+ resourcer.getString("files.folder.copy.name") + File.separator
					+ resourcer.getString("files.file.data.name") + resourcer.getString("files.filer.backup.extension");
			dataCopy = FileProcessor.createFile(pathCopyFile);

			output = new FileOutputStream(System.getProperty("user.dir") + File.separator
					+ resourcer.getString("files.folder.source.name") + File.separator
					+ resourcer.getString("files.file.data.name") + resourcer.getString("files.filer.data.extension"));

			pathMove = System.getProperty("user.dir") + File.separator + resourcer.getString("files.folder.move.name")
					+ File.separator + resourcer.getString("files.file.data.name")
					+ resourcer.getString("files.filer.data.extension");
			} catch (IOException e) {
				System.out.println(resourcer.getString("message.ioproblem"));
			}
		
	}

	public static void fileNotFoundException(String path) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		System.out.println(path + resourcer.getString("message.fileNotFound"));
	}

	public static void inputInitializator() {

		try {
			inputCopied = new FileInputStream(dataCopy.getAbsoluteFile());
		} catch (FileNotFoundException e) {
			fileNotFoundException(dataCopy.getAbsolutePath());
		}
		try {
			inputMoved = new FileInputStream(pathMove);
		} catch (FileNotFoundException e) {
			fileNotFoundException(pathMove);
		}
	}

	public static MethodicalInstructions[] getMethodicalInstructionsArray() {
		return methodicalInstructionsArray;
	}

	private static MethodicalInstructions[] intializeMethodicalInstructionsArray() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		MethodicalInstructions[] methodicalInstructionsArray = new MethodicalInstructions[4];
		methodicalInstructionsArray[0] = new MethodicalInstructions(1, resourcer.getString("message.ivanov"),
				Discipline.PHYSICS);
		methodicalInstructionsArray[1] = new MethodicalInstructions(2, resourcer.getString("message.petrov"),
				Discipline.PHYSICS);
		methodicalInstructionsArray[2] = new MethodicalInstructions(3, resourcer.getString("message.dubov"),
				Discipline.CHEMISTRY);
		methodicalInstructionsArray[3] = new MethodicalInstructions(4, resourcer.getString("message.dubov"),
				Discipline.MATHS);
		return methodicalInstructionsArray;
	}

	public static FileOutputStream getOutput() {
		return output;
	}

	public static FileInputStream getInputCopied() {
		return inputCopied;
	}

	public static File getData() {
		return data;
	}

	public static File getDataCopy() {
		return dataCopy;
	}

	public static String getPathMove() {
		return pathMove;
	}

	public static FileInputStream getInputMoved() {
		return inputMoved;
	};

}
