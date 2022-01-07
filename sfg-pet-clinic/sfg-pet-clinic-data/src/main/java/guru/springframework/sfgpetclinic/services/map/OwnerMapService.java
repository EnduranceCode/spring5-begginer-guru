package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    @Autowired
    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner owner) {

        if (owner != null) {
            if (owner.getPets() != null) {
                checkPetsIDs(owner);
            }

            return super.save(owner);
        } else {
            return null;
        }
    }

    private void checkPetsIDs(Owner owner) {
        owner.getPets().forEach(pet -> {
            if (pet.getPetType() != null) {
                if (pet.getPetType().getId() == null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }
            } else {
                throw new RuntimeException("Pet Type is required");
            }

            if (pet.getId() == null) {
                pet.setId(petService.save(pet).getId());
            }
        });
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
