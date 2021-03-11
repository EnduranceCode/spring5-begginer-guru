package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = Logger.getLogger(DataLoader.class.getName());

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        super();
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(ownerService.findAll().isEmpty()) {
            ArrayList<PetType> loadedPetTypes = loadPetTypeData();
            loadOwnerData(loadedPetTypes);

            ArrayList<Speciality> loadedSpecialties = loadSpecialtiesData();
            loadVetsData(loadedSpecialties);

            logger.log(Level.INFO, "Finished loading Bootstrap Data");
        }
    }

    private ArrayList<PetType> loadPetTypeData() {
        ArrayList<PetType> savedPetTypes = new ArrayList<>();

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        savedPetTypes.add(savedDogPetType);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        savedPetTypes.add(savedCatPetType);

        logger.log(Level.INFO, "Loaded Pet Types Data...");

        return savedPetTypes;
    }

    private void loadOwnerData(ArrayList<PetType> savedPetTypes) {
        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Michael");
        ownerOne.setLastName("Weston");
        ownerOne.setAddress("1600 Pennsylvania Avenue, N.W.");
        ownerOne.setCity("Washington");
        ownerOne.setTelephone("202-456-1111");

        Pet ownerOnePet = new Pet();
        ownerOnePet.setPetType(savedPetTypes.get(0));
        ownerOnePet.setName("Rosco");
        ownerOnePet.setBirthDate(LocalDate.now());
        ownerOnePet.setOwner(ownerOne);
        ownerOne.getPets().add(ownerOnePet);

        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Fiona");
        ownerTwo.setLastName("Glenanne");
        ownerTwo.setAddress("Westminster");
        ownerTwo.setCity("London");
        ownerTwo.setTelephone("(0)20 7930 4832");

        Pet ownerTwoPet = new Pet();
        ownerTwoPet.setPetType(savedPetTypes.get(1));
        ownerTwoPet.setName("Royal");
        ownerTwoPet.setBirthDate(LocalDate.now());
        ownerTwoPet.setOwner(ownerTwo);
        ownerTwo.getPets().add(ownerOnePet);

        ownerService.save(ownerTwo);

        logger.log(Level.INFO, "Loaded Owners Data...");
    }

    private ArrayList<Speciality> loadSpecialtiesData() {
        ArrayList<Speciality> savedSpecialties = new ArrayList<>();

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);
        savedSpecialties.add(savedRadiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);
        savedSpecialties.add(savedSurgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);
        savedSpecialties.add(savedDentistry);

        logger.log(Level.INFO, "Loaded Specialties Data...");

        return savedSpecialties;
    }

    private void loadVetsData(ArrayList<Speciality> specialities) {
        Vet vetOne = new Vet();
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetOne.getSpecialities().add(specialities.get(0));
        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Jessie");
        vetTwo.setLastName("Porter");
        vetTwo.getSpecialities().add(specialities.get(1));
        vetService.save(vetTwo);

        logger.log(Level.INFO, "Loaded Vets Data...");
    }
}
