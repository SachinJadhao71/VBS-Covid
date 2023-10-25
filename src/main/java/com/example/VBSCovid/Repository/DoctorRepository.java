package com.example.VBSCovid.Repository;

import com.example.VBSCovid.Model.Doctor;
import com.example.VBSCovid.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    public Doctor findByEmailId(String email);
}
