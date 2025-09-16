package com.whoisdm.characterFolder.service.characters;

import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import com.whoisdm.characterFolder.model.characters.RegistrationCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CharacterService {
    Page<FolderCharacter> findAllByUsername(String username, Pageable pageable);
    FolderCharacter saveCharacter(RegistrationCharacter regCharacter, String username);
    FolderCharacter findCharacterById(int id);
}
