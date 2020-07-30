package org.refactoringminer.api;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.util.BufferRecyclers;

import gr.uom.java.xmi.diff.CodeRange;

public interface Refactoring extends Serializable, CodeRangeProvider {

	public RefactoringType getRefactoringType();
	
	public String getName();

	public String toString();
	
	/**
	 * @return a Set of ImmutablePair where left is the file path of a program element, and right is the qualified name of the class containing the program element
	 */
	public Set<ImmutablePair<String, String>> getInvolvedClassesBeforeRefactoring();
	
	/**
	 * @return a Set of ImmutablePair where left is the file path of a program element, and right is the qualified name of the class containing the program element
	 */
	public Set<ImmutablePair<String, String>> getInvolvedClassesAfterRefactoring();
	
	default public String toJSON() {
		StringBuilder sb = new StringBuilder();
		JsonStringEncoder encoder = BufferRecyclers.getJsonStringEncoder();
		sb.append("{").append("\n");
		sb.append("\t").append("\"").append("type").append("\"").append(": ").append("\"").append(getName()).append("\"").append(",").append("\n");
		sb.append("\t").append("\"").append("description").append("\"").append(": ").append("\"");
		encoder.quoteAsString(toString().replace('\t', ' '), sb);
		sb.append("\"").append(",").append("\n");
		sb.append("\t").append("\"").append("leftSideLocations").append("\"").append(": ").append(leftSide()).append(",").append("\n");
		sb.append("\t").append("\"").append("rightSideLocations").append("\"").append(": ").append(rightSide()).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * @return the code range(s) of the invocation(s) to the extracted method inside the source method in the <b>child</b> commit
	 */
	Set<CodeRange> getExtractedOperationInvocationCodeRanges();
}