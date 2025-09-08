package com.whoisdm.characterFolder.service.characters;

import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import com.whoisdm.characterFolder.model.characters.RegistrationCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CharacterService {
    List<FolderCharacter> findAllByUsername(String username);
    Page<FolderCharacter> findAllByUsername(String username, Pageable pageable);
    FolderCharacter saveCharacter(RegistrationCharacter regCharacter, String username);
}
