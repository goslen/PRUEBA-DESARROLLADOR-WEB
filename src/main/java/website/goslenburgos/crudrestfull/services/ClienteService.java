package website.goslenburgos.crudrestfull.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import website.goslenburgos.crudrestfull.model.Cliente;

@Repository
public interface ClienteService {
	Cliente saveCliente(Cliente cliente);
	List<Cliente> getAllClientes();
	Cliente getClienteById(long id);
	Cliente updateCliente(Cliente cliente, long id);
	void deleteCliente(long id);
}
