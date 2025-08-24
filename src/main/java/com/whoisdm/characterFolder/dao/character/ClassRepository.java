package com.whoisdm.characterFolder.dao.character;

import com.whoisdm.characterFolder.model.characters.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<CharacterClass, String> {
}
