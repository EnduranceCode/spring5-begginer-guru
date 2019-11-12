package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService {

    Owner save(Owner owner);

    Set<Owner> findAll();

    Owner findByID(Long id);

    Owner findByLastName(String lastName);
}
