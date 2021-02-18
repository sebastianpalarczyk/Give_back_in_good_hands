package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.Donation;
import com.project.give_back_in_good_hands.domain.User;
import com.project.give_back_in_good_hands.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public long sumOffAll(){
      return donationRepository.count();
    }

    public void save(Donation donation){
        donationRepository.save(donation);
    }

    public List<Donation> all(){
        return donationRepository.findAll();
    }

    public List<Donation> allDonationsByUser(User user){
        return donationRepository.findAllByUser(user);
    }

    public void delete(Donation donation){
        donationRepository.delete(donation);
    }

    public List<Donation> receivedDonations(List<Donation> donations){
        return donations.stream()
                .filter(Donation::isReceived)
                .sorted(Comparator.comparing(Donation::getDateReceived))
                .sorted(Comparator.comparing(Donation::getCreatedDate))
                .collect(Collectors.toList());
    }

    public List<Donation> noReceivedDonations(List<Donation> donations){
        return donations.stream()
                .filter(e-> !e.isReceived())
                .collect(Collectors.toList());
    }

    public Donation findById(Long id){
        return donationRepository.findById(id).get();
    }


}
