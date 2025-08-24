package com.whoisdm.characterFolder.dao.character;

import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<FolderCharacter, Integer> {
    List<FolderCharacter> findAllByUsername(String username);
}
