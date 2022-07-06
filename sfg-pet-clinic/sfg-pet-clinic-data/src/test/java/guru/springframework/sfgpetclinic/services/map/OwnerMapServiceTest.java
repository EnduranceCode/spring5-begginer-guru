package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import guru.springframework.sfgpetclinic.model.Owner;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;
    String lastName = "Doe";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).firstName("Joe").lastName(lastName).build());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).firstName("Jane").lastName(lastName).build();

        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(owner, savedOwner);
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();

        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findByID() {
        Owner owner = ownerMapService.findByID(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("Joe");

        assertNull(owner);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findByID(1L));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByID() {
        ownerMapService.deleteByID(1L);

        assertEquals(0, ownerMapService.findAll().size());
    }
}
