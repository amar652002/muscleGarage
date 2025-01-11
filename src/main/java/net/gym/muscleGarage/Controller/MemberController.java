package net.gym.muscleGarage.Controller;


import net.gym.muscleGarage.Entity.MemberEntity;
import net.gym.muscleGarage.Repository.MemberRepository;
import net.gym.muscleGarage.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @PostMapping("member")
    public ResponseEntity<Void> addMember(@RequestBody MemberEntity member){
        memberService.saveMember(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping( "member")
    public List<MemberEntity> getMembers(){
        return memberService.findAllMembers();
    }

    @GetMapping("member/{id}")
    public ResponseEntity<MemberEntity> getMemberById(@PathVariable Integer id){
        Optional<MemberEntity> memberFound = memberService.findMemberById(id);
        return memberFound
                .map(member -> new ResponseEntity<>(member, HttpStatus.OK))
                .orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("member/{id}")
    public ResponseEntity<MemberEntity> memberEnquiry(@PathVariable Integer id, @RequestBody MemberEntity updatedMember){
        MemberEntity member = memberService.updateMemberById(id, updatedMember);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }

    @DeleteMapping("member/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id){
        memberService.deleteMemberById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
