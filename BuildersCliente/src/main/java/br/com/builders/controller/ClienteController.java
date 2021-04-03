package br.com.builders.controller;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.builders.dto.ClienteDTO;
import br.com.builders.dto.ResponseDTO;
import br.com.builders.filter.ClienteFiltro;
import br.com.builders.model.Cliente;
import br.com.builders.service.ClienteService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


/**
 * Controller para disponibilizar os serviços de CRUD de Cliente.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/cliente", produces = "application/json")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@ApiResponse(description = "Operação para criar um cliente.")
	@RequestMapping(value="/criar", method = {RequestMethod.POST})
	public ResponseEntity<ResponseDTO> criarCliente(@RequestBody ClienteDTO cliente) throws Exception  {
		ResponseDTO dto = new ResponseDTO();
		try {
			ClienteDTO c = clienteService.criar(cliente);
			dto.setData(c);
			dto.setMessage("Cliente criado com sucesso");
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			dto.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
		}
	}
	
	@ApiResponse(description = "Operação para alterar os dados de um cliente.")
	@RequestMapping(value="/alterar", method = {RequestMethod.PUT})
	public ResponseEntity<ResponseDTO> alterarCliente(@RequestBody ClienteDTO cliente) throws Exception  {
		ResponseDTO dto = new ResponseDTO();
		try {
			ClienteDTO c = clienteService.alterar(cliente);
			dto.setData(c);
			dto.setMessage("Cliente alterador com sucesso");
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			dto.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
		}
	}
	
	@ApiResponse(description = "Operação para listar os clientes.")
	@RequestMapping(value="/listar", method = {RequestMethod.GET})
	public Page<Cliente> listarClientes(@RequestParam(value="q") String q, Pageable page) throws Exception  {
		try {
			ClienteFiltro filtro = null;
			if (StringUtils.isNotBlank(q)) {
				filtro = new Gson().fromJson(q, ClienteFiltro.class);
			}
			return clienteService.listarClientes(filtro, page);
		} catch (Exception e) {
			return new PageImpl<Cliente>(Collections.emptyList());
		}
	}
	
	@ApiResponse(description = "Operação para listar os clientes. Envio de filtro via body.")
	@RequestMapping(value="/listar/body", method = {RequestMethod.GET})
	public Page<Cliente> listarClientesBody(@RequestBody ClienteFiltro filtro, Pageable page) throws Exception  {
		try {
			return clienteService.listarClientes(filtro, page);
		} catch (Exception e) {
			return new PageImpl<Cliente>(Collections.emptyList());
		}
	}
}
