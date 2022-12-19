package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/client")
public class ClientRessource {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{client_id}")
    public Optional<Client> getClientById(@PathVariable Long client_id){
        Optional<Client> client = clientService.getOnById(client_id);
        if(client.isPresent()){
            return client;
        }else{
            throw new IllegalStateException("Id non trouvé");
        }
    }

    @PostMapping("/")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PutMapping("{client_id}")
    public Client updateClient(@PathVariable Long client_id,@RequestBody Client client){
        return clientService.updateClient(client_id,client);
    }
}
