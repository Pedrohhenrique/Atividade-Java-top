package com.example.demo;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1")

public class Controller {

    @Autowired
    Repository resposity;

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente)
    {
        Cliente clienteSaved = resposity.save(cliente);
        return clienteSaved;
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> clienteReturned = resposity.findById(id);
        return clienteReturned;
    }
    @DeleteMapping("/id")
    public void  deleteCliente(@PathVariable Long id){
        resposity.deleteById(id);
    }
    @GetMapping
    public List<Cliente> listClientes(){
        return resposity.findAll();
    }
    @PutMapping("/atualize/{id}")
    public String updateClienteById(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
     Optional<Cliente> velhoCliente = resposity.findById(id);
     if(velhoCliente.isPresent()){
        Cliente cliente = velhoCliente.get();
        cliente.setEndereco(clienteDTO.getEndereco());
        resposity.save(cliente);
        return "Cliente de id" + cliente.getId() + "   autualizado com sucesso!";
     }else{
            return "cliente de id" + id + "não existe!";
         }
    }
}
