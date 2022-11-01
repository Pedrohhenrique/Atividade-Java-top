package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.repository.Repository;
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
    public String  deleteCliente(@PathVariable Long id){
        try{
            Optional<Cliente> cliente = Optional.of(resposity.getById(id));

            if(cliente.isPresent()){
                resposity.deleteById(id);
                return "Cliente de " + id +" deletado com sucesso!";
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            e.printStackTrace();
            return "O cliente de" +id + " Não existe para ser deletado!"+
                    " Por favor, entre em contato com o atendimento 231 546 884";
        }
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
