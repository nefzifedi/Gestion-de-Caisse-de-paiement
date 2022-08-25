package com.caisse.caisse.repo;

import com.caisse.caisse.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepo extends JpaRepository<Produit,Long> {

  //  void deleteProduitById(Long id);

    Optional<Produit> findProduitById(Long id);
}
