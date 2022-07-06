package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    private static final String LAST_NAME = "Doe";

    Owner owner;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSpringDataJpaService ownerSpringDataJpaService;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).firstName("Joe").lastName(LAST_NAME).build();
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);

        assertNotNull(ownerSpringDataJpaService.save(any()));
        assertEquals(owner, ownerSpringDataJpaService.save(any()));
        verify(ownerRepository, times(2)).save(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> serviceOwners = ownerSpringDataJpaService.findAll();

        assertNotNull(serviceOwners);
        assertEquals(2, serviceOwners.size());
    }

    @Test
    void findByID() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(owner));

        Owner serviceOwner = ownerSpringDataJpaService.findByID(1L);

        assertNotNull(serviceOwner);
        assertEquals(LAST_NAME, serviceOwner.getLastName());
    }

    @Test
    void findByIDNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner serviceOwner = ownerSpringDataJpaService.findByID(1L);

        assertNull(serviceOwner);
    }

    @Test
    void delete() {
        ownerSpringDataJpaService.delete(owner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteByID() {
        ownerSpringDataJpaService.deleteByID(anyLong());

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.ofNullable(owner));

        Owner ownerByLastName = ownerSpringDataJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, ownerByLastName.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}
