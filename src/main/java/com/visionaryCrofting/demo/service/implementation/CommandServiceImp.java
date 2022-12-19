package com.visionaryCrofting.demo.service.implementation;
import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.visionaryCrofting.demo.service.CommandService;

import java.util.List;

@Service
public class CommandServiceImp implements CommandService{
    @Autowired
    CommandeRepository commandeRepository;
    // get all commande
    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }
    // get commande by id
    public Commande getCommandeById(Long id){
        Commande stest = commandeRepository.findById(id).orElse(null);
        if (stest == null){
            throw new IllegalStateException("Commande not found");
        }else{
            return stest;
        }
    }
    // get commande by ref
    public Commande getCommandeByRef(String ref){
        return commandeRepository.findByRef(ref);
    }
    // add commande
    public Commande addCommande(Commande commande){
        // checkin if commande exist
        if (commandeRepository.findByRef(commande.getRef()) != null){
            throw new IllegalStateException("Commande existe déja");
            // checking if command values are empty
        }else if (commande.getRef() == null || commande.getRef().isEmpty() || commande.getRef().isBlank()){
            throw new IllegalStateException("please fill all the inputs");
        }else{
            return commandeRepository.save(commande);
        }
    }
    // delete commande
    public String deleteCommande(Long id){
        commandeRepository.deleteById(id);
        return "Commande deleted";
    }
}
