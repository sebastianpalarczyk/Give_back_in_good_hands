package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.Institution;
import com.project.give_back_in_good_hands.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> institutions(){
        return institutionRepository.findAll();
    }

    public Optional<Institution> findInstitutionById(Long id){
        return institutionRepository.findById(id);
    }

    public void save(Institution institution){
        institutionRepository.save(institution);
    }

    public void delete(Institution institution){
        institutionRepository.delete(institution);
    }
}
