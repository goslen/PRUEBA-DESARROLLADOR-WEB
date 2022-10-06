package website.goslenburgos.crudrestfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import website.goslenburgos.crudrestfull.model.Cliente;
import website.goslenburgos.crudrestfull.services.ClienteService;

@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private ClienteService clienteServicio;
	
	private ClienteController(ClienteService clienteServicio) {
		super();
		this.clienteServicio = clienteServicio;
	}
	
	//Constructor para crear clientes
	@GetMapping("/nuevo-cliente")
	public String Agregar(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "form";
	}
	@PostMapping("/guardar")
	public String saveCliente(Cliente cliente, Model model) {
		clienteServicio.saveCliente(cliente);
		return "redirect:/api/clientes";
	}
	
	//Constructor para obtener todos los clientes	
	@GetMapping("/api/clientes")
	public String getAllClientes(Model model) {
		List<Cliente>clientes=clienteServicio.getAllClientes();
		model.addAttribute("clientes", clientes);
		return "index";
	}
	
	//Constructor para actualizar los datos de losClientes
	@PutMapping("{id}")
	public ResponseEntity<Cliente>updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteServicio.updateCliente(cliente, id),HttpStatus.OK);
	}

	/*@Mapping("/deleteclient")
	public ResponseEntity<String>deleteCliente(@PathVariable("id") long id){
		
		clienteServicio.deleteCliente(id);
		return new ResponseEntity<String>("redirect:/api/clientes",HttpStatus.OK);
		
	}*/
	
	
	//Constructor para eliminar registros de clientes
		@GetMapping("/deleteclient")
		public String deleteCliente(){
			return "deleteclien";
		}
		
		@DeleteMapping("/eliminated")
		public ResponseEntity<String>deleteCliente(@PathVariable("id") long id){
			return new ResponseEntity<String>("redirect:/api/clientes",HttpStatus.OK);
		}
	
}
