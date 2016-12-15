package com.selfPractice.design.commandLineInterface;

import java.util.ArrayList;

public class DFTreeNode {

	private String nodeName;
	private ArrayList<DFTreeNode> childrenNodes;
	private boolean isRoot, isFile;
	private String permissions;
	private DFTreeNode parent;

	public DFTreeNode(String name, boolean isRoot, boolean isFile, String permission, DFTreeNode parentNode)
			throws Exception {
		// TODO Auto-generated constructor stub
		this.nodeName = name;
		if (isRoot && isFile) {
			Exception ex = new Exception("Invalid Operation!!! One entity can't be a root directory as well as a file.");
			throw ex;
		}
		this.isFile = isFile;
		this.isRoot = isRoot;
		if (isRoot)
			this.parent = null;
		else
			this.parent = parentNode;
		this.childrenNodes = new ArrayList<DFTreeNode>();
		this.permissions = permission;
	}

	public String getName() {
		return this.nodeName;
	}

	public boolean isRootFolder() {
		return this.isRoot;
	}

	public boolean isTypeFile() {
		return this.isFile;
	}

	public String getPermissions() {
		return this.permissions;
	}

	public DFTreeNode getParent() {
		return this.parent;
	}

	public void setPermissions(String newPermissions) {
		this.permissions = newPermissions;
	}

	public void setRoot() throws Exception {
		if (this.isFile) {
			Exception ex = new Exception("Invalid Operation!!! This is a file. You can't set root directory to a file.");
			throw ex;
		}
		this.isRoot = true;
		this.parent = null;
	}

	public void setTypeFile() throws Exception {
		if (this.childrenNodes != null) {
			Exception fileEx = new Exception("Invalid Operation!!! This is a directory and has children. You can't a file type to a directory.");
			throw fileEx;
		}
		this.isFile = true;
	}

	public void addChild(DFTreeNode tn) throws Exception {
		if (this.isFile) {
			Exception fileEx = new Exception("Invalid Operation!!! This is a file. You can't add child to a file type.");
			throw fileEx;
		}
		childrenNodes.add(tn);
	}

	public DFTreeNode getChild(String childName) throws Exception {
		if (!this.childrenNodes.isEmpty()) {
			for (DFTreeNode childNode : this.childrenNodes) {
				if (childNode.getName().equals(childName))
					return childNode;
			}
		}

		Exception childNotFoundEx = new Exception(childName + " is not present in this directory.");
		throw childNotFoundEx;
	}

	public void printChildren(boolean details) {
		if (details) {
			for (DFTreeNode cdf : childrenNodes) {
				String end = "";
				if (!cdf.isFile)
					end = "/";
				System.out.println(" " + cdf.getPermissions() + " " + cdf.getName() + end);
			}
		} else {
			for (DFTreeNode cdf : childrenNodes) {
				String end = "";
				if (!cdf.isFile)
					end = "/";
				System.out.print(" " + cdf.getName() + end);
			}
		}
	}
}