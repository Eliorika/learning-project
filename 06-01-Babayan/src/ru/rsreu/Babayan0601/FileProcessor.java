package ru.rsreu.Babayan0601;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class FileProcessor {

	private FileProcessor() {
	}

	public static void writeToFile(MethodicalInstructions[] inputMethodicalInstructions, FileOutputStream output) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		ObjectOutputStream objectOutput = null;
		try {
			objectOutput = new ObjectOutputStream(output);
			objectOutput.writeObject(inputMethodicalInstructions);
		} catch (IOException e) {
			System.out.println(resourcer.getString("message.ioproblem"));
		} finally {
			if (output != null) {
				try {
					objectOutput.close();
					output.close();
				} catch (IOException e) {
					System.out.println(resourcer.getString("message.ioproblem"));
				}
			}
		}

	}

	public static File createFile(String path) throws IOException {
		Resourcer resourcer = ProjectResourcer.getInstance();
		File methodicalInstructionsFile = new File(path);
		if (methodicalInstructionsFile.createNewFile()) {
			System.out.println(
					methodicalInstructionsFile.getAbsolutePath() + " " + resourcer.getString("message.fileCreated"));
		}
		return methodicalInstructionsFile;
	}

	public static MethodicalInstructions[] readFromFile(FileInputStream input)
			throws IOException, ClassNotFoundException {
		ObjectInputStream objectInput = null;
		MethodicalInstructions[] inputMethodicalInstructions = null;
		Resourcer resourcer = ProjectResourcer.getInstance();
		try {
			objectInput = new ObjectInputStream(input);
			inputMethodicalInstructions = (MethodicalInstructions[]) objectInput.readObject();
			input.close();
		} catch (IOException e) {
			System.out.println(resourcer.getString("message.ioproblem") + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(resourcer.getString("message.classNotFound"));
		} finally {
			if (objectInput != null) {
				try {
					objectInput.close();
				} catch (IOException e1) {
					System.out.println(resourcer.getString("message.ioproblem") + e1.getMessage());
				}
			}
		}
		return inputMethodicalInstructions;
	}

	public static void createFileSystem() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		File fileSource = new File(
				System.getProperty("user.dir") + File.separator + resourcer.getString("files.folder.source.name"));
		File fileCopy = new File(
				fileSource.getAbsoluteFile() + File.separator + resourcer.getString("files.folder.copy.name"));
		File fileMove = new File(
				System.getProperty("user.dir") + File.separator + resourcer.getString("files.folder.move.name"));

		try {
			if (fileSource.mkdir() && fileCopy.mkdir() && fileMove.mkdir()) {
				System.out.println(resourcer.getString("message.success"));
			}
		} catch (SecurityException e) {
			System.out.println(resourcer.getString("message.cantCreateFileSystem"));
			System.out.println(resourcer.getString("message.stop"));
			System.exit(0);
		}

	}

	public static void copyFile(File source, File dest) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			input = new FileInputStream(source);
			sourceChannel = input.getChannel();
			output = new FileOutputStream(dest);
			destinationChannel = output.getChannel();
			destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} catch (IOException e) {
			System.out.println(resourcer.getString("message.ioproblem") + e.getMessage());
		} finally {
			if (sourceChannel != null) {
				try {
					sourceChannel.close();
				} catch (IOException e) {
					System.out.println(resourcer.getString("message.ioproblem") + e.getMessage());
				}
			}
			if (destinationChannel != null) {
				try {
					destinationChannel.close();
				} catch (IOException e) {
					System.out.println(resourcer.getString("message.ioproblem") + e.getMessage());
				}
			}
		}
	}

	public static void moveFile(String sourceString, String destinationString) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		System.out.println(resourcer.getString("message.confirmation"));
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.nextLine();
		scanner.close();
		if (!("0").equals(answer)) {
			Path source = Paths.get(sourceString);
			Path destination = Paths.get(destinationString);
			try {
				Files.move(source, destination);
			} catch (FileNotFoundException e) {
				System.out.println(resourcer.getString("message.fileNotFound"));
			} catch (IOException e) {
				System.out.println(resourcer.getString("message.moveException") + e.getMessage());
			}
		}
	}
}
