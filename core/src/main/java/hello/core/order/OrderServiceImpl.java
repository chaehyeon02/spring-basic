package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자 주입
    //@RequiredArgsConstructor가 이 코드를 만들어줌
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }









    //수정자 의존관계
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberID);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberID, itemName, itemPrice, discountPrice);
    }

    //강의 5-5-1
    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
