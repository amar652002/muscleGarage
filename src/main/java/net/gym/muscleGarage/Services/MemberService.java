package net.gym.muscleGarage.Services;

import jakarta.persistence.EntityNotFoundException;
import net.gym.muscleGarage.Entity.EquipmentEntity;
import net.gym.muscleGarage.Entity.MemberEntity;
import net.gym.muscleGarage.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //save member
    public void saveMember(MemberEntity member) {
        memberRepository.save(member);
    }

    //find members
    public List<MemberEntity> findAllMembers() {
        return memberRepository.findAll();
    }

    //find member by id
    public Optional<MemberEntity> findMemberById(Integer id) {
        return memberRepository.findById(id);
    }

    //update member by id
    public MemberEntity updateMemberById(Integer id, MemberEntity updatedMember) {
        return memberRepository.findById(id)
                .map(existingMember -> {
                    existingMember.setName(updatedMember.getName());
                    existingMember.setPhno(updatedMember.getPhno());
                    existingMember.setEmail(updatedMember.getEmail());
                    existingMember.setAge(updatedMember.getAge());
                    existingMember.setGender(updatedMember.getGender());
                    
                    return memberRepository.save(existingMember);
                })
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + id));
    }

    //delete member by id
    public void deleteMemberById(Integer id) {
        memberRepository.deleteById(id);
    }

}
