package gr.uom.java.xmi.decomposition.replacement;

import gr.uom.java.xmi.decomposition.IObjectCreation;
import gr.uom.java.xmi.decomposition.OperationInvocation;

public class ClassInstanceCreationWithMethodInvocationReplacement extends Replacement {
	private IObjectCreation objectCreationBefore;
	private OperationInvocation invokedOperationAfter;

	public ClassInstanceCreationWithMethodInvocationReplacement(String before, String after, ReplacementType type,
			IObjectCreation objectCreationBefore, OperationInvocation invokedOperationAfter) {
		super(before, after, type);
		this.objectCreationBefore = objectCreationBefore;
		this.invokedOperationAfter = invokedOperationAfter;
	}

	public IObjectCreation getObjectCreationBefore() {
		return objectCreationBefore;
	}

	public OperationInvocation getInvokedOperationAfter() {
		return invokedOperationAfter;
	}

}
