package com.visionaryCrofting.demo.ressources;


import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.service.implementation.CommandServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Command")
public class CommandContrroler {

    public final CommandServiceImp commandService;
    @Autowired
    public CommandContrroler(CommandServiceImp commandService) {
        this.commandService = commandService;
    }
    @GetMapping("/all")
    public List<Commande> getAllCommande(){
        return commandService.getAllCommande();
    }
    @GetMapping("/id/{id}")
    public Commande getCommandeById(@PathVariable("id") Long id){
        return commandService.getCommandeById(id);
    }
    @GetMapping("/ref/{ref}")
    public Commande getCommandeByRef(@PathVariable("ref") String ref){
        return commandService.getCommandeByRef(ref);
    }
    @PostMapping("/add")
    public Commande addCommande(@RequestBody Commande commande){
        return commandService.addCommande(commande);
    }
    @DeleteMapping("/id/{id}")
    public String deleteCommande(@PathVariable("id") Long id){
        return commandService.deleteCommande(id);
    }
}
