package com.caisse.caisse.service;

import com.caisse.caisse.exception.ProduitNotFoundException;
import com.caisse.caisse.model.Produit;
import com.caisse.caisse.repo.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitService {
    @Autowired
    private   ProduitRepo produitRepo;

    @Autowired
    public ProduitService(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }


    public Produit addProduit(Produit produit) {
        produit.setProduitCode(UUID.randomUUID().toString());
        return this.produitRepo.save(produit);
    }


    public List<Produit> findAllProduit(){
        return produitRepo.findAll();
    }

    public Produit updateProduit(Produit produit){
        return produitRepo.save(produit);
    }

    public Produit findProduitByID(Long id) {
        return produitRepo.findProduitById(id)
                .orElseThrow(() -> new ProduitNotFoundException("produit by id" + id + "was not found"));
    }


    public void deleteProduit(Long id){
       Produit produit=this.findProduitByID(id);
        produitRepo.delete(produit);
          }


    }






