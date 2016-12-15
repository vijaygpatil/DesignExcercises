package com.selfPractice.design.commandLineInterface;

import java.util.Scanner;

public class CLI {

	static DFTreeNode currentDir, rootDirectory;
	static final String defaultPermissions = "rwxrwxrwx";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			rootDirectory = new DFTreeNode("/", true, false, "rwxrwxrwx", null);
			currentDir = rootDirectory;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		parseInput();
	}

	private static void parseInput() {
		System.out.print(": ");
		Scanner scInput = new Scanner(System.in);
		String inputStr = scInput.nextLine();
		//
		// System.out.println("Command -> " + inputStr + " ");

		if (!inputStr.equals("exit")) {
			parseCommand(inputStr);
			parseInput();
		}
	}

	private static void parseCommand(String cmd) {
		String[] cmdParts = cmd.split(" ");
		switch (cmdParts[0]) {
		case "ls":
			lsCommand(cmdParts);
			break;

		case "pwd":
			pwdCommand();
			break;

		case "cd":
			cdCommand(cmdParts);
			break;

		case "mkdir":
			mkdirCommand(cmdParts);
			break;

		case "vi":
			viCommand(cmdParts);
			break;

		default:
			System.out.println("Invalid command " + cmd);
		}
	}

	private static void lsCommand(String[] cmdArray) {
		if (cmdArray.length == 1)
			currentDir.printChildren(false);
		else
			currentDir.printChildren(true);
	}

	private static void pwdCommand() {

		DFTreeNode tempParentNode = currentDir.getParent();
		String path = currentDir.getName();
		while (tempParentNode != null) {
			path = tempParentNode.getName() + "'/'" + path;
			tempParentNode = tempParentNode.getParent();
		}

		System.out.println(path);
	}

	private static void viCommand(String[] cmdArray) {
		if (cmdArray.length == 1)
			System.out.println("Invalid VI command. Enter filename.");
		else
			try {
				String permission = defaultPermissions;
				if (cmdArray.length > 2)
					permission = cmdArray[2];
				currentDir.addChild(new DFTreeNode(cmdArray[1], false, true, permission, currentDir));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private static void mkdirCommand(String[] cmdArray) {
		if (cmdArray.length == 1)
			System.out.println("Invalid mkdir command. Enter directory name.");
		else
			try {
				String permission = defaultPermissions;
				if (cmdArray.length > 2)
					permission = cmdArray[2];
				currentDir.addChild(new DFTreeNode(cmdArray[1], false, false, permission, currentDir));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private static void cdCommand(String[] cmdArray) {
		if (cmdArray.length == 1)
			System.out.println("Invalid cd command.");
		else
			try {

				switch (cmdArray[1]) {
				case "/":
					currentDir = rootDirectory;
					break;

				case "..":
					currentDir = currentDir.getParent();
					break;

				default:
					currentDir = currentDir.getChild(cmdArray[1]);
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
