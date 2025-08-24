package com.whoisdm.characterFolder.service.characters;

import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import com.whoisdm.characterFolder.model.characters.RegistrationCharacter;

import java.util.List;

public interface CharacterService {
    List<FolderCharacter> findAllByUsername(String username);
    FolderCharacter saveCharacter(RegistrationCharacter regCharacter, String username);
}
