package com.whoisdm.characterFolder.dao.character;

import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<FolderCharacter, Integer> {
    Page<FolderCharacter> findAllByUsername(String username, Pageable pageable);
}
