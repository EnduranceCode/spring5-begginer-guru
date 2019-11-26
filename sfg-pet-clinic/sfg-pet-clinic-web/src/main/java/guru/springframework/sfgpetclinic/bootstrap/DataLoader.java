package guru.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner ownerOne = new Owner();
        ownerOne.setId(1L);
        ownerOne.setFirstName("Michael");
        ownerOne.setLastName("Weston");
        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setId(2L);
        ownerTwo.setFirstName("Fiona");
        ownerTwo.setLastName("Glenanne");
        ownerService.save(ownerTwo);
        
        System.out.println("Loaded Owners...");
        
        Vet vetOne = new Vet();
        vetOne.setId(1L);
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetService.save(vetOne);
        
        Vet vetTwo = new Vet();
        vetTwo.setId(1L);
        vetTwo.setFirstName("Jessie");
        vetTwo.setLastName("Porter");
        vetService.save(vetTwo);
        
        System.out.println("Loaded Vets...");
    }
}
