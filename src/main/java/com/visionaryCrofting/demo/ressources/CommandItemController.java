package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.service.CommanItemService;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/commandItem")
public class  CommandItemController {
    @Autowired
    private CommanItemService commanItemService;

    @GetMapping("/id/{id}")
    public Optional<CommandeItem> getByID(Long id) {return commanItemService.getById(id);}

    @GetMapping("/")
    public List<CommandeItem> getAll() {
        return commanItemService.getAll();
    }

    @GetMapping("/count")
    public int count() {
        return commanItemService.count();
    }

    @PostMapping("/")
    public CommandeItem save(@RequestBody CommandeItem commandeItem) {
        return  commanItemService.save(commandeItem);
    }

    @PutMapping("/")
    public CommandeItem update(@RequestBody CommandeItem commandeItem) {return (CommandeItem) commanItemService.update(commandeItem);}

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable Long id) {
        commanItemService.deleteById(id);
    }
}
