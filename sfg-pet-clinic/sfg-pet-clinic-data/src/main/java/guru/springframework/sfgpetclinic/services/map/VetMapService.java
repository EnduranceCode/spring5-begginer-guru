package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Autowired
    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            if (vet.getSpecialities() != null) {
                checkSpecialtiesIDs(vet);
            }

            return super.save(vet);
        } else {
            return null;
        }
    }

    private void checkSpecialtiesIDs(Vet vet) {
        vet.getSpecialities().forEach(speciality -> {
            if (speciality.getId() == null) {
                Speciality savedSpecialty = specialtyService.save(speciality);
                speciality.setId(savedSpecialty.getId());
            }
        });
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
