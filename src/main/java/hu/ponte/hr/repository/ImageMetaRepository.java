package hu.ponte.hr.repository;

import hu.ponte.hr.controller.ImageMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageMetaRepository extends JpaRepository<ImageMeta,String> {
    Optional<ImageMeta> findById(String id);
}
