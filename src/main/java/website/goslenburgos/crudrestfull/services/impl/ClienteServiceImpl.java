 package website.goslenburgos.crudrestfull.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import website.goslenburgos.crudrestfull.exception.ResourceNotFoundException;
import website.goslenburgos.crudrestfull.model.Cliente;
import website.goslenburgos.crudrestfull.repository.ClienteRepository;
import website.goslenburgos.crudrestfull.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepositorio;
	
	public ClienteServiceImpl(ClienteRepository clienteRepositorio) {
		super();
		this.clienteRepositorio = clienteRepositorio;
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente getClienteById(long id) {
		return clienteRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cliente","Id",id));
	}

	@Override
	public void deleteCliente(long id) {
		
		clienteRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cliente", "Id", id));
		clienteRepositorio.deleteById(id);
		
	}

	@Override
	public Cliente updateCliente(Cliente cliente, long id) {
		Cliente existcliente=clienteRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cliente","Id",id));
		existcliente.setNombre(cliente.getNombre());
		existcliente.setApellido(cliente.getApellido());
		existcliente.setDireccion(cliente.getDireccion());
		existcliente.setTelefono(cliente.getTelefono());
		
		clienteRepositorio.save(existcliente);		
		return existcliente;
	}
	
}
