package fr.bro.budgetizer.specs.extension;

import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class JsExtension implements ConcordionExtension {

	@Override
	public void addTo(ConcordionExtender concordionExtender) {
		concordionExtender//
				.withLinkedJavaScript("/jquery-2.1.1.min.js", new Resource("/jquery-2.1.1.min.js")) //
				.withLinkedJavaScript("/bootstrap.min.js", new Resource("/bootstrap.min.js"));
	}

}
