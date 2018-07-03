/**
 * 
 */
package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ft0026
 *
 */
@Controller
public class IndexController {

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		// returns the ThymeLeaf template file "index"
		// maps to an HTML file with the same name!
		System.out.println("Some message to say....123456789");
		return "index"; 
	}
}
