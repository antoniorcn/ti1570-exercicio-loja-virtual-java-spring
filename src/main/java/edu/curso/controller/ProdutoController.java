package edu.curso.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.curso.model.Produto;
import edu.curso.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	private ProdutoRepository repository;

	public ProdutoController (ProdutoRepository repository) {
		this.repository = repository; 
	}


	@RequestMapping(path = {"/produto"}, method=RequestMethod.POST)
	public ModelAndView produtoPost(@ModelAttribute(name = "product") Produto produto, @RequestParam("file") MultipartFile file) { 
		System.out.println("Produto Post acionado");
		if (file.isEmpty()) {
			System.out.println("Please select a file to upload");
        } else { 
			produto.setFoto(retrieveImage(file));
        }
		repository.save(produto);
		Produto p = new Produto();
		return new ModelAndView("produto", "product", p);
	}

	@RequestMapping(path = {"/produto", "/produto/{id}"}, method=RequestMethod.GET)
	public ModelAndView produtoGet(@PathVariable(name = "id") Optional<Long> id) {
		ModelAndView model = new ModelAndView("produto");
		Optional<Produto> p = Optional.empty();
		if (id.isPresent()) { 
			System.out.printf("Produto %d sendo pesquisado\n", id.get());
			p = repository.findById(id.get());
		} 
		model.addObject("products", repository.findAll());
		model.addObject("product", p.orElse(new Produto()));
		return model;
	}

	@RequestMapping("/produtos")
	public ModelAndView produtos() {
		System.out.println("Produtos acionado");
		String message = "<h1>Hello World by Servlet</h1>";
		return new ModelAndView("produtos", "message", message);
	}

	@RequestMapping("/ponto_venda")
	public ModelAndView pontoVenda() {
		System.out.println("Ponto de venda acionado");
		String message = "<h1>Hello World by Servlet</h1>";
		return new ModelAndView("ponto_venda", "message", message);
	}

	public byte[] retrieveImage(MultipartFile foto) { 
		try { 
			byte barr[]=foto.getBytes();
			return barr;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}

}