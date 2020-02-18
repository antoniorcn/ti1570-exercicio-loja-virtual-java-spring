package edu.curso.supermarket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.curso.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
