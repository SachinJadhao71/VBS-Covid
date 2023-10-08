package com.example.VBSCovid.Repository;

import com.example.VBSCovid.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    public Person findByEmailId(String email);
}
