package com.whoisdm.characterFolder.service.characters;

import com.whoisdm.characterFolder.dao.character.CharacterRepository;
import com.whoisdm.characterFolder.dao.character.ClassRepository;
import com.whoisdm.characterFolder.model.characters.CharacterClass;
import com.whoisdm.characterFolder.model.characters.CharacterStats;
import com.whoisdm.characterFolder.model.characters.FolderCharacter;
import com.whoisdm.characterFolder.model.characters.RegistrationCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final ClassRepository classRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, ClassRepository classRepository) {
        this.characterRepository = characterRepository;
        this.classRepository = classRepository;
    }

    @Override
    public Page<FolderCharacter> findAllByUsername(String username, Pageable pageable) {
        return characterRepository.findAllByUsername(username, pageable);
    }

    @Transactional
    @Override
    public FolderCharacter saveCharacter(RegistrationCharacter regCharacter, String username) {
        FolderCharacter folderCharacter = new FolderCharacter();
        folderCharacter.setName(regCharacter.getName());
        folderCharacter.setDescription(regCharacter.getDescription());
        folderCharacter.setBackstory(regCharacter.getBackstory());
        folderCharacter.setUsername(username);

        CharacterStats characterStats = new CharacterStats(regCharacter.getStatsList());
        folderCharacter.setCharacterStats(characterStats);

        CharacterClass characterClass = findClassByName(regCharacter.getClassName());
        folderCharacter.setCharacterClass(characterClass);

        return characterRepository.save(folderCharacter);
    }

    private CharacterClass findClassByName(String name) {
        Optional<CharacterClass> characterClass = classRepository.findById(name);
        return characterClass.orElse(null);
    }

    @Override
    public FolderCharacter findCharacterById(int id) {
        return characterRepository.findById(id).orElse(null);
    }
}
