package com.caisse.caisse;

import com.caisse.caisse.model.Produit;
import com.caisse.caisse.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitResource {
    private  final ProduitService produitService;

    public ProduitResource(ProduitService produitService) {
        this.produitService = produitService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getAllProduits () {
        List<Produit> produits = produitService.findAllProduit();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity <Produit> getProduitById(@PathVariable("id") Long id) {
        Produit produit = produitService.findProduitByID(id);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
        Produit newEmployee = produitService.addProduit(produit);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Produit> updateProduit(@RequestBody Produit produit) {
        Produit updateEmployee = produitService.updateProduit(produit);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return  ResponseEntity.ok().body("produit was deleted successfully");
    }
}
