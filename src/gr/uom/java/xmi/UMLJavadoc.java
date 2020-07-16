package gr.uom.java.xmi;

import java.util.ArrayList;
import java.util.List;

public class UMLJavadoc {
	private List<UMLTagElement> tags;

	public UMLJavadoc() {
		this.tags = new ArrayList<UMLTagElement>();
	}
	
	public void addTag(UMLTagElement tag) {
		tags.add(tag);
	}

	public List<UMLTagElement> getTags() {
		return tags;
	}

	public boolean contains(String s) {
		for(UMLTagElement tag : tags) {
			if(tag.contains(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsIgnoreCase(String s) {
		for(UMLTagElement tag : tags) {
			if(tag.containsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean importsType(UMLClass umlClass, String targetClass) {
		if(targetClass.startsWith(umlClass.getPackageName()))
			return true;
		for(String importedType : umlClass.getImportedTypes()) {
			//importedType.startsWith(targetClass) -> special handling for import static
			//importedType.equals(targetClassPackage) -> special handling for import with asterisk (*) wildcard
			if(importedType.equals(targetClass) || importedType.startsWith(targetClass)) {
				return true;
			}
			if(targetClass.contains(".")) {
				String targetClassPackage = targetClass.substring(0, targetClass.lastIndexOf("."));
				if(importedType.equals(targetClassPackage)) {
					return true;
				}
			}
		}
		return false;
	}
}
